package com.github.hackbangalore.skilingbackend.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hackbangalore.skilingbackend.dtos.GitHubResponseDTO;
import com.github.hackbangalore.skilingbackend.dtos.UserResponseDto;
import com.github.hackbangalore.skilingbackend.exceptions.InvalidGitHubAccount;
import com.github.hackbangalore.skilingbackend.exceptions.InvalidLinkedInAccount;
import com.github.hackbangalore.skilingbackend.models.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    public UserResponseDto getUser(String userId) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("user").document(userId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User user;
        if (document.exists()) {
            user = document.toObject(User.class);
            return new UserResponseDto(user);
        }
        return null;
    }
   public UserResponseDto createUser(User user) throws ExecutionException, InterruptedException {
        validateUserGitHub(user);
       Firestore dbFireStore = FirestoreClient.getFirestore();
       DocumentReference documentReference = dbFireStore.collection("user").document(String.valueOf(user.getUserId()));
       ApiFuture<WriteResult> collectionsApiFuture = documentReference.set(user);
       // Wait for the write to complete
       collectionsApiFuture.get();
       return new UserResponseDto(user);
    }

    private void validateUserGitHub(User user) {
        RestTemplate restTemplate = new RestTemplate();
        String[] linkSplit = user.getGithubLink().split("/");
        String link = "https://api.github.com/users/" + linkSplit[linkSplit.length - 1] + "/repos";
        ResponseEntity<String> response = restTemplate.getForEntity(link, String.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new InvalidGitHubAccount("Invalid GitHub Account");
        }
        ResponseEntity<GitHubResponseDTO[]> dto = restTemplate.getForEntity(link, GitHubResponseDTO[].class);
        Set<String> languageSet = new HashSet<>();
        if (dto.getBody() == null) {
            return;
        }
        List<String> languageList = new LinkedList<>();
        for (GitHubResponseDTO gitHubResponseDTO : dto.getBody()) {
            String langLink = gitHubResponseDTO.getLanguages_url();
            fetchLanguages(langLink, languageList);
        }

        for (String lang : languageList) {
            languageSet.add(lang);
        }

        user.setGitHubLanguages(new LinkedList<>());
        for (String lang : languageSet) {
            if (user.getGitHubLanguages() == null){
                continue;
            }
            user.getGitHubLanguages().add(lang);
        }
    }

    private void fetchLanguages(String langLink, List<String> languageList) {
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject(langLink, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            Iterator<String> fieldNames = jsonNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                languageList.add(fieldName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserResponseDto updateUser(User user){
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("user").document(String.valueOf(user.getUserId())).set(user);
        return new UserResponseDto(user);
    }
    public void deleteUser(String userId) {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFireStore.collection("user").document(userId).delete();
    }
}

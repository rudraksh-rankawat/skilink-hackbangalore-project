package com.github.hackbangalore.skilingbackend.services;

import com.github.hackbangalore.skilingbackend.dtos.UserResponseDto;
import com.github.hackbangalore.skilingbackend.models.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

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
       Firestore dbFireStore = FirestoreClient.getFirestore();
       DocumentReference documentReference = dbFireStore.collection("user").document(String.valueOf(user.getUserId()));
       ApiFuture<WriteResult> collectionsApiFuture = documentReference.set(user);
       // Wait for the write to complete
       collectionsApiFuture.get();
       return new UserResponseDto(user);
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

package com.github.hackbangalore.skilingbackend.services;

import com.github.hackbangalore.skilingbackend.models.Project;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ProjectService {
    public Project getProject(String proj_id) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("project").document(proj_id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Project project;
        if (document.exists()) {
            project = document.toObject(Project.class);
            return project;
        }
        return null;
    }

    public Project createProject(Project project) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("project").document(String.valueOf(project.getProj_id()));
        ApiFuture<WriteResult> collectionsApiFuture = documentReference.set(project);
        // Wait for the write to complete
        collectionsApiFuture.get();
        return project;
    }

    public Project updateUser(Project project){
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("project").document(String.valueOf(project.getProj_id())).set(project);
        return project;
    }
    public void deleteUser(String userId) {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFireStore.collection("project").document(userId).delete();
    }
}

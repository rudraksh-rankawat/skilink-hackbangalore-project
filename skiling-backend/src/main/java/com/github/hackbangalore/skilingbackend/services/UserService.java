package com.github.hackbangalore.skilingbackend.services;

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


    public User getUser(String userId) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("user").document(userId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User user;
        if (document.exists()) {
            user = document.toObject(User.class);
            return user;
        }
        return null;
    }
   public User createUser(User user) throws ExecutionException, InterruptedException {
       Firestore dbFireStore = FirestoreClient.getFirestore();
       DocumentReference documentReference = dbFireStore.collection("user").document(user.getName());
       ApiFuture<WriteResult> collectionsApiFuture = documentReference.set(user);
       // Wait for the write to complete
       collectionsApiFuture.get();
       return user;
    }
}

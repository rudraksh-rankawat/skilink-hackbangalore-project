package com.github.hackbangalore.skilingbackend.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;

@Repository
public class FireBase {
    public FireBase() throws Exception{
        ClassPathResource service = new ClassPathResource("serviceAccountKey.json");
        FileInputStream serviceAccount =
                new FileInputStream(service.getFile().getAbsolutePath());


        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();


        FirebaseApp.initializeApp(options);
    }
}

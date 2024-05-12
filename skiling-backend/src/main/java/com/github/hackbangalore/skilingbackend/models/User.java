package com.github.hackbangalore.skilingbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String userPicLink;
    private String name;
    private String email;
    private String githubLink;
    private String linkedinLink;
    private String password;
    private UserType userType;
    private List<UserProject> userProjects;
    private List<String> skills;
    private List<String> gitHubLanguages;
    private String aiAnalysis; // this analysis will be around 100 - 200 words long
}

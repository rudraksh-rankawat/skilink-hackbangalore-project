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
    private String userId;
    private String userPicLink;
    private String name;
    private String email;
    private String githubLink;
    private String linkedinLink;
    private UserType userType;
    private List<Project> projects;
    private List<String> skills;
}

package com.github.hackbangalore.skilingbackend.dtos;

import com.github.hackbangalore.skilingbackend.models.User;
import com.github.hackbangalore.skilingbackend.models.UserProject;
import com.github.hackbangalore.skilingbackend.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String userPicLink;
    private String name;
    private String email;
    private String githubLink;
    private String linkedinLink;
    private UserType userType;
    private List<UserProject> userProjects;
    private List<String> skills;
    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.userPicLink = user.getUserPicLink();
        this.name = user.getName();
        this.email = user.getEmail();
        this.githubLink = user.getGithubLink();
        this.linkedinLink = user.getLinkedinLink();
        this.userType = user.getUserType();
        this.userProjects = user.getUserProjects();
        this.skills = user.getSkills();
    }
}

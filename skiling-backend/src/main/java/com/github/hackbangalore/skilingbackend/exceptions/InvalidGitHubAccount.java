package com.github.hackbangalore.skilingbackend.exceptions;

public class InvalidGitHubAccount extends RuntimeException {
    public InvalidGitHubAccount(String message) {
        super(message);
    }
}

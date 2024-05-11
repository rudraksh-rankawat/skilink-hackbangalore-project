package com.github.hackbangalore.skilingbackend.globalExceptionHandler;

import com.github.hackbangalore.skilingbackend.dtos.ExceptionDTO;
import com.github.hackbangalore.skilingbackend.exceptions.InvalidGitHubAccount;
import com.github.hackbangalore.skilingbackend.exceptions.InvalidLinkedInAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidGitHubAccount.class)
    public ResponseEntity<ExceptionDTO> handleInvalidGitHubAccount(InvalidGitHubAccount exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setResolution("Please provide a valid GitHub account");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidLinkedInAccount.class)
    public ResponseEntity<ExceptionDTO> handleInvalidLinkedInAccount(InvalidLinkedInAccount exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setResolution("Please provide a valid LinkedIn account");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}

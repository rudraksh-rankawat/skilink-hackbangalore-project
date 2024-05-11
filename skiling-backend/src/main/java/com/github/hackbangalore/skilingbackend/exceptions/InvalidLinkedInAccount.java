package com.github.hackbangalore.skilingbackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidLinkedInAccount extends RuntimeException{
    public InvalidLinkedInAccount(String message) {
        super(message);
    }
}

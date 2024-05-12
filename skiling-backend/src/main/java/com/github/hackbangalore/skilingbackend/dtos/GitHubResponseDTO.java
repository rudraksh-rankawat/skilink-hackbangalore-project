package com.github.hackbangalore.skilingbackend.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GitHubResponseDTO {
    private String name;
    private String fork;
    private String languages_url;
}

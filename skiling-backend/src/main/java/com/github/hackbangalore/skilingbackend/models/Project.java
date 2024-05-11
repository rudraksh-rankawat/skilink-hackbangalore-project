package com.github.hackbangalore.skilingbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private Long proj_id;
    private String proj_title;
    private String proj_desc;
    private List<String> skills;
    private List<Bid> bid;
}

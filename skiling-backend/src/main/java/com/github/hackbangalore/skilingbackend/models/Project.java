package com.github.hackbangalore.skilingbackend.models;

import java.util.List;

public class Project {
    private Long proj_id;
    private String proj_title;
    private String proj_desc;
    private List<String> skills;
    private List<Bid> bid;
}

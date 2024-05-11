package com.github.hackbangalore.skilingbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bid {
    private Long bid_id;
    private Long proj_id;
    private Long user_id;
    private Long bid_amount;
}

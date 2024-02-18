package com.okancezik.tubitak.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserScoreModelResponse {
    private String fullName;
    private int rank;
    private int point;
    private String avatarUrl;
}

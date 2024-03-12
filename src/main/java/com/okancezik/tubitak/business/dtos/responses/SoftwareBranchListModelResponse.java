package com.okancezik.tubitak.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoftwareBranchListModelResponse {

    private int id;
    private String name;
    private int point;
}

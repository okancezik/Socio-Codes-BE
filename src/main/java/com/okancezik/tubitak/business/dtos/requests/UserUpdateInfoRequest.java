package com.okancezik.tubitak.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateInfoRequest {
    private int id;
    private String fullName;
    private String bio;
    private String title;
}

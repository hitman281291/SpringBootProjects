package com.hitesh.module2_employee.dto;

import com.hitesh.module2_employee.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
    @NotBlank
    private String username;

    @NotBlank
    @ValidPassword
    private String password;
}

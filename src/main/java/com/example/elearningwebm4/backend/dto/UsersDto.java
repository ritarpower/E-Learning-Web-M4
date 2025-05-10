package com.example.elearningwebm4.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private Long userId;

    @NotBlank(message = "Không được để trống!")
    @Size(min = 5, max = 20, message = "Tên phải từ 5 đến 20 kí tự, không bao gồm số hay kí tự đặc biệt!")
    private String name;

    @NotBlank(message = "Không được để trống!")
    @Email(message = "Định đạng phải là email!")
    private String email;

    private String oldPassword;

    @NotBlank(message = "Không được để trống!")
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 kí tự!")
    private String password;

    @NotBlank(message = "Không được để trống!")
    private String confirmPassword;

    private LocalDateTime createAt;
}
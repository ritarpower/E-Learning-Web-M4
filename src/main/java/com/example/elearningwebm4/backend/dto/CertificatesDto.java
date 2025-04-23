package com.example.elearningwebm4.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificatesDto {
    private Long certificateId;
    private Long userId;
    private Long courseId;
    private LocalDateTime issueDate;
    private String certificateUrl;
}


package com.ahad.course_app.dto.studentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreationDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate birthday;
}

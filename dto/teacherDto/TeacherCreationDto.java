package com.ahad.course_app.dto.teacherDto;

import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDate;
@Data
public class TeacherCreationDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate birthday;
    @Lob
    private String about;
}

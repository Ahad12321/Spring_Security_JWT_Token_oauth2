package com.ahad.course_app.dto.lessonDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class LessonStudentDto {
    private String name;
    private String surname;
    private LocalDate birthday;
    private String email;
}

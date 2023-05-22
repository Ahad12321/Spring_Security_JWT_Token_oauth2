package com.ahad.course_app.dto.studentDto;

import com.ahad.course_app.dto.lessonDto.LessonDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class StudentDto {
    private String name;
    private String surname;
    private LocalDate birthday;
    private String email;
    private String password;
    private BigDecimal amount;
    private Set<StudentLessonDto> lessons;


}

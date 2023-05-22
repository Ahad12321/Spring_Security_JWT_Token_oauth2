package com.ahad.course_app.dto.lessonDto;

import com.ahad.course_app.dto.studentDto.StudentDto;
import com.ahad.course_app.dto.teacherDto.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
@Data
@AllArgsConstructor
@Builder
public class LessonDto {

    private String name;
    private BigDecimal price;
    private Set<StudentDto> students;
    private Set<TeacherDto> teachers;

}

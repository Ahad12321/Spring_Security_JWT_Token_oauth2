package com.ahad.course_app.dto.studentDto;

import com.ahad.course_app.dto.lessonDto.LessonTeacherDto;
import com.ahad.course_app.dto.teacherDto.TeacherDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;
@Builder
@Data
public class StudentLessonDto {
    private String name;
    private BigDecimal price;
    private Set<LessonTeacherDto> lessonTeacherDtos;
}

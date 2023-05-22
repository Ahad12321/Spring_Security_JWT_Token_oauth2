package com.ahad.course_app.dto.teacherDto;

import com.ahad.course_app.dto.lessonDto.LessonDto;
import com.ahad.course_app.model.Lesson;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@Builder
public class TeacherDto {

    private String name;
    private String surname;
    private String email;
    @Lob
    private String about;
    private Lesson lesson;
}

package com.ahad.course_app.dto.studentDto;

import com.ahad.course_app.dto.lessonDto.LessonTeacherDtoConverter;
import com.ahad.course_app.model.Lesson;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@Component
public class StudentLessonDtoConverter {
    private final LessonTeacherDtoConverter lessonTeacherDtoConverter;

    public StudentLessonDtoConverter(LessonTeacherDtoConverter lessonTeacherDtoConverter) {
        this.lessonTeacherDtoConverter = lessonTeacherDtoConverter;

    }
    public StudentLessonDto convert(Lesson from){
        return StudentLessonDto.builder().name(from.getName())
                .price(from.getPrice())
                .lessonTeacherDtos((from.getTeacher()).stream()
                        .map(lessonTeacherDtoConverter::convert1).collect(toSet()))
                .build();
    }
}

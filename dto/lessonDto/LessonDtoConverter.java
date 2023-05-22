package com.ahad.course_app.dto.lessonDto;

import com.ahad.course_app.model.Lesson;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toSet;

@Component
public class LessonDtoConverter {
    private final LessonTeacherDtoConverter lessonTeacherDtoConverter;
    private final LessonStudenDtoConverter lessonStudenDtoConverter;

    public LessonDtoConverter(LessonTeacherDtoConverter lessonTeacherDtoConverter, LessonStudenDtoConverter lessonStudenDtoConverter) {
        this.lessonTeacherDtoConverter = lessonTeacherDtoConverter;
        this.lessonStudenDtoConverter = lessonStudenDtoConverter;
    }
    public LessonDto convert(Lesson from){
        return LessonDto.builder().name(from.getName())
                .price(from.getPrice())
                .students((from.getStudent()).stream().map(lessonStudenDtoConverter::convert).collect(toSet()))
                .teachers((from.getTeacher()).stream().map(lessonTeacherDtoConverter::convert).collect(toSet())).build();

    }
}

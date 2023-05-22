package com.ahad.course_app.dto.lessonDto;

import com.ahad.course_app.model.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonCreationDtoConverter {
    public Lesson convert(LessonCreationDto from){
        return Lesson.builder()
                .name(from.getName())
                .price(from.getPrice()).build();
    }
}

package com.ahad.course_app.service;

import com.ahad.course_app.dto.lessonDto.*;
import com.ahad.course_app.dto.studentDto.StudentDtoConverter;
import com.ahad.course_app.model.Lesson;
import com.ahad.course_app.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final LessonDtoConverter lessonDtoConverter;
    private final LessonCreationDtoConverter lessonCreationDtoConverter ;

    public LessonService(LessonRepository lessonRepository, LessonDtoConverter lessonDtoConverter, LessonCreationDtoConverter lessonCreationDtoConverter) {
        this.lessonRepository = lessonRepository;
        this.lessonDtoConverter = lessonDtoConverter;

        this.lessonCreationDtoConverter = lessonCreationDtoConverter;
    }
    public Set<LessonDto> getAllLessons(){
        return lessonRepository.findAll().stream().map(lessonDtoConverter::convert).collect(Collectors.toSet());
    }

    public void createLesson(LessonCreationDto lesson) {
        Lesson lesson1=lessonCreationDtoConverter.convert(lesson);
        lessonRepository.save(lesson1);
    }
}

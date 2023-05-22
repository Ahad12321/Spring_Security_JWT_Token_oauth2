package com.ahad.course_app.controller;

import com.ahad.course_app.dto.lessonDto.LessonCreationDto;
import com.ahad.course_app.dto.lessonDto.LessonDto;
import com.ahad.course_app.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @GetMapping
    public Set<LessonDto>lessonDtos(){
        return lessonService.getAllLessons();
    }
    @PostMapping
    public HttpStatus create(@RequestBody LessonCreationDto lesson){
        lessonService.createLesson(lesson);
        return HttpStatus.CREATED;
    }
}

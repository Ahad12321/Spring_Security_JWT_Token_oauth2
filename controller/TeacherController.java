package com.ahad.course_app.controller;

import com.ahad.course_app.dto.teacherDto.TeacherCreationDto;
import com.ahad.course_app.dto.teacherDto.TeacherDto;
import com.ahad.course_app.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping
    public Set<TeacherDto>getAllTeachers(){
       return teacherService.getAllTeachers();
    }
    @PostMapping
    public HttpStatus creatTeacher(@RequestBody TeacherCreationDto teacherCreationDto){
        teacherService.createTeacher(teacherCreationDto);
        return HttpStatus.CREATED;
    }
   /* @PatchMapping("/teacher/{tname}/lesson/{lname}")
    public ResponseEntity<?>addLessonToTeacher(@PathVariable String tname, @PathVariable String lname){
        return new ResponseEntity<>(teacherService.addLessonToTeacher(tname,lname),ACCEPTED);
    }*/

}

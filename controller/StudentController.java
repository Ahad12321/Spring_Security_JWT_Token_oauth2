package com.ahad.course_app.controller;

import com.ahad.course_app.dto.studentDto.StudentCreationDTO;
import com.ahad.course_app.dto.studentDto.StudentDto;
import com.ahad.course_app.dto.studentDto.StudentResponse;
import com.ahad.course_app.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponse>create(@RequestBody StudentCreationDTO student){

        return ResponseEntity.ok(studentService.creatStudent(student));
    }
   /* public HttpStatus create(@RequestBody StudentCreationDTO student){

         studentService.creatStudent(student);

        return HttpStatus.CREATED;
    }*/
    @PostMapping("/auth")
    public ResponseEntity<StudentResponse>auth(@RequestBody StudentDto studentRequest){
        return ResponseEntity.ok(studentService.auth(studentRequest));
    }


    @GetMapping()
    public Set<StudentDto>getUsers(){
        return studentService.getAllStudents();
    }



}


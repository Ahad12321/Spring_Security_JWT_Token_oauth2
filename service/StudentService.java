package com.ahad.course_app.service;

import com.ahad.course_app.dto.studentDto.*;
import com.ahad.course_app.enums.Role;
import com.ahad.course_app.model.Student;
import com.ahad.course_app.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final StudentDtoConverter studentDtoConverter;
    private final StudentCreationDtoConverter studentCreationDtoConverter;



    public StudentResponse creatStudent(StudentCreationDTO student) {
        Student student1=Student.builder().name(student.getName())
                .surname(student.getSurname())
                .email(student.getEmail())
                .password(student.getPassword())
                .birthday(student.getBirthday())
                .role(Role.STUDENT).build();
        studentRepository.save(student1);

        var token = jwtService.generateToken(student1);
        return StudentResponse.builder().token(token).build();


    }

    public Set<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(studentDtoConverter::convert).collect(toSet());
    }

    public StudentResponse auth(StudentDto studentRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(studentRequest.getEmail(),studentRequest.getPassword()));
        Student student=studentRepository.findByEmail(studentRequest.getEmail()).orElseThrow();
        String token =jwtService.generateToken(student);
        return StudentResponse.builder().token(token).build();

    }
}

package com.ahad.course_app.dto.lessonDto;

import com.ahad.course_app.dto.studentDto.StudentDto;
import com.ahad.course_app.model.Student;
import org.springframework.stereotype.Component;

@Component
public class LessonStudenDtoConverter {


    public StudentDto convert(Student from){
        return StudentDto.builder().name(from.getName())
                .surname(from.getSurname())
                .birthday(from.getBirthday())
                .email(from.getEmail()).build();
    }
}

package com.ahad.course_app.dto.teacherDto;

import com.ahad.course_app.model.Lesson;
import com.ahad.course_app.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherCreationDtoConverter {
    public Teacher convert(TeacherCreationDto from){
        return Teacher.builder().name(from.getName())
                .surname(from.getSurname())
                .email(from.getEmail())
                .password(from.getPassword())
                .birthday(from.getBirthday())
                .about(from.getAbout()).build();
    }
}

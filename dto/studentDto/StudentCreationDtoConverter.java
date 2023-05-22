package com.ahad.course_app.dto.studentDto;

import com.ahad.course_app.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentCreationDtoConverter {
    public Student convert(StudentCreationDTO from){
        return  Student.builder()
                .name(from.getName())
                .surname(from.getSurname())
                .email(from.getEmail())
                .password(from.getPassword())
                .birthday(from.getBirthday())
                .build();

    }

}

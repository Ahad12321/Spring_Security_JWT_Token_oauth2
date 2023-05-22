package com.ahad.course_app.dto.studentDto;

import com.ahad.course_app.dto.lessonDto.LessonDtoConverter;
import com.ahad.course_app.model.Student;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toSet;

@Component
public class StudentDtoConverter {
    private final StudentLessonDtoConverter studentLessonDtoConverter;

    public StudentDtoConverter(LessonDtoConverter lessonDtoConverter, StudentLessonDtoConverter studentLessonDtoConverter) {
        this.studentLessonDtoConverter = studentLessonDtoConverter;

    }
    public StudentDto convert(Student from){
        return StudentDto.builder()
                .name(from.getName())
                .surname(from.getSurname())
                .birthday(from.getBirthday())
                .email(from.getEmail())
                .amount(from.getAmount())
                .lessons((from.getLesson())
                        .stream()
                        .map(studentLessonDtoConverter::convert).collect(toSet()))/*Set<LessonDto>lessons=*/
               .build();
    }

}

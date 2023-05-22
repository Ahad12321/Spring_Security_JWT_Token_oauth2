package com.ahad.course_app.dto.teacherDto;

import com.ahad.course_app.dto.lessonDto.LessonDto;
import com.ahad.course_app.dto.lessonDto.LessonDtoConverter;
import com.ahad.course_app.dto.teacherDto.TeacherDto;
import com.ahad.course_app.model.Lesson;
import com.ahad.course_app.model.Teacher;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
public class TeacherDtoConverter {
    private final LessonDtoConverter lessonDtoConverter;

    public TeacherDtoConverter(LessonDtoConverter lessonDtoConverter) {
        this.lessonDtoConverter = lessonDtoConverter;
    }
    public TeacherDto convert(Teacher from){
        return TeacherDto.builder().name(from.getName())
                .surname(from.getSurname())
                .email(from.getEmail())
                .about(from.getAbout())
                /*.lesson(isNull(from)).build();*///bele ve bunu deyisib geti calisdir!!!!!!!!!!11
                .lesson(from.getLesson()).build();

    }
   /* public Lesson isNull(Teacher teacher){
        if (teacher.getLesson()==null){
            return new Lesson();
        }
        return teacher.getLesson();
    }
*/



}

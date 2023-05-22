package com.ahad.course_app.dto.lessonDto;

import com.ahad.course_app.dto.teacherDto.TeacherDto;
import com.ahad.course_app.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class LessonTeacherDtoConverter {
    public TeacherDto convert(Teacher from){
       return   TeacherDto.builder().name(from.getName()).build();

    }
    public LessonTeacherDto convert1(Teacher from){
        return   LessonTeacherDto.builder().name(from.getName()).build();

    }
}

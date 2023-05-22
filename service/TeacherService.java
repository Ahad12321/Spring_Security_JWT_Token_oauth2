package com.ahad.course_app.service;

import com.ahad.course_app.dto.teacherDto.TeacherCreationDto;
import com.ahad.course_app.dto.teacherDto.TeacherCreationDtoConverter;
import com.ahad.course_app.dto.teacherDto.TeacherDto;
import com.ahad.course_app.dto.teacherDto.TeacherDtoConverter;
import com.ahad.course_app.model.Lesson;
import com.ahad.course_app.model.Teacher;
import com.ahad.course_app.repository.LessonRepository;
import com.ahad.course_app.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherDtoConverter teacherDtoConverter;
    private final TeacherCreationDtoConverter teacherCreationDtoConverter;
    private final LessonService lessonService;
    private final LessonRepository lessonRepository;


    public Set<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll().stream().map(teacherDtoConverter::convert).collect(Collectors.toSet());
    }

    public void createTeacher(TeacherCreationDto teacherCreationDto) {
        Teacher teacher = teacherCreationDtoConverter.convert(teacherCreationDto);
        teacherRepository.save(teacher);

    }

  /*  public Object addLessonToTeacher(String tname, String lname) {
        Optional<Teacher> teacherOptional = teacherRepository.findByName(tname);
        Optional<Lesson> lessonOptional = lessonRepository.findByName(lname);
        if (teacherOptional.isPresent() && lessonOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            Lesson lesson = lessonOptional.get();
            teacher.addLesson(lesson);

            return studentRepository.save(student);
        }
    }*/
}

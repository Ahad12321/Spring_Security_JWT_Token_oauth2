package com.ahad.course_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long student_id;
    private Long lesson_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(student_id, course.student_id) && Objects.equals(lesson_id, course.lesson_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student_id, lesson_id);
    }
}

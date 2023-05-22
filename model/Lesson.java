package com.ahad.course_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Data
@ToString(exclude = "student")
@EqualsAndHashCode(exclude = "student")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;
    @ManyToMany (mappedBy = "lesson")
    private Set<Student>student;
    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    private Set<Teacher>teacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) && Objects.equals(name, lesson.name) && Objects.equals(price, lesson.price) && Objects.equals(student, lesson.student) && Objects.equals(teacher, lesson.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, student, teacher);
    }
}

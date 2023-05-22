package com.ahad.course_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @Lob
    private String about;
    private String name;
    private String surname;
    private String email;
    private String password;
    private BigDecimal balance;


    private LocalDate birthday;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name = "",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "lesson_id")}
    )
    private Set<Role> roles;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(about, teacher.about) && Objects.equals(name, teacher.name) && Objects.equals(surname, teacher.surname) && Objects.equals(email, teacher.email) && Objects.equals(password, teacher.password) && Objects.equals(balance, teacher.balance) && Objects.equals(birthday, teacher.birthday) && Objects.equals(lesson, teacher.lesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, about, name, surname, email, password, balance, birthday, lesson);
    }
}

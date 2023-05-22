package com.ahad.course_app.dto.lessonDto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class LessonCreationDto {
    private String name;
    private BigDecimal price;
}

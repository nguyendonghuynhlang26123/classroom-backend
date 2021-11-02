package com.ndhl.web.backend.dtos.classroom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateClassroomDto {
    @Length(min = 1, max = 100)
    @NotNull
    private String title;

    @Length(max = 50)
    private String room;

    @Length(max = 50)
    private String subject;

    @Length(max = 50)
    private String section;
}

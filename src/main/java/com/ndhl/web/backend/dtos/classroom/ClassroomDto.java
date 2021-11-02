package com.ndhl.web.backend.dtos.classroom;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ClassroomDto {
    private long id;
    private String title;
    private String code;
    private String img;
    private String room;
    private String subject;
    private String section;
}

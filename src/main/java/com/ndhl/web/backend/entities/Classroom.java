package com.ndhl.web.backend.entities;


import com.ndhl.web.backend.entities.base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tclassroom")
@AttributeOverride(name = "id", column = @Column(name = "class_id"))
public class Classroom extends AbstractEntity {
    @Column(name = "class_title", length = 100, nullable = false)
    @Length(min = 1, max = 100)
    private String title;

    @Column(name = "class_code", length = 10, nullable = false)
    @Length(min = 1, max = 10)
    private String code;

    @Column(name = "class_img", length = 200)
    @Length(max = 200)
    private String img;

    @Column(name = "class_room", length = 50)
    @Length(max = 50)
    private String room;

    @Column(name = "subject", length = 50)
    @Length( max = 50)
    private String subject;

    @Column(name = "section", length = 50)
    @Length(max = 50)
    private String section;
}

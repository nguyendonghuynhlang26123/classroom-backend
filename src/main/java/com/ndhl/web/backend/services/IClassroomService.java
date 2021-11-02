package com.ndhl.web.backend.services;

import com.ndhl.web.backend.dtos.classroom.ClassroomDto;
import com.ndhl.web.backend.dtos.classroom.CreateClassroomDto;

import java.util.List;

public interface IClassroomService {
    List<ClassroomDto> getAllClasses();

    ClassroomDto createClass(CreateClassroomDto payload);
}

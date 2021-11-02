package com.ndhl.web.backend.services.impl;

import com.ndhl.web.backend.common.exceptions.ExistingResourceException;
import com.ndhl.web.backend.dtos.classroom.ClassroomDto;
import com.ndhl.web.backend.dtos.classroom.CreateClassroomDto;
import com.ndhl.web.backend.entities.Classroom;
import com.ndhl.web.backend.repositories.IClassroomRepository;
import com.ndhl.web.backend.services.IClassroomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = {Throwable.class})
@RequiredArgsConstructor
@Slf4j
public class ClassroomServiceImpl implements IClassroomService {
    @Autowired
    IClassroomRepository repository;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<ClassroomDto> getAllClasses() {
        List<Classroom> classes = repository.findAll();
        return classes.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ClassroomDto createClass(CreateClassroomDto payload) {
        List<Classroom> duplicatedTitle = repository.findAllByTitle(payload.getTitle());
        if (duplicatedTitle.size() > 0)
            throw new ExistingResourceException("Class title exists");

        Classroom classroom = new Classroom();
        classroom.setCode("123dsag");
        classroom.setTitle(payload.getTitle());
        classroom.setRoom(payload.getRoom());
        classroom.setSection(payload.getSection());
        classroom.setSubject(payload.getSubject());
        return this.mapToDto(repository.save(classroom));
    }

    private ClassroomDto mapToDto(Classroom classroom) {
        return mapper.map(classroom, ClassroomDto.class);
    }
}

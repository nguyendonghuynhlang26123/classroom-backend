package com.ndhl.web.backend.web;

import com.ndhl.web.backend.common.AbstractEndpoint;
import com.ndhl.web.backend.dtos.classroom.ClassroomDto;
import com.ndhl.web.backend.dtos.classroom.CreateClassroomDto;
import com.ndhl.web.backend.services.IClassroomService;
import com.ndhl.web.backend.services.impl.ClassroomServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(AbstractEndpoint.BASE_PATH + "/classes")
@Slf4j
public class ClassroomController {
    @Autowired
    ClassroomServiceImpl service;

    @GetMapping
    ResponseEntity<List<ClassroomDto>> getAll(){
        return ResponseEntity.status(200).body(service.getAllClasses());
    }

    @PostMapping
    ResponseEntity<ClassroomDto> createClass(@RequestBody @Valid CreateClassroomDto payload){
        return ResponseEntity.status(201).body(service.createClass(payload));
    }
}

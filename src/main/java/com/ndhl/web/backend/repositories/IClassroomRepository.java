package com.ndhl.web.backend.repositories;

import com.ndhl.web.backend.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClassroomRepository extends JpaRepository<Classroom, Long>, QuerydslPredicateExecutor<Classroom> {
    List<Classroom> findAllByTitle(String title);
}

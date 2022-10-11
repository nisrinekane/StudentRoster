package com.nisrinekane.studentroster.repositories;

import com.nisrinekane.studentroster.models.Dorm;
import com.nisrinekane.studentroster.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {
    List<Dorm> findAll();

}
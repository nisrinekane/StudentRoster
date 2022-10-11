package com.nisrinekane.studentroster.services;

import com.nisrinekane.studentroster.models.Course;
import com.nisrinekane.studentroster.models.Dorm;
import com.nisrinekane.studentroster.models.Student;
import com.nisrinekane.studentroster.repositories.DormRepository;
import com.nisrinekane.studentroster.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DormService {
    private final DormRepository dormRepository;

    public DormService(DormRepository dormRepository) {
        this.dormRepository = dormRepository;
    }

    //create a dorm
    public void createDorm(Dorm dorm) {
        dormRepository.save(dorm);
    }

    // retrieve a dorm
    public Dorm  findDorm(Long id) {
        Optional<Dorm> dorm = dormRepository.findById(id);
        return dorm.orElse(null);
    }

    //retrieve all dorms
    public List<Dorm> allDorms() {
        return dormRepository.findAll();
    }

    //update a dorm
    public Dorm updateDorm(Dorm dorm) {
        return dormRepository.save(dorm);
    }

    //delete a dorm
    public void deleteDorm(Long id) {
        dormRepository.deleteById(id);
    }


    //set student to dorm
    public void setStudentToDorm(Long id, Object student) {
        Dorm thisDorm = dormRepository.findById(id).get();
        thisDorm.getStudents().add((Student) student);
        dormRepository.save(thisDorm);
    }

//    //find students linked to this dorm
//    public List<Student> getStudentsInDorm(Dorm dorm, List<Student> students) {
//        return students.stream().filter(student -> student.getDorm().equals(dorm)).collect(Collectors.toList());
//    }

}

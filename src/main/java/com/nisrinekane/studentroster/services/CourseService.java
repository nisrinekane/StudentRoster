package com.nisrinekane.studentroster.services;


import com.nisrinekane.studentroster.models.Course;
import com.nisrinekane.studentroster.models.Student;
import com.nisrinekane.studentroster.repositories.CourseRepository;
import com.nisrinekane.studentroster.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //create a course
    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    // retrieve a course
    public Course  findCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    //retrieve all courses
    public List<Course> allCourses() {
        return courseRepository.findAll();
    }

    //update a course
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    //delete a course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    //set student to course
    public void setStudentToCourse(Long id, Object student) {
        Course thisCourse = courseRepository.findById(id).get();
        thisCourse.getStudents().add((Student) student);
        courseRepository.save(thisCourse);
    }

    //find students not linked to this course
    public List<Student> getStudentsNotInCourse(Course course, List<Student> students) {
        return students.stream().filter(student ->
                !student.getCourses().contains(course)).collect(Collectors.toList());
    }

}


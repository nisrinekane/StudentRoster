package com.nisrinekane.studentroster.services;
import com.nisrinekane.studentroster.models.Course;
import com.nisrinekane.studentroster.models.Dorm;
import com.nisrinekane.studentroster.models.Student;
import com.nisrinekane.studentroster.repositories.CourseRepository;
import com.nisrinekane.studentroster.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository1) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository1;
    }

    //create a student
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    // retrieve a student
    public Student  findStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    //retrieve all students
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    //update a student
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    //delete a student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    //set a course to student
    public void setCourse(Long id, Object course) {
        Student thisStudent = studentRepository.findById(id).get();
        thisStudent.getCourses().add((Course) course);
        studentRepository.save(thisStudent);
    }

    //remove a course from student courses
    public void removeCourse(Long id, Object course) {
        Student thisStudent = studentRepository.findById(id).get();
        thisStudent.getCourses().remove((Course) course);
        studentRepository.save(thisStudent);
    }

    //find courses not linked to this student
    public List<Course> getOtherCourses(Student student, List<Course> courses) {
        return courses.stream().filter(course ->
                !course.getStudents().contains(student)).collect(Collectors.toList());
    }

    //set a dorm to student
    public void setDorm(Long id, Object dorm) {
        Student thisStudent = studentRepository.findById(id).get();
        thisStudent.setDorm((Dorm) dorm);
        studentRepository.save(thisStudent);
    }

    //like a dorm
    public void LikeCourse(Long studentId, Course courseId) {
        Optional<Student> student = studentRepository.findById(studentId);
    }

    //set a liked course to a student
    public void setLikedCourse(Long studentId, Long courseId) {
        Student thisStudent = studentRepository.findById(studentId).get();
        Course thisCourse = courseRepository.findById(courseId).get();
        thisStudent.getLikedCourses().add(thisCourse);
        studentRepository.save(thisStudent);
    }
}




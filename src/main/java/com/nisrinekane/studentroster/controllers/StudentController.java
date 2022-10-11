package com.nisrinekane.studentroster.controllers;

import com.nisrinekane.studentroster.models.Course;
import com.nisrinekane.studentroster.models.Dorm;
import com.nisrinekane.studentroster.models.Student;
import com.nisrinekane.studentroster.services.CourseService;
import com.nisrinekane.studentroster.services.DormService;
import com.nisrinekane.studentroster.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    DormService dormService;

    //show all students
    @RequestMapping("/students")
    public String showAllStudents(Model model,
                               @ModelAttribute("student")Student student,
                               HttpSession session) {
        List<Student> students = studentService.allStudents();
        model.addAttribute("students", students);
        return "showStudents.jsp";
    }

    //show one students
    @RequestMapping("/students/{id}")
    public String showOneStudent(@PathVariable("id") Long studentId,
                                Model model,
                               HttpSession session) {
        Student student = studentService.findStudent(studentId);
        model.addAttribute("student", student);
        return "showOneStudent.jsp";
    }

   // new student: render form
    @GetMapping("/students/new")
    public String newStudentForm(@ModelAttribute("student") Student student,
                                 Model model) {
        List<Dorm> dorms = dormService.allDorms();
        model.addAttribute("dorms", dorms);
        return "newStudent.jsp";

    }

    // new student: post route
    @PostMapping("/createStudent")
    public String createStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult result) {

        if (result.hasErrors()) {
            return "newStudent.jsp";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }

    // add courses to student: render drop down menu
    @GetMapping("/students/{id}/courses")
    public String showCourse(@PathVariable("id") Long id,
                              Model model) {
        Student student = studentService.findStudent(id);
        List<Course> courses = courseService.allCourses();
        model.addAttribute("student", student);
        model.addAttribute("courses", studentService.getOtherCourses(student, courses));
        return "showStudentCourses.jsp";
    }

    //add course to student: post route
    @PostMapping("/students/{id}/updateCourses")
    public String updateStudentCourses(@PathVariable("id") Long studentId,
                                Model model,
                                @RequestParam("courseId") Long courseId){
        Course course = courseService.findCourse(courseId);
        studentService.setCourse(studentId, course);
        return "redirect:/students/{id}/courses";
    }

    // update student info + dorm: render form
    @GetMapping("/students/{id}/edit")
    public String editStudent(@PathVariable("id") Long studentId,
                              Model model) {
        Student student = studentService.findStudent(studentId);
        List<Dorm> dorms = dormService.allDorms();
        model.addAttribute("student", student);
        model.addAttribute("dorms", dorms);
        return "editStudent.jsp";
    }

    //update student info + dorm: put route
    @PutMapping("/students/{id}/update")
    public String updateStudent(@PathVariable("id") Long studentId,
                                       Model model,
                                       @Valid @ModelAttribute("student") Student student,
                                       BindingResult bindingResult){
        studentService.updateStudent(student);
        return "redirect:/students/{id}";
    }
    //remove course from student
    @GetMapping("/students/{id}/removeCourse/{courseId}")
    public String removeProduct(@PathVariable("id") Long studentID,
                                @PathVariable("courseId") Long courseId) {
        Course course = courseService.findCourse(courseId);
        studentService.removeCourse(studentID, course);
        return "redirect:/students/" + studentID + "/courses";
    }

}

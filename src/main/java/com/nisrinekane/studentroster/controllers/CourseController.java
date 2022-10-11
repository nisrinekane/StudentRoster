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
public class CourseController {
    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    DormService dormService;

    //show all courses
    @RequestMapping("/courses")
    public String showAllCourses(Model model,
                                  @ModelAttribute("course") Course course,
                                  HttpSession session) {
        List<Course> courses = courseService.allCourses();
        model.addAttribute("courses", courses);
        return "showCourses.jsp";
    }

    //show one course
    @RequestMapping("/courses/{id}")
    public String showOneCourse(@PathVariable("id") Long courseId,
                                  Model model,
                                  HttpSession session) {
        Course course = courseService.findCourse(courseId);
        model.addAttribute("course", course);
        return "showOneCourse.jsp";
    }

    // new course: render form
    @GetMapping("/courses/new")
    public String newStudentForm(@ModelAttribute("course") Course course,
                                 Model model) {
        return "newCourse.jsp";

    }

      // new course: post route
    @PostMapping("/createCourse")
    public String createCourse(@Valid @ModelAttribute("course") Course course,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "newCourse.jsp";
        }
        courseService.createCourse(course);
        return "redirect:/courses";
    }

    // update course info: render form
    @GetMapping("/courses/{id}/edit")
    public String editCourse(@PathVariable("id") Long courseId,
                              Model model) {
        Course course = courseService.findCourse(courseId);
        model.addAttribute("course", course);
        return "editCourse.jsp";
    }

    //update course info:put route
    @PutMapping("/courses/{id}/update")
    public String updateCourse(@PathVariable("id") Long courseId,
                                Model model,
                                @Valid @ModelAttribute("course") Course course,
                                BindingResult bindingResult){
        courseService.updateCourse(course);
        return "redirect:/courses/{id}";
    }
}

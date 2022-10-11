package com.nisrinekane.studentroster.controllers;

import com.nisrinekane.studentroster.models.Dorm;
import com.nisrinekane.studentroster.models.Student;
import com.nisrinekane.studentroster.services.CourseService;
import com.nisrinekane.studentroster.services.DormService;
import com.nisrinekane.studentroster.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DormController {
    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    DormService dormService;

//    get all dorms
    @GetMapping("/dorms")
    public String getAllDorms(Model model,
                              Dorm dorm) {
       List<Dorm> dorms = dormService.allDorms();
       model.addAttribute("dorms", dorms);
       return "showDorms.jsp";
    }

    //see students assigned to this
    @GetMapping("/dorms/{id}/students")
    public String getDormStudents(@PathVariable("id") Long dormId,
                                  Model model) {
        Dorm dorm = dormService.findDorm(dormId);
        model.addAttribute("dorm", dorm);
        return "showDormStudents.jsp";
    }
}

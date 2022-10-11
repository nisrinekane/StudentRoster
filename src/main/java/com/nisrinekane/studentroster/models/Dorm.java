package com.nisrinekane.studentroster.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.nisrinekane.studentroster.models.Student;
import java.util.List;

@Entity
@Table(name="dorms")
public class Dorm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Name is required!")
    @Size(min=3, max=30, message="dorm name must be between 3 and 30 characters")
    private String name;

    //one dorm for many students
    @OneToMany(mappedBy = "dorm", fetch = FetchType.LAZY)
    private List<Student> students;

    public Dorm() {

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(List<Student> students) {
        this.students = students;
    }


    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

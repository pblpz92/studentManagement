package com.example.demo.model;

import com.example.demo.model.enums.FpFamily;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class FP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private FpFamily fpFamily;

    @ManyToMany(mappedBy = "studentFPs")
    private List<Student> students;

    public FP() {
    }

    public FP(String name, FpFamily fpFamily) {
        this.name = name;
        this.fpFamily = fpFamily;
    }

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

    public FpFamily getFpFamily() {
        return fpFamily;
    }

    public void setFpFamily(FpFamily fpFamily) {
        this.fpFamily = fpFamily;
    }

    public List<Student> getStudents() {
        return students;
    }
}

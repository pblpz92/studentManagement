package com.example.demo.model;

import com.example.demo.model.enums.Gender;
import com.example.demo.model.others.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surnames;

    private String NIA;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[0-9]{8}[A-Z]$", message = "El NIF debe tener el formato adecuado.")
    private String NIF;

    private String NUSS;

    private List<String> phoneNumbers = new ArrayList<>();

    @Email
    private String email;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private boolean visible;

    private LocalDateTime registerDate;

    private LocalDateTime lastAccessDate;

    @ManyToMany
    @JsonIgnoreProperties("students")
    @JoinTable(
            name = "student_fp", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "student_id"), // FK hacia Student
            inverseJoinColumns = @JoinColumn(name = "fp_id") // FK hacia FP
    )
    private List<FP> studentFPs = new ArrayList<>();

    //mappedBy = "student" apunta al campo en FCT que define la relación
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FCT> FCTS = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String surnames, String NIA, String NIF, String NUSS, List<String> phoneNumbers, String email, Address address, Gender gender, boolean visible, LocalDateTime lastAccessDate) {
        this.name = name;
        this.surnames = surnames;
        this.NIA = NIA;
        this.NIF = NIF;
        this.NUSS = NUSS;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.lastAccessDate = lastAccessDate;
        this.visible = true;
        this.registerDate = LocalDateTime.now();
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

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getNIA() {
        return NIA;
    }

    public void setNIA(String NIA) {
        this.NIA = NIA;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNUSS() {
        return NUSS;
    }

    public void setNUSS(String NUSS) {
        this.NUSS = NUSS;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(LocalDateTime lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public List<FP> getStudentFPs() {
        return studentFPs;
    }

    public void setStudentFPs(List<FP> studentFPs) {
        this.studentFPs = studentFPs;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setFCTS(ArrayList<FCT> FCTS) {
        this.FCTS = FCTS;
    }
}
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surnames;

    private String phoneNumber;

    @Column(nullable = false)
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties({"managers", "workCenters"})
    private Company company;

    @OneToMany
    private List<FCT> fct = new ArrayList<>();

    public Mentor() {
    }

    public Mentor(String name, String surnames, String phoneNumber, String email, Company company) {
        this.name = name;
        this.surnames = surnames;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.company = company;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<FCT> getFct() {
        return fct;
    }
}

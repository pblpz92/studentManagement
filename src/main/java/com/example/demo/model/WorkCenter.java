package com.example.demo.model;

import com.example.demo.model.others.Address;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
>>>>>>> main
import jakarta.persistence.*;

@Entity
public class WorkCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
<<<<<<< HEAD
=======
    @JsonIgnoreProperties("workCenters")
>>>>>>> main
    private Company company;

    @Embedded
    private Address address;

    public WorkCenter() {
    }

    public WorkCenter(String name, Company company, Address address) {
        this.name = name;
        this.company = company;
        this.address = address;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

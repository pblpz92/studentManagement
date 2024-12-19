package com.example.demo.model;

import com.example.demo.model.others.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-HJ-NP-SUVW]\\d{7}[0-9A-J]$", message = "El CIF debe tener un formato válido.")
    private String CIF;

    private String name;

    @Embedded
    private Address address;

    private String phoneNumber;

    private String fax;

    private String actividad;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Manager> managers = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<WorkCenter> workCenters = new ArrayList<>();

    public Company() {
    }

    public Company(String CIF, String name, Address address, String phoneNumber, String fax, String actividad) {
        this.CIF = CIF;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fax = fax;
        this.actividad = actividad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public List<WorkCenter> getWorkCenters() {
        return workCenters;
    }
}

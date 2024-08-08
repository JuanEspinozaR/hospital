package com.je.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @NotBlank(message = "please set a valid firstName")
    @Size(min = 0, max = 50, message = "firstName length must be grater than 0 and smaller than 50")
    private String firstName;
    @NotBlank(message = "please set a valid lastName")
    @Size(min = 0, max = 50, message = "lastName length must be grater than 0 and smaller than 50")
    private String lastName;
    private String location;
    @Size(min = 0, max = 100, message = "description length must be grater than 0 and smaller than 100")
    private String description;
    @Positive(message = "salary must be a positive number")
    private double salary;

    public Doctor() {
    }

    public Doctor(long id, String firstName, String lastName, String location, String description, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.description = description;
        this.salary = salary;
    }

    public Doctor(Long o, String juan, String espinoza, String location, String niceDoctor, double salary) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

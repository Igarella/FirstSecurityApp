package ru.alishev.spring.FirstSecurityApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Person")
@Data
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name couldn't be empty")
    @Size(min = 2, max = 100, message = "name should be between 2 and 100 characters")
    @Column(name = "username")
    private String userName;

    @Min(value = 1900, message = "year couldn't be less than 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    public Person(String userName, int yearOfBirth) {
        this.userName = userName;
        this.yearOfBirth = yearOfBirth;
    }

    public Person() {

    }
}

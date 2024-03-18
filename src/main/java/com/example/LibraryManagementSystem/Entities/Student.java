package com.example.LibraryManagementSystem.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="students")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;
    private String branch;
    private double cgpa;
    private String phoneNo;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private LibraryCard libraryCard;
}

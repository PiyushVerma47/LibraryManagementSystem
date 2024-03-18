package com.example.LibraryManagementSystem.Requests;

import lombok.Data;

@Data
public class AddStudentRequest {
    private String name;
    private String branch;
    private double cgpa;
    private String phoneNo;
}

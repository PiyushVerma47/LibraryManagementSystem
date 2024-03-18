package com.example.LibraryManagementSystem.Requests;

import lombok.Data;

@Data
public class AddAuthorRequest {
    private String name;
    private String emailId;
    private int age;

}

package com.example.LibraryManagementSystem.Requests;

import lombok.Data;

@Data
public class LinkStudentAndCardRequest {
    private int cardId;
    private int studentId;
}

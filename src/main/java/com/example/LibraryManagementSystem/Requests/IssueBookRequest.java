package com.example.LibraryManagementSystem.Requests;

import lombok.Data;

@Data
public class IssueBookRequest {

    private int bookId;
    private int cardId;
}

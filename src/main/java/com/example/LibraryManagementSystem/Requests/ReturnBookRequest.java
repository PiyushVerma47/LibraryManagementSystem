package com.example.LibraryManagementSystem.Requests;

import lombok.Data;

@Data
public class ReturnBookRequest {
    private int bookId;
    private int cardId;
}

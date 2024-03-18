package com.example.LibraryManagementSystem.Requests;

import com.example.LibraryManagementSystem.Enums.BookGenre;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddBookRequest {
    private String bookName;

    private BookGenre bookGenre;

    private int noOfPages;

    private int price;

    private LocalDate publishDate;

    private int authorId;
}

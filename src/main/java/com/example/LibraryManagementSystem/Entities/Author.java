package com.example.LibraryManagementSystem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "authors")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String authorName;
    private String emailId;
    private int age;
    private int noOfBooksWritten;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();
}

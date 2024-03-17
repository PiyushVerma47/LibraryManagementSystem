package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(unique = true)
    private String bookName;

    @Enumerated(value = EnumType.STRING)
    private Genre bookGenre;

    private int noOfPages;

    private int price;

    private Date publishDate;

    private Boolean isAvailable;

    @JoinColumn
    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    public List<Transaction> transactionList = new ArrayList<>();
}

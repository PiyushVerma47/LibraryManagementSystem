package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.BookGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
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

    private String bookName;
    @Enumerated(value = EnumType.STRING)
    private BookGenre bookGenre;
    private int noOfPages;
    private int price;
    private LocalDate publishDate;
    private Boolean isAvailable;

    @JoinColumn
    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions> transactionList = new ArrayList<>();

}

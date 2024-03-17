package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Table(name = "library_card")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard {
    public static final Integer MAX_NO_OF_ALLOWED_BOOKS = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;


    //This is an annotation for mysql to understand custom datatype
    // and store it as a string format inside the DB.
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private int noOfBooksIssued;

    @JoinColumn
    @OneToOne
    private Student student;


    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    public List<Transaction> transactionList = new ArrayList<>();
}

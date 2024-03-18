package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libraryCard")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    private int noOfBooksIssued;

    @JoinColumn
    @OneToOne
    private Student student;

    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    public List<Transactions> transactionList = new ArrayList<>();
}

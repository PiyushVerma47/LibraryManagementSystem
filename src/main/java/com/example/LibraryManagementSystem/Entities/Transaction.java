package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    private TransactionStatus transactionStatus;


    private LocalDate createdOn;

    private int fineAmount;

    private TransactionType transactionType;


    @JoinColumn
    @ManyToOne
    private LibraryCard libraryCard;


    @JoinColumn
    @ManyToOne
    private Book book;
}

package com.example.LibraryManagementSystem.Repositories;

import com.example.LibraryManagementSystem.Entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
}

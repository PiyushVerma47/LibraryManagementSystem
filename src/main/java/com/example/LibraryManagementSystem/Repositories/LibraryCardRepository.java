package com.example.LibraryManagementSystem.Repositories;

import com.example.LibraryManagementSystem.Entities.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
}

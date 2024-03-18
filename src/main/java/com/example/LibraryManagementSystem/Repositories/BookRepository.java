package com.example.LibraryManagementSystem.Repositories;

import com.example.LibraryManagementSystem.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

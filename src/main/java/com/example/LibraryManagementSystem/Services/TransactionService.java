package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Entities.LibraryCard;
import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Entities.Transactions;
import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Enums.TransactionType;
import com.example.LibraryManagementSystem.Repositories.BookRepository;
import com.example.LibraryManagementSystem.Repositories.LibraryCardRepository;
import com.example.LibraryManagementSystem.Repositories.TransactionRepository;
import com.example.LibraryManagementSystem.Requests.IssueBookRequest;
import com.example.LibraryManagementSystem.Requests.ReturnBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransactionService {




}

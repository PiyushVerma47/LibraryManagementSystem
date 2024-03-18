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

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private LibraryCardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    public String issueBook(IssueBookRequest issueBookRequest) throws Exception{
        LibraryCard card = cardRepository.findById(issueBookRequest.getCardId()).get();
        Book book = bookRepository.findById(issueBookRequest.getBookId()).get();

        System.out.println("iN TRANSACTION");
        LocalDate date = LocalDate.parse("2024-01-05");

        Student student = card.getStudent();

        if(!book.getIsAvailable()){
            throw new Exception("Book unavailable");

        }

        if(card.getNoOfBooksIssued() >= 3){
            throw new Exception("Maximum number of books already issued to this card");
        }

        Transactions transaction = Transactions.builder()
                .book(book)
                .transactionType(TransactionType.ISSUED)
                .transactionStatus(TransactionStatus.SUCCESS)
                .libraryCard(card)
                .build();

        book.setIsAvailable(Boolean.FALSE);

        book.getTransactionList().add(transaction);
        card.getTransactionList().add(transaction);

        transaction = transactionRepository.save(transaction);

        return "Transaction have been saved to the db with Id: "+transaction.getTransactionId();

    }

    public String returnBook(ReturnBookRequest returnBookRequest){
        LibraryCard card = cardRepository.findById(returnBookRequest.getCardId()).get();
        Book book = bookRepository.findById(returnBookRequest.getBookId()).get();

        card.setNoOfBooksIssued(card.getNoOfBooksIssued()-1);
        book.setIsAvailable(Boolean.TRUE);

        Transactions transaction = Transactions.builder()
                .book(book)
                .libraryCard(card)
                .transactionType(TransactionType.RETURN)
                .transactionStatus(TransactionStatus.SUCCESS)
                .build();

        card.getTransactionList().add(transaction);
        book.getTransactionList().add(transaction);

        transaction = transactionRepository.save(transaction);

        return "Book "+book.getBookName()+" with Id: "+book.getBookId()+" has been successfully returned.";

    }

}

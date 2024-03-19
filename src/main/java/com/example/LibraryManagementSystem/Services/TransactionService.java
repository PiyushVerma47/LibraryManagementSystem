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

        Optional<LibraryCard> optionalCard = cardRepository.findById(issueBookRequest.getCardId());
        if(optionalCard.isEmpty()){
            throw new Exception("Invalid card Id entered");
        }
        LibraryCard card = optionalCard.get();

        Optional<Book> optionalBook = bookRepository.findById(issueBookRequest.getBookId());
        if(optionalBook.isEmpty()){
            throw new Exception("Invalid book Id entered");
        }
        Book book = optionalBook.get();


        Transactions transaction = new Transactions();
        transaction.setTransactionStatus(TransactionStatus.ONGOING);
        transaction.setTransactionType(TransactionType.ISSUED);

//        LibraryCard card = cardRepository.findById(issueBookRequest.getCardId()).get();
//        Book book = bookRepository.findById(issueBookRequest.getBookId()).get();


        Student student = card.getStudent();

        if(!book.getIsAvailable()){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction = transactionRepository.save(transaction);
            throw new Exception("Book unavailable");
        }

        if(card.getNoOfBooksIssued() >= 3){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction = transactionRepository.save(transaction);
            throw new Exception("Maximum number of books already issued to this card");
        }

         transaction = Transactions.builder()
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

    public String returnBook(ReturnBookRequest returnBookRequest) throws Exception{
//        LibraryCard card = cardRepository.findById(returnBookRequest.getCardId()).get();
//        Book book = bookRepository.findById(returnBookRequest.getBookId()).get();

        Optional<LibraryCard> optionalCard = cardRepository.findById(returnBookRequest.getCardId());
        if(optionalCard.isEmpty()){
            throw new Exception("Invalid card Id entered");
        }
        LibraryCard card = optionalCard.get();

        Optional<Book> optionalBook = bookRepository.findById(returnBookRequest.getBookId());
        if(optionalBook.isEmpty()){
            throw new Exception("Invalid book Id entered");
        }
        Book book = optionalBook.get();

        Transactions transaction = new Transactions();
        transaction.setTransactionType(TransactionType.RETURN);
        transaction.setTransactionStatus(TransactionStatus.ONGOING);


        if(card.getNoOfBooksIssued() == 0) {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction = transactionRepository.save(transaction);
            throw new Exception("Currently no books issued have been issued to this card Id");
        }

        card.setNoOfBooksIssued(card.getNoOfBooksIssued()-1);
        book.setIsAvailable(Boolean.TRUE);

        transaction = Transactions.builder()
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

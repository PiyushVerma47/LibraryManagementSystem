package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Repositories.BookRepository;
import com.example.LibraryManagementSystem.Requests.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;
    public String addBook(AddBookRequest addBookRequest) throws Exception{
//        Author author = authorRepository.findById(addBookRequest.getAuthorId()).get();

        Optional<Author> optionalAuthor = authorRepository.findById(addBookRequest.getAuthorId());
        if(optionalAuthor.isEmpty()){
            throw new Exception("Invalid author Id");
        }
        Author author = optionalAuthor.get();

        Book book = Book.builder()
                .bookName(addBookRequest.getBookName())
                .bookGenre(addBookRequest.getBookGenre())
                .price(addBookRequest.getPrice())
                .noOfPages(addBookRequest.getNoOfPages())
                .isAvailable(true)
                .author(author)
                .publishDate(addBookRequest.getPublishDate())
                .build();

        author.getBookList().add(book);

        book = bookRepository.save(book);

        return "Book "+book.getBookName()+" written by "+author.getAuthorName()+" has been added to the db with the book Id: "+book.getBookId();
    }

}

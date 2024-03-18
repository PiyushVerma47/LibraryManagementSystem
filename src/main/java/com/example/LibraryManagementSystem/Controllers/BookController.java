package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Requests.AddBookRequest;
import com.example.LibraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody AddBookRequest addBookRequest){
        String result = bookService.addBook(addBookRequest);
        return result;
    }
}

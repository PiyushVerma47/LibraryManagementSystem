package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Requests.AddAuthorRequest;
import com.example.LibraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/addAuthor")
    public ResponseEntity addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){
        String result = authorService.addAuthor(addAuthorRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}

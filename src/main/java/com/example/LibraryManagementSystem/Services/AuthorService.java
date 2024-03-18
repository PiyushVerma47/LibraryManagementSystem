package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Requests.AddAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public String addAuthor(AddAuthorRequest addAuthorRequest){
        Author author = Author.builder()
                .authorName(addAuthorRequest.getName())

                .emailId(addAuthorRequest.getEmailId())
                .age(addAuthorRequest.getAge())
                .build();


        int noOfbooksWritten = author.getNoOfBooksWritten();
        author.setNoOfBooksWritten(noOfbooksWritten+1);

        author = authorRepository.save(author);
        return "Author "+ author.getAuthorName()+" has been saved with author Id: "+author.getAuthorId();
    }
}

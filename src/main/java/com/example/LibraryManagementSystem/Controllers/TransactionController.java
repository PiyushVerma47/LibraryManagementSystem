package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Requests.IssueBookRequest;
import com.example.LibraryManagementSystem.Requests.ReturnBookRequest;
import com.example.LibraryManagementSystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequest issueBookRequest){
        try{
            String result = transactionService.issueBook(issueBookRequest);
            return result;
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/returnBook")
    public String returnBook(@RequestBody ReturnBookRequest returnBookRequest){
        String result = transactionService.returnBook(returnBookRequest);
        return result;
    }

}

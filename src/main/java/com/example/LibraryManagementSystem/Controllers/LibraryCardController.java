package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Requests.LinkStudentAndCardRequest;
import com.example.LibraryManagementSystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class LibraryCardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/generateNewCard")
    public ResponseEntity generateNewCard(){
        String result = cardService.generateNewCard();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PutMapping("/linkStudentAndCard")
    public ResponseEntity linkStudentAndCard(@RequestBody LinkStudentAndCardRequest linkStudentAndCardRequest){
        try{
            String result = cardService.linkStudentAndCard(linkStudentAndCardRequest);
            return new ResponseEntity(result, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}

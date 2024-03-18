package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Requests.LinkStudentAndCardRequest;
import com.example.LibraryManagementSystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class LibraryCardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/generateNewCard")
    public String generateNewCard(){
        String result = cardService.generateNewCard();
        return result;
    }

    @PutMapping("/linkStudentAndCard")
    public String linkStudentAndCard(@RequestBody LinkStudentAndCardRequest linkStudentAndCardRequest){
        String result = cardService.linkStudentAndCard(linkStudentAndCardRequest);
        return result;
    }


}

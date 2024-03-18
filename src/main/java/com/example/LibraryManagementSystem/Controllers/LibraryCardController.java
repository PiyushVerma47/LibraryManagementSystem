package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

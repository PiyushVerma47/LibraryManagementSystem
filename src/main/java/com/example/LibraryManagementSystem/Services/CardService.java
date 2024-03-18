package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Entities.LibraryCard;
import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Repositories.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    LibraryCardRepository cardRepository;

    public String generateNewCard(){
        LibraryCard card =LibraryCard.builder()
                .cardStatus(CardStatus.NEW)
                .noOfBooksIssued(0)
                .build();

        card = cardRepository.save(card);

//        LibraryCard newCard = new LibraryCard();
//        newCard.setCardStatus(CardStatus.NEW);
//        newCard.setNoOfBooksIssued(0);

        LibraryCard savedCard =  cardRepository.save(card);

        return "A new card has been generated with the card Id: "+savedCard.getCardId();
    }
}

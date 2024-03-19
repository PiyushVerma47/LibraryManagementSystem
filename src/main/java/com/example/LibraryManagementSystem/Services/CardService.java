package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Entities.LibraryCard;
import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Repositories.LibraryCardRepository;
import com.example.LibraryManagementSystem.Repositories.StudentRepository;
import com.example.LibraryManagementSystem.Requests.LinkStudentAndCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private LibraryCardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;


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

    public String linkStudentAndCard(LinkStudentAndCardRequest linkStudentAndCardRequest) throws Exception{

        Optional<LibraryCard> optionalLibraryCard = cardRepository.findById(linkStudentAndCardRequest.getCardId());
        if(optionalLibraryCard.isEmpty()){
            throw new Exception("Invalid Library Card Id");
        }
        LibraryCard card = optionalLibraryCard.get();

        Optional<Student> optionalStudent = studentRepository.findById(linkStudentAndCardRequest.getStudentId());
        if(optionalStudent.isEmpty()){
            throw new Exception("Invalid Student Id");
        }
        Student student = optionalStudent.get();




//        int cardId = linkStudentAndCardRequest.getCardId();
//        int studentId = linkStudentAndCardRequest.getStudentId();

//        LibraryCard card = cardRepository.findById(cardId).get();
//        Student student = studentRepository.findById(studentId).get();

        student.setLibraryCard(card);
        card.setStudent(student);

        card = cardRepository.save(card);

        return "Student: "+student.getName()+" has been linked with card Id: "+card.getCardId();

    }
}

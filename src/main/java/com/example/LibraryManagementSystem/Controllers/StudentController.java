package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Requests.AddStudentRequest;
import com.example.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody AddStudentRequest addStudentRequest){
        String result = studentService.addStudent(addStudentRequest);
        return new ResponseEntity(result, HttpStatus.OK);

    }
}

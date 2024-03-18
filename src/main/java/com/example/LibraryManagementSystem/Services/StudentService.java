package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Repositories.StudentRepository;
import com.example.LibraryManagementSystem.Requests.AddStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(AddStudentRequest addStudentRequest){
        Student student = Student.builder()
                .name(addStudentRequest.getName())
                .phoneNo(addStudentRequest.getPhoneNo())
                .branch(addStudentRequest.getBranch())
                .cgpa(addStudentRequest.getCgpa())
                .build();

        student = studentRepository.save(student);
        return "Student: "+ student.getName() +" has been saved to the db with student Id: "+student.getStudentId();
    }
}

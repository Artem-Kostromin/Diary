package ru.kostromin.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import ru.kostromin.diary.domain.Student;
import ru.kostromin.diary.domain.User;
import ru.kostromin.diary.repos.UserRepo;

import java.util.List;
import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class ListOfStudentsController {
    @Autowired
    private UserRepo userRepo;

    private static List<User> users;

    @GetMapping("/listOfStudents")
    public String showUsers(Map<String,Object> model){
        users = userRepo.findAll();
        model.put("users", users);
        return "listOfStudents";
    }

    /*@PostMapping("/listOfStudents")
    public String addStudent(@RequestParam String studentname,
                             @RequestParam Integer classNumber, Map<String,Object> model){
        Student student = new Student(studentname,classNumber);
        studentRepo.save(student);
        students = studentRepo.findAll();
        model.put("students", students);
        return "listOfStudents";
    }*/
}

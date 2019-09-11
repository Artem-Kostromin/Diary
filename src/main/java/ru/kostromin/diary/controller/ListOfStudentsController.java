package ru.kostromin.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kostromin.diary.domain.Student;
import ru.kostromin.diary.repos.StudentRepo;
import ru.kostromin.diary.repos.UserRepo;

import java.util.List;
import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class ListOfStudentsController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private UserRepo userRepo;

    private static Iterable<Student> students;

    @GetMapping("/listOfStudents")
    public String showStudent(Map<String,Object> model){
        students = studentRepo.findAll();
        model.put("students", students);
        return "listOfStudents";
    }
    @PostMapping("/listOfStudents")
    public String addStudent(@RequestParam String studentname,
                             @RequestParam Integer classNumber, Map<String,Object> model){
        Student student = new Student(studentname,classNumber);
        studentRepo.save(student);
        students = studentRepo.findAll();
        model.put("students", students);
        return "listOfStudents";
    }
}

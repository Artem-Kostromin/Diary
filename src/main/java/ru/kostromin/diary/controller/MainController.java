package ru.kostromin.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kostromin.diary.domain.Student;
import ru.kostromin.diary.repos.StudentRepo;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private StudentRepo studentRepo;
    private static Iterable<Student> students;

    @GetMapping("/")
    public String greeting(){
        return "greeting";
    }

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

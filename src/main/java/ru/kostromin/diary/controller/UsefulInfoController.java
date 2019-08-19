package ru.kostromin.diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsefulInfoController {
    @GetMapping("/usefulInfo")
    public String showUsefulInfo(){
        return "usefulInfo";
    }
}

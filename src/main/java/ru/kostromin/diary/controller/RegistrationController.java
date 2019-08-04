package ru.kostromin.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kostromin.diary.domain.User;
import ru.kostromin.diary.repos.UserRepo;

import java.util.Map;
import java.util.Objects;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(User user, Map<String, Object> model){
        User checkUserFromDB = userRepo.findByUsername(user.getUsername());
        if(checkUserFromDB!=null){
            model.put("message", "Пользователь с таким именем уже есть!");
            return "registration";
        }
       /* User newUser = new User(username,password);
        userRepo.save(newUser);*/
        userRepo.save(user);
        return "redirect:/login";

    }
}

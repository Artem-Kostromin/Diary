package ru.kostromin.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kostromin.diary.domain.HomeTask;
import ru.kostromin.diary.repos.HomeTaskRepo;
import ru.kostromin.diary.repos.UserRepo;

import java.util.List;
import java.util.Map;

@Controller
public class HomeTasksController {
    @Autowired
    private HomeTaskRepo homeTaskRepo;
    @Autowired
    private UserRepo userRepo;

    private static List<HomeTask> homeTasks;

    @GetMapping("/homeTasks/**")
    public String showUsersTasks(Map<String,Object> model){
        homeTasks = homeTaskRepo.findAll();
        model.put("homeTasks", homeTasks);
        return "homeTasks";
    }
    @PostMapping
    public String addHomeTask(HomeTask homeTask, Map<String,Object> model){
        homeTask.setUserId(userRepo.findByUsername("user").getId());
        homeTaskRepo.save(homeTask);
        return "listOfStudents";
    }
}

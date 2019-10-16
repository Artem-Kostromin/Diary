package ru.kostromin.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kostromin.diary.domain.HomeTask;
import ru.kostromin.diary.domain.User;
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

    @GetMapping(value="/homeTasks/**", params="foo")
    public String showUsersTasks(Map<String,Object> model, @RequestParam("foo") String foo){
        homeTasks = homeTaskRepo.findAllByUserId(userRepo.findByUsername(foo).getId());
        model.put("userName", foo);
        model.put("homeTasks", homeTasks);
        return "homeTasks";
    }
    @PostMapping(value="/homeTasks/**", params="foo")
    public String addHomeTask(@RequestParam String date, @RequestParam String body, @RequestParam("foo") String foo, Map<String,Object> model){
        HomeTask homeTask = new HomeTask(userRepo.findByUsername(foo).getId(),date,body);
        homeTaskRepo.save(homeTask);
        homeTasks = homeTaskRepo.findAll();
        model.put("homeTasks", homeTasks);
        return "homeTasks";
    }
}

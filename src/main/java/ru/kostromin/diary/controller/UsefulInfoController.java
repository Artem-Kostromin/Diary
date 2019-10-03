package ru.kostromin.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.kostromin.diary.Utils.GetCurrentUserName;
import ru.kostromin.diary.domain.HomeTask;
import ru.kostromin.diary.domain.User;
import ru.kostromin.diary.repos.HomeTaskRepo;
import ru.kostromin.diary.repos.UserRepo;
//import ru.kostromin.diary.domain.MaterialsForStudents;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UsefulInfoController {

    @Autowired
    private HomeTaskRepo homeTaskRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/usefulInfo")
    public String showUsefulInfo(Map<String,Object> model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        model.put("username",currentUserName);
        List<HomeTask> homeTasks = homeTaskRepo.findAllByUserId(userRepo.findByUsername(currentUserName).getId());
        model.put("homeTasks",homeTasks);

        return "usefulInfo";
    }

   /* @PostMapping("/usefulInfo")
    public String uploadFile(@RequestParam("file") MultipartFile file, Map<String, Object> model) throws IOException {
       *//* MaterialsForStudents userContents = new MaterialsForStudents();

        if(file!=null){

            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            File finishFile = new File(resultFilename);
            file.transferTo(finishFile);
            userContents.setFilename(resultFilename);

            model.put("file", finishFile);
        }*//*
    return "usefulInfo";
    }*/
}

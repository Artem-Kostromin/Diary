package ru.kostromin.diary.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.kostromin.diary.domain.MaterialsForStudents;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class UsefulInfoController {

    /*@Value("${upload.path}")
    private String uploadPath;*/

    @GetMapping("/usefulInfo")
    public String showUsefulInfo(){
        return "usefulInfo";
    }

    @PostMapping("/usefulInfo")
    public String uploadFile(@RequestParam("file") MultipartFile file, Map<String, Object> model) throws IOException {
       /* MaterialsForStudents userContents = new MaterialsForStudents();

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
        }*/
    return "usefulInfo";
    }
}

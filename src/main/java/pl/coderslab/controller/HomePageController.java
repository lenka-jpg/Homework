package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController {

    @GetMapping("/lastoperations")
    @ResponseBody
    public String lastoperations(){
         List<Article> articles= new ArrayList<>();
         Article article= new Article();
         article.getId();


        return "";
    }

}

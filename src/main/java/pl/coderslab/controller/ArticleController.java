package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    Validator validator;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("article", articleDao.findAll());
        return "article/list";
    }

    @GetMapping("/form")
    public String addForm(Model model) {
        model.addAttribute("article", new Article());
        return "article/form";
    }

    @PostMapping("/form")
    public String addForm(@ModelAttribute Article article) {
        articleDao.save(article);
        return "redirect:/article";
    }

    @GetMapping("/form/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleDao.findById(id));
        return "article/form";
    }

    @PostMapping("/form/{id}")
    public String edit(@ModelAttribute Article article) {
        articleDao.save(article);
        return "redirect:/article";
    }

    @ModelAttribute("categories")
    public List<Category> modelCategories(){
        return categoryDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> modelAuthors(){
        return authorDao.findAll();
    }

}

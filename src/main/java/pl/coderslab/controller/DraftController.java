package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.dao.DraftDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Validator;
import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("/draft")
public class DraftController {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    Validator validator;

    @Autowired
    DraftDao draftDao;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("draft", draftDao.findAll());
        return "draft/list";
    }

    @GetMapping("/form")
    public String addForm(Model model) {
        model.addAttribute("draft", new Article());
        return "draft/form";
    }

    @PostMapping("/form")
    public String addForm(@ModelAttribute Article article) {
        articleDao.save(article);
        return "redirect:/draft";
    }

    @GetMapping("/form/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("draft", articleDao.findById(id));
        return "draft/form";
    }

    @PostMapping("/form/{id}")
    public String edit(@ModelAttribute Article article) {
        articleDao.save(article);
        return "redirect:/draft";
    }

    @ModelAttribute("categori" +
            "es")
    public List<Category> modelCategories(){
        return categoryDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> modelAuthors(){
        return authorDao.findAll();
    }


}


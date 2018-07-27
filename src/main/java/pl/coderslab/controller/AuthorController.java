package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorDao authorDao;

    @Autowired
    Validator validator;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("author", authorDao.findAll());
        return "author/list";
    }

    @GetMapping("/form")
    public String addForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/form";
    }

    @PostMapping("/form")
    public String addForm(@Valid Author author, BindingResult validResult) {
        if(validResult.hasErrors()){
            return "author/form";
        }
        authorDao.save(author);
        return "redirect:/author";
    }

    @GetMapping("/form/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorDao.findById(id));
        return "author/form";
    }

    @PostMapping("/form/{id}")
    public String edit(@ModelAttribute Author author) {
        authorDao.save(author);
        return "redirect:/author";
    }
}

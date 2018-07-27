package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Validator;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    Validator validator;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("category", categoryDao.findAll());
        return "category/list";
    }

    @GetMapping("/form")
    public String addForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/form";
    }

    @PostMapping("/form")
    public String addForm(@ModelAttribute Category category) {
        categoryDao.save(category);
        return "redirect:/category";
    }

    @GetMapping("/form/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryDao.findById(id));
        return "category/form";
    }

    @PostMapping("/form/{id}")
    public String edit(@ModelAttribute Category category) {
        categoryDao.save(category);
        return "redirect:/category";
    }





}



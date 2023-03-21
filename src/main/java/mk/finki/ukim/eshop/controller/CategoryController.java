package mk.finki.ukim.eshop.controller;

import mk.finki.ukim.eshop.model.enums.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @GetMapping("/list-categories")
    public List<Category> getAllCategories() {
        return Arrays.asList(Category.values());
    }
}

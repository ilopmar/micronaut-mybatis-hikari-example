package issue271.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import issue271.domain.Category;
import issue271.service.CategoryService;

@Controller("/categories")
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Get("/{categoryId}")
    public Category findCategory(Integer categoryId) {
        return categoryService.selectCategoryById(categoryId);
    }
}

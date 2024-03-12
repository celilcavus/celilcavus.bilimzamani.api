package com.celilcavus.bilimzamani.Controllers;

import com.celilcavus.bilimzamani.Entity.Categories;


import com.celilcavus.bilimzamani.Services.ICategoriesRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {



    private final ICategoriesRepository categoriesRepository;

    public CategoriesController(ICategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping()
    public Iterable<Categories> Get() {
        return this.categoriesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categories> get(@PathVariable("id") Integer id) {
        return this.categoriesRepository.findById(id);
    }

    @PostMapping()
    public int Post(@RequestBody Categories categories) {
        Categories categories1 = new Categories();
        categories1.setName(categories.getName());
        categories1.setActive(categories.isActive());
        this.categoriesRepository.save(categories1);
        return 1;
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Integer id) {
        var values = this.categoriesRepository.findById(id);
        if (values.isPresent()) {
            this.categoriesRepository.delete(values.get());
            return 1;
        }
        return 0;
    }


    @PutMapping("{id}")
    public int Put(@PathVariable("id") int id,@RequestBody Categories categories) {
        var values = this.categoriesRepository.findById(id);
        if (values.isPresent()) {
            values.get().setName(categories.getName());
            values.get().setActive(categories.isActive());
            values.get().setUpdateDate(LocalDateTime.now());
            this.categoriesRepository.save(values.get());
            return 1;
        }
        return 0;
    }


}

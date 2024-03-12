package com.celilcavus.bilimzamani.Services;

import com.celilcavus.bilimzamani.Entity.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICategoriesRepository extends CrudRepository<Categories,Integer> {
}

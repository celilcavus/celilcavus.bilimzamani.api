package com.celilcavus.bilimzamani.Services;

import com.celilcavus.bilimzamani.Entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorRepository extends CrudRepository<Author,Integer> {
}

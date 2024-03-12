package com.celilcavus.bilimzamani.Services;

import com.celilcavus.bilimzamani.Entity.About;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAboutRepository extends CrudRepository<About,Integer> {
}

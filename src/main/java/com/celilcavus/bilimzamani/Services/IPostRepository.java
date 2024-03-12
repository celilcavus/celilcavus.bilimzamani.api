package com.celilcavus.bilimzamani.Services;

import com.celilcavus.bilimzamani.Entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPostRepository extends CrudRepository<Post,Integer> {
}

package com.celilcavus.bilimzamani.Services;

import com.celilcavus.bilimzamani.Entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends CrudRepository<Contact,Integer> {

}

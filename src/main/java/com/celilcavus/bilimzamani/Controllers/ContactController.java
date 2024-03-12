package com.celilcavus.bilimzamani.Controllers;

import com.celilcavus.bilimzamani.Entity.Contact;
import com.celilcavus.bilimzamani.Services.IContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/contact")
public class ContactController {



    private final IContactRepository iContactRepository;

    public ContactController(IContactRepository iContactRepository) {
        this.iContactRepository = iContactRepository;
    }

    @GetMapping

    public Iterable<Contact> Get() {
        return this.iContactRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Contact> Get(@PathVariable("id") Integer id) {
        return this.iContactRepository.findById(id);
    }

    @PostMapping
    public int Post(@RequestBody Contact contact) {
        this.iContactRepository.save(contact);
        return 1;
    }

    @DeleteMapping("{id}")
    public int Delete(@PathVariable("id") Integer id) {
        var values = this.iContactRepository.findById(id);
        if (values.isPresent()) {
            this.iContactRepository.delete(values.get());
            return 1;
        }
        return 0;
    }


    @PutMapping("{id}")
    public int Put(@PathVariable("id") Integer id, @RequestBody Contact contact) {
        var values = this.iContactRepository.findById(id);
        if (values.isPresent()) {
            values.map(x -> {
                x.setName(contact.getName());
                x.setSubject(contact.getSubject());
                x.setSurname(contact.getSurname());
                x.setMail(contact.getMail());
                x.setSubject(contact.getSubject());
                this.iContactRepository.save(x);
                return 1;
            });
            return 1;
        }
        else return 0;
    }
}

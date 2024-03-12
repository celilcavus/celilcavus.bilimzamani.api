package com.celilcavus.bilimzamani.Controllers;
import com.celilcavus.bilimzamani.Entity.Author;
import com.celilcavus.bilimzamani.HelperClasses.FromFile;
import com.celilcavus.bilimzamani.Services.IAuthorRepository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {


    private final IAuthorRepository iAuthorRepository;


    private final FromFile iFromFile;
    public AuthorController(IAuthorRepository iAuthorRepository, FromFile iFromFile) {
        this.iAuthorRepository = iAuthorRepository;
        this.iFromFile = iFromFile;
    }

    @GetMapping()
    public Iterable<Author> get()
    {
        return this.iAuthorRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Author> get(@PathVariable("id") Integer id)
    {
        return this.iAuthorRepository.findById(id);
    }

    @PostMapping()
    public int Post(@ModelAttribute Author author)
    {
        Author author1  = new Author();
        author1.setName(author.getName());
        author1.setSurname(author.getSurname());
        author1.setAbout(author.getAbout());
        author1.setMail(author.getMail());
        author1.setActive(author.isActive());

        //images
        author1.setImage(author.getImage());
        String filename = iFromFile.SaveImage(author1.getImage());
        author1.setImageName(filename);

        this.iAuthorRepository.save(author1);
        return 1;
    }

    @DeleteMapping("{id}")
    public int Delete(@PathVariable("id") Integer id)
    {
        var values = this.iAuthorRepository.findById(id);
        if (values.isPresent())
        {
            this.iFromFile.DeleteImage(values.get().getImageName());
            this.iAuthorRepository.delete(values.get());
            return 1;
        }
        else
            return 0;
    }

    @PutMapping("{id}")
    public int Put(@PathVariable("id") Integer id,@ModelAttribute Author author)
    {

        var values = this.iAuthorRepository.findById(id);

        if (values.isPresent())
        {
            if(author.getImage().isEmpty())
            {
                values.map(x->{
                    x.setName(author.getName());
                    x.setSurname(author.getSurname());
                    x.setMail(author.getMail());
                    x.setActive(author.isActive());
                    x.setAbout(author.getAbout());
                    x.setUpdateDate(LocalDateTime.now());
                    return this.iAuthorRepository.save(x);
                });

            }
            else
            {
                values.map(x->{
                    x.setName(author.getName());
                    x.setSurname(author.getSurname());
                    x.setMail(author.getMail());
                    x.setActive(author.isActive());
                    x.setAbout(author.getAbout());
                    x.setUpdateDate(LocalDateTime.now());
                    this.iFromFile.DeleteImage(values.get().getImageName());
                    String file = this.iFromFile.SaveImage(author.getImage());
                    x.setImageName(file);
                    return this.iAuthorRepository.save(x);
                });
            }
            return 1;

        }
        else
            return 0;
    }
}

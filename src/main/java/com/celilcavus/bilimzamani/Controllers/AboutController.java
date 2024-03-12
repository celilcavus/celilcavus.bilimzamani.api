package com.celilcavus.bilimzamani.Controllers;

import com.celilcavus.bilimzamani.Entity.About;
import com.celilcavus.bilimzamani.HelperClasses.FromFile;
import com.celilcavus.bilimzamani.Services.IAboutRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/about")
public class AboutController {


    private final IAboutRepository iAboutRepository;

    private final FromFile file;


    public AboutController(IAboutRepository iAboutRepository, FromFile file) {
        this.iAboutRepository = iAboutRepository;
        this.file = file;
    }

    @GetMapping
    public Iterable<About> get() {
        return this.iAboutRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<About> get(@PathVariable("id") Integer id) {
        return this.iAboutRepository.findById(id);
    }

    @PostMapping
    public int Post(@ModelAttribute About about) {
        About about1 = new About();
        String image = this.file.SaveImage(about.getImage());
        about1.setImageName(image);
        about1.setTitle(about.getTitle());
        about1.setDescription(about.getDescription());
        about1.setBankName1(about.getBankName1());
        about1.setBankIban1(about.getBankIban1());
        about1.setBankName2(about.getBankName2());
        about1.setBankIban2(about.getBankIban2());
        this.iAboutRepository.save(about1);
        return 0;
    }

    @PutMapping("{id}")
    public int Put(@ModelAttribute About about, @PathVariable("id") Integer id) {
        var values = this.iAboutRepository.findById(id);

        if (values.isPresent()) {
            values.map(x -> {
                if (!x.getImage().isEmpty())
                {
                    this.file.DeleteImage(values.get().getImageName());
                    String image = this.file.SaveImage(about.getImage());
                    x.setImageName(image);
                }
                x.setTitle(about.getTitle());
                x.setDescription(about.getDescription());
                x.setBankName1(about.getBankName1());
                x.setBankName2(about.getBankName2());
                x.setBankIban1(about.getBankIban1());
                x.setBankIban2(about.getBankIban2());
                this.iAboutRepository.save(x);
                return 1;
            });
        }

        return 0;
    }
}

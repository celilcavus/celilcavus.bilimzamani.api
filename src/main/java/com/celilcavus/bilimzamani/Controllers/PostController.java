package com.celilcavus.bilimzamani.Controllers;

import com.celilcavus.bilimzamani.Entity.Post;
import com.celilcavus.bilimzamani.HelperClasses.FromFile;
import com.celilcavus.bilimzamani.Services.IPostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class PostController {


    private final IPostRepository iPostRepository;

    private final FromFile file;

    public PostController(IPostRepository iPostRepository, FromFile file) {
        this.iPostRepository = iPostRepository;
        this.file = file;
    }


    @GetMapping
    public Iterable<Post> get() {
        return this.iPostRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Post> get(@PathVariable("id") Integer id) {
        return this.iPostRepository.findById(id);
    }

    @PostMapping
    public int post(@ModelAttribute Post post) {
        Post post1 = new Post();
        try {
            String image1 = file.SaveImage(post.getImage());
            post1.setImageName1(image1);

            String image2 = file.SaveImage(post.getImage2());
            post1.setImageName2(image2);

            String image3 = file.SaveImage(post.getImage3());
            post1.setImageName3(image3);

            String image4 = file.SaveImage(post.getImage4());
            post1.setImageName4(image4);

            post1.setTitle(post.getTitle());
            post1.setDescription(post.getDescription());
            post1.setCategories(post.getCategories());


            post1.setAuthor(post.getAuthor());
            post1.setCategories(post.getCategories());

            this.iPostRepository.save(post1);
            return 1;
        } catch (Exception ex) {
            System.out.println("Post Exception === " + ex.getMessage());
        }
        return 0;
    }


    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Integer id) {
        var values = this.iPostRepository.findById(id);
        if (values.isPresent()) {
            this.file.DeleteImage(values.get().getImageName1());
            this.file.DeleteImage(values.get().getImageName2());
            this.file.DeleteImage(values.get().getImageName3());
            this.file.DeleteImage(values.get().getImageName4());
            this.iPostRepository.delete(values.get());
            return 1;
        } else
            return 0;

    }

    @PutMapping("{id}")
    public int Put(@ModelAttribute Post post, @PathVariable("id") Integer id) {
        var values = this.iPostRepository.findById(id);
        try {
            if (values.isPresent()) {

                values.map(x->{
                    if (!post.getImage().isEmpty())
                    {
                        this.file.DeleteImage(values.get().getImageName1());
                        String image = this.file.SaveImage(post.getImage());
                        post.setImageName1(image);

                    }
                    if (!post.getImage2().isEmpty())
                    {
                        this.file.DeleteImage(values.get().getImageName2());
                        String image = this.file.SaveImage(post.getImage2());
                        post.setImageName1(image);

                    }
                    if (!post.getImage3().isEmpty())
                    {
                        this.file.DeleteImage(values.get().getImageName3());
                        String image = this.file.SaveImage(post.getImage3());
                        post.setImageName1(image);

                    }
                    if (!post.getImage4().isEmpty())
                    {
                        this.file.DeleteImage(values.get().getImageName4());
                        String image = this.file.SaveImage(post.getImage4());
                        post.setImageName1(image);

                    }

                    post.setTitle(x.getTitle());
                    post.setDescription(x.getDescription());
                    post.setCategories(x.getCategories());
                    post.setAuthor(x.getAuthor());
                    this.iPostRepository.save(post);
                    return 1;
                });
            } else {
                return 0;
            }

        } catch (Exception ex) {
            System.out.println("PUT EXCEPTİON === " + ex.getMessage());
        }
        return 0;
    }
}

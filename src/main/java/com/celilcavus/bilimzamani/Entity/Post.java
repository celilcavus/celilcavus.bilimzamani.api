package com.celilcavus.bilimzamani.Entity;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Post extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Transient
    private MultipartFile image;
    private String imageName1;
    @Transient
    private MultipartFile image2;
    private String imageName2;
    @Transient
    private MultipartFile image3;
    private String imageName3;
    @Transient
    private MultipartFile image4;
    private String imageName4;

    private String title;

    private String Description;
    @OneToOne
    private Categories categories;



    @OneToOne
    private Author author;




    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageName1() {
        return imageName1;
    }

    public void setImageName1(String imageName1) {
        this.imageName1 = imageName1;
    }

    public MultipartFile getImage2() {
        return image2;
    }

    public void setImage2(MultipartFile image2) {
        this.image2 = image2;
    }

    public String getImageName2() {
        return imageName2;
    }

    public void setImageName2(String imageName2) {
        this.imageName2 = imageName2;
    }

    public MultipartFile getImage3() {
        return image3;
    }

    public void setImage3(MultipartFile image3) {
        this.image3 = image3;
    }

    public String getImageName3() {
        return imageName3;
    }

    public void setImageName3(String imageName3) {
        this.imageName3 = imageName3;
    }

    public MultipartFile getImage4() {
        return image4;
    }

    public void setImage4(MultipartFile image4) {
        this.image4 = image4;
    }

    public String getImageName4() {
        return imageName4;
    }

    public void setImageName4(String imageName4) {
        this.imageName4 = imageName4;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

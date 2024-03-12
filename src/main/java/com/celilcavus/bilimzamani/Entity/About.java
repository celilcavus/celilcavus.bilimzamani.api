package com.celilcavus.bilimzamani.Entity;


import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String description;
    @Transient
    private MultipartFile image;

    private String imageName;

    private String BankName1;
    private String BankIban1;

    private String BankName2;
    private String BankIban2;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBankName1() {
        return BankName1;
    }

    public void setBankName1(String bankName1) {
        BankName1 = bankName1;
    }

    public String getBankIban1() {
        return BankIban1;
    }

    public void setBankIban1(String bankIban1) {
        BankIban1 = bankIban1;
    }

    public String getBankName2() {
        return BankName2;
    }

    public void setBankName2(String bankName2) {
        BankName2 = bankName2;
    }

    public String getBankIban2() {
        return BankIban2;
    }

    public void setBankIban2(String bankIban2) {
        BankIban2 = bankIban2;
    }
}

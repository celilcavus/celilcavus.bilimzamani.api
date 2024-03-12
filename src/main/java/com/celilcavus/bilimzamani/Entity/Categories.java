package com.celilcavus.bilimzamani.Entity;

import jakarta.persistence.*;

@Entity
public class Categories extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Name;

    @OneToOne(mappedBy = "categories")
    private Post post;
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

package com.schmittspecialites.dndgame.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

//import org.springframework.data.annotation.Id;

import java.util.Random;

@Entity
@Table(name = "characters")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "character_class")
public class DndClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Transient
    private String character_class;
    private String name;
    private int health;

    public DndClass() {
    }

    public DndClass(String name, int health) {
        this.name = name;
        this.health = health;
    }

    @PostLoad
    public void setType() {
        this.character_class = this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

    public String getCharacterClass() {
        return character_class;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    protected static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

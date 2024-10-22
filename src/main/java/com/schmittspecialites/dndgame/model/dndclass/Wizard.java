package com.schmittspecialites.dndgame.model.dndclass;

import com.schmittspecialites.dndgame.model.DndClass;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Wizard")
public class Wizard extends DndClass {
    private int mana;

    public Wizard() {
    }

    public Wizard(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

}

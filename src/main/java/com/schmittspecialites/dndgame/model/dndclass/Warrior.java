package com.schmittspecialites.dndgame.model.dndclass;

import com.schmittspecialites.dndgame.model.DndClass;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Warrior")
public class Warrior extends DndClass {

    private int rage;

    public Warrior() {
    }

    public Warrior(String name, int health, int rage) {
        super(name, health);
        this.rage = rage;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

}

package com.schmittspecialites.dndgame.model.dndclass;

import com.schmittspecialites.dndgame.model.DndClass;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Ranger")
public class Ranger extends DndClass {
    private int energy;

    public Ranger() {
    }

    public Ranger(String name, int health, int energy) {
        super(name, health);
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

}

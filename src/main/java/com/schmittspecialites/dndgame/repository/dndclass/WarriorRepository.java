package com.schmittspecialites.dndgame.repository.dndclass;

import com.schmittspecialites.dndgame.model.dndclass.Warrior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarriorRepository extends JpaRepository<Warrior, Integer> {
}

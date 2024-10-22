package com.schmittspecialites.dndgame.repository;

import com.schmittspecialites.dndgame.model.DndClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnDClassRepository extends JpaRepository<DndClass, Integer> {
}

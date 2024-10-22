package com.schmittspecialites.dndgame.repository.dndclass;

import com.schmittspecialites.dndgame.model.dndclass.Ranger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RangerRepository extends JpaRepository<Ranger, Integer> {
}

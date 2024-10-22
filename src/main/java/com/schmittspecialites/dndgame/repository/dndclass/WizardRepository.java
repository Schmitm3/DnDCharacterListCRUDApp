package com.schmittspecialites.dndgame.repository.dndclass;

import com.schmittspecialites.dndgame.model.dndclass.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Integer> {
}

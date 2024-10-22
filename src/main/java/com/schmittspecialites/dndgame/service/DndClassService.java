package com.schmittspecialites.dndgame.service;

import com.schmittspecialites.dndgame.model.DndClass;
import com.schmittspecialites.dndgame.model.dndclass.Ranger;
import com.schmittspecialites.dndgame.model.dndclass.Warrior;
import com.schmittspecialites.dndgame.model.dndclass.Wizard;
import com.schmittspecialites.dndgame.repository.DnDClassRepository;
import com.schmittspecialites.dndgame.repository.dndclass.RangerRepository;
import com.schmittspecialites.dndgame.repository.dndclass.WarriorRepository;
import com.schmittspecialites.dndgame.repository.dndclass.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DndClassService {

    @Autowired
    DnDClassRepository dndClassRepository;

    @Autowired
    RangerRepository rangerRepository;

    @Autowired
    WarriorRepository warriorRepository;

    @Autowired
    WizardRepository wizardRepository;

    public DndClassService() {

    }

    public List<DndClass> fetchAll() {
        return dndClassRepository.findAll();
    }

    public Ranger addRanger(Ranger ranger) {
        return rangerRepository.save(ranger);
    }

    public Warrior addWarrior(Warrior warrior) {
        return warriorRepository.save(warrior);
    }

    public Wizard addWizard(Wizard wizard) {
        return wizardRepository.save(wizard);
    }

    public String deleteCharacter(int id) {
        dndClassRepository.deleteById(id);
        return "Character Deleted";
    }

    public Optional<DndClass> fetchById(int id) {
        return dndClassRepository.findById(id);
    }

    public Optional<DndClass> updateCharactyerById(int id, DndClass characterDetails) {
        Optional<DndClass> character = dndClassRepository.findById(id);
        if (character.isPresent()) {
            character.get().setName(characterDetails.getName());
            return Optional.ofNullable(dndClassRepository.save(character.get()));
        }
        return Optional.empty();
    }
}

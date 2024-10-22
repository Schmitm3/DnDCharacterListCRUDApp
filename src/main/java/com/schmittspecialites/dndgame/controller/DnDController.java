package com.schmittspecialites.dndgame.controller;

import com.schmittspecialites.dndgame.model.DndClass;
import com.schmittspecialites.dndgame.model.dndclass.Ranger;
import com.schmittspecialites.dndgame.model.dndclass.Warrior;
import com.schmittspecialites.dndgame.model.dndclass.Wizard;
import com.schmittspecialites.dndgame.service.DndClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DnDController {

    @Autowired
    DndClassService dndClassService;

    @PostMapping("/characters/ranger")
    public Ranger addRangerClass(@RequestBody Ranger ranger) {
        return dndClassService.addRanger(ranger);
    }

    @PostMapping("/characters/warrior")
    public Warrior addWarriorClass(@RequestBody Warrior warrior) {
        return dndClassService.addWarrior(warrior);
    }

    @PostMapping("/characters/wizard")
    public Wizard addWizardClass(@RequestBody Wizard wizard) {
        return dndClassService.addWizard(wizard);
    }

    @PutMapping("/characters/warrior/{id}")
    public Optional<DndClass> updateWarriorCharacter(@PathVariable int id, @RequestBody DndClass characterDetails) {
        return dndClassService.updateCharactyerById(id, characterDetails);
    }

    @PutMapping("/characters/wizard/{id}")
    public Optional<DndClass> updateWizardCharacter(@PathVariable int id, @RequestBody DndClass characterDetails) {
        return dndClassService.updateCharactyerById(id, characterDetails);
    }

    @PutMapping("/characters/ranger/{id}")
    public Optional<DndClass> updateRangerCharacter(@PathVariable int id, @RequestBody DndClass characterDetails) {
        return dndClassService.updateCharactyerById(id, characterDetails);
    }

    @GetMapping("/characters/all")
    public List<DndClass> allCharacter() {
        return dndClassService.fetchAll();
    }

    @GetMapping("/characters/{id}")
    public Optional<DndClass> getCharacterById(@PathVariable int id) {
        return dndClassService.fetchById(id);
    }

    @DeleteMapping("/characters/{id}")
    public String deleteCharacter(@PathVariable("id") int id) {
       return dndClassService.deleteCharacter(id);
    }

}

package br.com.warley.petvetapi.controller;

import br.com.warley.petvetapi.model.Animal;
import br.com.warley.petvetapi.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Long id) {
        return animalService.findById(id);
    }

    @PostMapping("/adicinarAnimal")
    public Animal save(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable Long id, @RequestBody Animal animal) {
        return animalService.update(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        animalService.deleteById(id);
    }

}

package br.com.warley.petvetapi.service;


import br.com.warley.petvetapi.exception.AnimalException;
import br.com.warley.petvetapi.model.Animal;
import br.com.warley.petvetapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new AnimalException(id));
    }

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal update(Animal animal) {
        Animal animalExistente = animalRepository.findById(animal.getId())
                .orElseThrow(() -> new AnimalException(animal.getId()));

        animalExistente.setNome(animal.getNome());
        animalExistente.setRaca(animal.getRaca());
        animalExistente.setEspecie((animal.getEspecie()));
        animalExistente.setIdade(animal.getIdade());

        return animalRepository.save(animalExistente);
    }

}

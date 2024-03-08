package br.com.warley.petvetapi.controller;

import br.com.warley.petvetapi.model.MedicoVeterinario;
import br.com.warley.petvetapi.service.MedicoVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoVeterinarioController {

    @Autowired
    private MedicoVeterinarioService medicoVeterinarioService;

    @GetMapping
    public List<MedicoVeterinario> findAll() {
        return medicoVeterinarioService.findAll();
    }

    @GetMapping("/{id}")
    public MedicoVeterinario findById(@PathVariable Long id) {
        return medicoVeterinarioService.findById(id);
    }

    @PostMapping("/adicionarMedico")
    public MedicoVeterinario save(@RequestBody MedicoVeterinario medicoVeterinario) {
        return medicoVeterinarioService.save(medicoVeterinario);
    }

    @PutMapping("/{id}")
    public MedicoVeterinario update(@PathVariable Long id, @RequestBody MedicoVeterinario medicoVeterinario) {
        return medicoVeterinarioService.update(medicoVeterinario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        medicoVeterinarioService.deleteById(id);
    }
}
package br.com.warley.petvetapi.controller;

import br.com.warley.petvetapi.model.Consulta;
import br.com.warley.petvetapi.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> findAll() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public Consulta findById(@PathVariable Long id) {
        return consultaService.findById(id);
    }

    @PostMapping("/adicionarConsulta")
    public Consulta save(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    @PutMapping("/{id}")
    public Consulta update(@PathVariable Long id, @RequestBody Consulta consulta) {
        return consultaService.update(consulta);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        consultaService.deleteById(id);
    }

}
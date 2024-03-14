package br.com.warley.petvetapi.service;

import br.com.warley.petvetapi.exception.AnimalException;
import br.com.warley.petvetapi.exception.ConsultaException;
import br.com.warley.petvetapi.exception.MedicoVeterinarioException;
import br.com.warley.petvetapi.model.Animal;
import br.com.warley.petvetapi.model.Consulta;
import br.com.warley.petvetapi.model.MedicoVeterinario;
import br.com.warley.petvetapi.repository.AnimalRepository;
import br.com.warley.petvetapi.repository.ConsultaRepository;
import br.com.warley.petvetapi.repository.MedicoVeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private MedicoVeterinarioRepository medicoVeterinarioRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Consulta findById(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new ConsultaException(id));
    }

    public Consulta save(Consulta consulta) {
        // Buscar o animal pelo ID
        Animal animal = animalRepository.findById(consulta.getAnimal().getId())
                .orElseThrow(() -> new AnimalException(consulta.getAnimal().getId()));

        // Buscar o médico veterinário pelo ID
        MedicoVeterinario medicoVeterinario = medicoVeterinarioRepository.findById(consulta.getMedicoVeterinario().getId())
                .orElseThrow(() -> new MedicoVeterinarioException(consulta.getMedicoVeterinario().getId()));

        // Atribuir o animal e o médico veterinário à consulta
        consulta.setAnimal(animal);
        consulta.setMedicoVeterinario(medicoVeterinario);

        // Salvar a consulta no banco de dados
        return consultaRepository.save(consulta);
    }

    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

    public Consulta update(Consulta consulta) {
        Consulta consultaExistente = consultaRepository.findById(consulta.getId())
                .orElseThrow(() -> new ConsultaException(consulta.getId()));

        consultaExistente.setData(consulta.getData());
        consultaExistente.setHora(consulta.getHora());
        consultaExistente.setMotivoConsulta(consulta.getMotivoConsulta());
        consultaExistente.setObservacoes(consulta.getObservacoes());

        return consultaRepository.save(consultaExistente);
    }

}
package br.com.warley.petvetapi.service;

import br.com.warley.petvetapi.exception.MedicoVeterinarioException;
import br.com.warley.petvetapi.model.MedicoVeterinario;
import br.com.warley.petvetapi.repository.MedicoVeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoVeterinarioService {

    @Autowired
    private MedicoVeterinarioRepository medicoVeterinarioRepository;

    public List<MedicoVeterinario> findAll() {
        return medicoVeterinarioRepository.findAll();
    }

    public MedicoVeterinario findById(Long id) {
        return medicoVeterinarioRepository.findById(id)
                .orElseThrow(() -> new MedicoVeterinarioException(id));
    }

    public MedicoVeterinario save(MedicoVeterinario medicoVeterinario) {
        return medicoVeterinarioRepository.save(medicoVeterinario);
    }

    public void deleteById(Long id) {
        medicoVeterinarioRepository.deleteById(id);
    }

    public MedicoVeterinario update(MedicoVeterinario medicoVeterinario) {
        MedicoVeterinario medicoVeterinarioExistente = medicoVeterinarioRepository.findById(medicoVeterinario.getId())
                .orElseThrow(() -> new MedicoVeterinarioException(medicoVeterinario.getId()));

        medicoVeterinarioExistente.setNome(medicoVeterinario.getNome());
        medicoVeterinarioExistente.setTelefone(medicoVeterinario.getTelefone());
        medicoVeterinarioExistente.setEmail(medicoVeterinario.getEmail());
        medicoVeterinarioExistente.setCrmv(medicoVeterinario.getCrmv());

        return medicoVeterinarioRepository.save(medicoVeterinarioExistente);
    }

}
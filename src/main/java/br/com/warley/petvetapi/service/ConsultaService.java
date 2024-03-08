package br.com.warley.petvetapi.service;

import br.com.warley.petvetapi.exception.ConsultaException;
import br.com.warley.petvetapi.model.Consulta;
import br.com.warley.petvetapi.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Consulta findById(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new ConsultaException(id));
    }

    public Consulta save(Consulta consulta) {
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
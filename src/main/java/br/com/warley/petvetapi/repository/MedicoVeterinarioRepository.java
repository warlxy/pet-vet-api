package br.com.warley.petvetapi.repository;

import br.com.warley.petvetapi.model.MedicoVeterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoVeterinarioRepository extends JpaRepository<MedicoVeterinario, Long> {
}

package br.com.warley.petvetapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "medico_veterinario")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoVeterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "crmv", nullable = false)
    private String crmv;

    @OneToMany(mappedBy = "medicoVeterinario", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consulta> consultas;

}
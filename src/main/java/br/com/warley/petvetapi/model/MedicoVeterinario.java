package br.com.warley.petvetapi.model;

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

    @OneToMany
    private List<Consulta> consultas;

}
package br.com.warley.petvetapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "consulta")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "hora", nullable = false)
    private Time hora;

    @Column(name = "motivo_consulta", nullable = false)
    private String motivoConsulta;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "medico_veterinario_id")
    private MedicoVeterinario medicoVeterinario;

}
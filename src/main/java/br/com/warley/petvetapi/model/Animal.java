package br.com.warley.petvetapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "animal")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "raca", nullable = false)
    private String raca;

    @Column(name = "especie", nullable = false)
    private String especie;

    @Column(name = "idade")
    private Integer idade;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consulta> consultas;

}

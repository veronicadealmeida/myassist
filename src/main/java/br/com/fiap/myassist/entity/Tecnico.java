package br.com.fiap.myassist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_TECNICO")
public class Tecnico extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TECNICO")
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

}

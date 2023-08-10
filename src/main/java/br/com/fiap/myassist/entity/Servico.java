package br.com.fiap.myassist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "TBL_SERVICO")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICO")
    private Long id;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @Column(name = "NR_VALOR")
    private BigDecimal valor;

}

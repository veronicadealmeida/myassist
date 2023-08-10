package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.TipoEquipamentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;



@Getter
@Setter
@Entity
@Table(name = "TBL_EQUIPAMENTO")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIPAMENTO")
    private Long id;

    @Column(name = "TX_MARCA")
    private String marca;

    @Column(name = "TX_MODELO")
    private String modelo;

    @Column(name = "TX_NUMERO_SERIE")
    private String numeroSerie;

    @Column(name = "TX_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoEquipamentoEnum tipo;

    @PrePersist
    private void prePersist() {
        if (numeroSerie == null) {
            this.numeroSerie = UUID.randomUUID().toString();
        }
    }

}

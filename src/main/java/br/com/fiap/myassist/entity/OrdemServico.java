package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.PrioridadeExecucaoEnum;
import br.com.fiap.myassist.enums.StatusExecucaoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_ORDEM_SERVICO")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORDEM_SERVICO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPAMENTO")
    private Equipamento equipamento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @Column(name = "DT_ENTRADA")
    private LocalDateTime dataEntrada;

    @Column(name = "DT_PREVISAO")
    private LocalDateTime dataPrevisao;

    @Column(name = "TX_DEFEITO")
    private String defeito;

    @Column(name = "NR_PRIORIDADE")
    @Enumerated(EnumType.ORDINAL)
    private PrioridadeExecucaoEnum prioridade;

    @ManyToMany
    @JoinTable(name = "TBL_REL_OS_TECNICO",
               joinColumns = @JoinColumn(name = "ID_ORDEM_SERVICO"),
               inverseJoinColumns = @JoinColumn(name = "ID_TECNICO"))
    private List<Tecnico> responsaveis;

    @Column(name = "DT_SAIDA")
    private LocalDateTime dataSaida;

    @Column(name = "TX_STATUS")
    @Enumerated(EnumType.STRING)
    private StatusExecucaoEnum status;

    @Transient
    private BigDecimal valorTotal;

    @PrePersist
    private void prePersist() {
        this.status = StatusExecucaoEnum.ABERTO;
    }

}

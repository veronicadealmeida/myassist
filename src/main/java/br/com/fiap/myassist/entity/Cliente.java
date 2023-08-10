package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.TipoDocumentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_CLIENTE")
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "TX_DOCUMENTO")
    private String documento;

    @Enumerated(EnumType.STRING)
    @Column(name = "TX_TIPO_DOCUMENTO")
    private TipoDocumentoEnum tipoDocumento;

    /*@Embedded
    protected Endereco endereco;*/

    @PrePersist
    private void prePersist() {
        this.tipoDocumento = TipoDocumentoEnum.CPF;
    }

}

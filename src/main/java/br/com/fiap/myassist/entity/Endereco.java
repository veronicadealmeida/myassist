package br.com.fiap.myassist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {

    @Column(name = "TX_LOGRADOURO")
    private String logradouro;

    @Column(name = "TX_NUMERO")
    private String numero;

    @Column(name = "TX_COMPLEMENTO")
    private String complemento;

    @Column(name = "TX_BAIRRO")
    private String bairro;

    @Column(name = "TX_CIDADE")
    private String cidade;

    @Column(name = "TX_ESTADO")
    private String estado;

    @Column(name = "TX_CEP")
    private String cep;

}

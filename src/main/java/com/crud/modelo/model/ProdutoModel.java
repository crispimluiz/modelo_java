package com.crud.modelo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produtos")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 10, nullable = false)
    private Double valor;

    @Column(name = "porcentagem_desconto",length = 10, nullable = false)
    private Double descontoPorcentagem;

    @Column(name = "valor_do_desconto",length = 10, nullable = false)
    private Double valorDoDesconto;

    @Column(name = "valor_final",length = 10, nullable = false)
    private Double valorFinal;
}

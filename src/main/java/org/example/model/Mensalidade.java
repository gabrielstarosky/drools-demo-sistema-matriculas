package org.example.model;

import org.example.model.enums.StatusPagamento;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Mensalidade {
    private Long id;
    private Matricula matricula;
    private double valorBase;
    private double valorFinal;
    private Desconto descontoAplicado;
    private LocalDate dataVencimento;
    private StatusPagamento status;
}
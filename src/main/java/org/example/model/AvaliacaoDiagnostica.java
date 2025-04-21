package org.example.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AvaliacaoDiagnostica {
    private Long id;
    private Aluno aluno;
    private LocalDate dataAvaliacao;
    private boolean aprovado;
    private String observacoes;
}
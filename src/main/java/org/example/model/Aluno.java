package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Aluno {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Endereco endereco;
    private List<Documento> documentos;
    private boolean estrangeiro = false;
    private boolean possuiDeficiencia = false;
    private List<Advertencia> advertencias;
    private double frequencia;
    private SituacaoFinanceira situacaoFinanceira;
    private List<AvaliacaoDiagnostica> avaliacoesDiagnosticas;

    public int getIdade() {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

}

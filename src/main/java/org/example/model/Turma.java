package org.example.model;

import org.example.model.enums.NivelEnsino;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Turma {
    private Long id;
    private String codigo;
    private int anoLetivo;
    private NivelEnsino nivel;
    private int capacidadeMaxima;
    private int vagasDisponiveis;
    private List<Matricula> matriculas;
    private int idadeMinima;
}
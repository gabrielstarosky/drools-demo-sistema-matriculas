package org.example.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Advertencia {
    private Long id;
    private Aluno aluno;
    private LocalDate data;
    private String motivo;
    private String descricao;
    private String responsavel; // Quem aplicou a advertência
}
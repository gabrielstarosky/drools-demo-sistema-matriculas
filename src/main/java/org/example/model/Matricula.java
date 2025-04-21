package org.example.model;

import org.example.model.enums.StatusMatricula;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Matricula {
    private Long id;
    private Aluno aluno;
    private Turma turma;
    private StatusMatricula status;
    private LocalDateTime dataMatricula;
    private List<MotivoInaptidao> motivosInaptidao;
    private List<Documento> documentosApresentados;
    private boolean transferido = false;
}

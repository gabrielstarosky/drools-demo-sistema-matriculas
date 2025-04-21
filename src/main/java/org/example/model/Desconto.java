package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Desconto {
    private TipoDesconto tipo;
    private double percentual;
    private String justificativa;
    private int prioridade;
}
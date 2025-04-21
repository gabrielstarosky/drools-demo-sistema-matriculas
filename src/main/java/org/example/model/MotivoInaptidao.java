package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MotivoInaptidao {
    private String descricao;
    private String codigo;
    private boolean impeditivo;
}
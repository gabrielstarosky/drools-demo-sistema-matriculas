package org.example.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SituacaoFinanceira {
    private int mesesEmAtraso;
    private boolean inadimplente;
    private List<Mensalidade> mensalidades;
}
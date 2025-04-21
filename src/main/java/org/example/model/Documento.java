package org.example.model;

import org.example.model.enums.TipoDocumento;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Documento {
    private TipoDocumento tipo;
    private String numero;
    private LocalDate dataEmissao;
    private String arquivo; // caminho ou blob do documento
    private boolean validado;
}

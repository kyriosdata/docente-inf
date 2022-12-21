package com.github.kyriosdata.docenteinf.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Uma avaliação de um docente.
 */
@Getter
@Setter
public class Avaliacao {

    /**
     * O docente cujos dados são empregados
     * na avaliação.
     */
    private Docente docente;

    /**
     * A data em que foi requisitada a avaliação.
     */
    private LocalDate data;

    /**
     * A identificação de quem fez a requisição.
     */
    private String requisitadaPor;

    /**
     * A análise produzida pela avaliação.
     */
    private Analise analise;
}

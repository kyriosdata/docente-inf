package com.github.kyriosdata.docenteinf.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Representa uma avaliação.
 */
@Getter
@Setter
public class Avaliacao {
    private Docente docente;
    private LocalDate data;
    private String requisitadaPor;
    private Analise analise;
}

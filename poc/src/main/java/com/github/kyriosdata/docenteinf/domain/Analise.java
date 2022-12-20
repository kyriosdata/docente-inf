package com.github.kyriosdata.docenteinf.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Representa uma análise de um docente.
 */
@Getter
@Setter
public class Analise {
    private LocalDateTime instante;
    private Contexto entrada;
    private Contexto saida;
    private ResolucaoId resolucao;

    public Analise() {
        instante = LocalDateTime.now();
    }
}

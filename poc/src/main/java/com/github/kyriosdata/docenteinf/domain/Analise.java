/*
 * Copyright (c) 2023.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.docenteinf.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Resultado da execução de uma requisição de
 * avaliação de desempenho ({@link Avaliacao}).
 */
@Getter
@Setter
public class Analise {

    /**
     * O identificador único da análise (surrogate key).
     */
    private String id;

    /**
     * Instante em que a análise foi produzida.
     */
    private LocalDateTime instante;

    /**
     * Dados de entrada empregados na avaliação dos
     * indicadores da resolução em questão.
     */
    private Contexto entrada;

    /**
     * Resultados da avaliação dos indicadores da
     * resolução em questão.
     */
    private Contexto saida;

    /**
     * Identificador da resolução que foi empregada
     * na avaliação.
     */
    private ResolucaoId resolucao;

    public Analise() {
        instante = LocalDateTime.now();
    }
}

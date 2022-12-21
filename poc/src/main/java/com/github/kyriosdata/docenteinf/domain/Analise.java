package com.github.kyriosdata.docenteinf.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Uma análise de desempenho de um docente.
 * A análise identifica o instante
 * em que foi produzida, os dados empregados para
 * na avaliação dos indicadores, os resultados
 * produzidos pela avaliação dos indicadores
 * da resolução em questão.
 */
@Getter
@Setter
public class Analise {
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

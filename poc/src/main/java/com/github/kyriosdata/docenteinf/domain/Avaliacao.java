package com.github.kyriosdata.docenteinf.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Uma requisição de avaliação de desempenho de um docente.
 * Quando executada de forma satisfatória, produz uma
 * análise correspondente ({@link Analise}) cujo
 * identificaodr é forneicdo por {@link #getAnaliseId()}.
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
     * O instante em que a avaliação foi requisitada.
     */
    private LocalDateTime instante;

    /**
     * A identificação de quem fez a requisição.
     */
    private String requisitadaPor;

    /**
     * A resolução a ser empregada na avaliação requisitada.
     */
    private ResolucaoId resolucao;

    /**
     * O identificador da análise produzida quando
     * a avaliação é realizada de forma satisfatória.
     */
    private String analiseId;
}

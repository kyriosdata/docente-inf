package com.github.kyriosdata.docenteinf.domain;

import java.util.Collections;
import java.util.List;

/**
 * Representa o acesso a uma implementação de uma resolução.
 * A implementação deve possuir um identificador único e
 * oferecer como resultado da avaliação correspondente uma
 * {@link Analise}. A análise deve reunir os resultados
 * correspondentes aos indicadores produzidos pela
 * resolução ({@link #indicadores()}).
 */
public interface Resolucao {

        /**
        * @return Identificador da resolução.
        */
        ResolucaoId getId();

    /**
     * Avalia um docente conforme os indicadores fornecidos
     * @param entrada Os indicadores a serem empregados na avaliação.
     *
     * @return A análise correspondente.
     */
    Analise avalia(Contexto entrada);

    /**
     * Recupera os indicadores (nomes) produzidos pela resolução.
     * Observe que indicadores empregados para a avaliação da
     * resolução são identificados para cada indicador.
     *
     * @return Os identificadores dos indicadores produzidos pela
     * resolução.
     */
    default List<String> indicadores() {
        return Collections.emptyList();
    }
}

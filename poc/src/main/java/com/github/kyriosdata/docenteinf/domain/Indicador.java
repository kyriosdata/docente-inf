package com.github.kyriosdata.docenteinf.domain;

import java.util.Collections;
import java.util.List;

/**
 * Representa o acesso à implementação de um indicador.
 */
public interface Indicador {
    /**
     * Recupera o nome do indicador.
     * O nome de um indicador é único no
     * contexto de uma resolução.
     *
     * @return Nome do indicador.
     */
    String nome();

    /**
     * Avalia o indicador conforme indicadores de entrada.
     *
     * @param entrada Indicadores empregados na avaliação.
     *
     * @return O resultado da avaliação do indicador para os
     * valores de entrada fornecidos.
     */
    Resultado avalia(Contexto entrada);

    /**
     * Recupera os indicadores (nomes) de entrada necessários
     * para a avaliação do indicador.
     *
     * @return Os indicadores de entrada necessários
     * para a avaliação do indicador. A lista deve ser
     * vazia se o indicador não depende de outros indicadores.
     */
    default List<String> usa() {
        return Collections.emptyList();
    }
}

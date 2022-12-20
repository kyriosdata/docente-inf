package com.github.kyriosdata.docenteinf.resolucao;

import com.github.kyriosdata.docenteinf.domain.Contexto;
import com.github.kyriosdata.docenteinf.domain.Indicador;
import com.github.kyriosdata.docenteinf.domain.Resultado;

import java.util.Collections;
import java.util.List;

/**
 * Indicador que verifica se a idade mínima para ingresso
 * no magistério foi atingida.
 *
 * <p>Trata-se de um indicador trivial, apenas para ilustrar
 * como um indicador pode ser criado.</p>
 */
public class IdadeMinimaIndicador implements Indicador {

    /**
     * Recupera o nome do indicador.
     * O nome de um indicador é único no
     * contexto de uma resolução.
     *
     * @return Nome do indicador.
     */
    @Override
    public String nome() {
        return "idade mínima";
    }

    /**
     * Avalia o indicador conforme indicadores de entrada.
     *
     * @param entrada Indicadores empregados na avaliação.
     * @return O resultado da avaliação do indicador para os
     * valores de entrada fornecidos.
     */
    @Override
    public Resultado avalia(Contexto entrada) {
        double idade = entrada.get("idade").valorNumerico();
        return new Resultado(nome(), String.valueOf(idade >= 18.0));
    }

    /**
     * Recupera os indicadores (nomes) de entrada necessários
     * para a avaliação do indicador.
     *
     * @return Os indicadores de entrada necessários
     * para a avaliação do indicador. A lista deve ser
     * vazia se o indicador não depende de outros indicadores.
     */
    @Override
    public List<String> usa() {
        return Collections.singletonList("idade");
    }
}

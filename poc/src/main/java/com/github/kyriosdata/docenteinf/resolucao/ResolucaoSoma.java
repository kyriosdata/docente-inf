/*
 * Copyright (c) 2023.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.docenteinf.resolucao;

import com.github.kyriosdata.docenteinf.domain.*;

import java.util.List;
import java.util.Set;

public class ResolucaoSoma implements Resolucao {

    /**
     * O identificador único da resolução implementada.
     * Naturalmente, este identificador não muda.
     */
    private ResolucaoId id = new ResolucaoId("soma", "1.0");

    /**
     * O identificador da resolução implementada.
     *
     * @return O identificador da resolução.
     */
    @Override
    public ResolucaoId getId() {
        return id;
    }

    /**
     * Recupera os indicadores (nomes) produzidos pela resolução.
     * Observe que indicadores empregados para a avaliação da
     * resolução são identificados para cada indicador.
     *
     * @return Os identificadores dos indicadores produzidos pela
     * resolução.
     */
    @Override
    public Set<Indicador> indicadores() {
        Indicador soma = new Indicador() {

            @Override
            public String nome() {
                return "soma";
            }

            @Override
            public Resultado avalia(Contexto entrada) {
                double x = entrada.get("a").valorNumerico();
                double y = entrada.get("b").valorNumerico();

                return new Resultado("soma", String.valueOf(x + y));
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
                return List.of("a", "b");
            }
        };

        return Set.of(soma);
    }
}

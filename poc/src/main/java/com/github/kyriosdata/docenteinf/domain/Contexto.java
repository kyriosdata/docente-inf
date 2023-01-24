/*
 * Copyright (c) 2023.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.docenteinf.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa um conjunto valores
 * de indicadores. Desempenha tanto o papel
 * de valores de entrada quanto de valores
 * produzidos por uma avaliação.
 *
 * <p>A avaliação
 * de uma resolução e a avaliação de um indicador fazem
 * uso de um Contexto como entrada. E o resultado
 * também é depositado em um Contexto.</p>
 */
public class Contexto {
    private Map<String, Resultado> indicadores = new HashMap<>();

    public Resultado get(String nome) {
        return indicadores.getOrDefault(nome, null);
    }

    public void put(String nome, Resultado valor) {
        indicadores.put(nome, valor);
    }
}

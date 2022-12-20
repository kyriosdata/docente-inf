package com.github.kyriosdata.docenteinf.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa um conjunto valores
 * de indicadores. Estes valores podem
 * ser fornecidos como entrada para uma avaliação
 * de uma resolução, avaliação de um indicador ou
 * o resultado de uma avaliação ou o resultado de
 * um indicador.
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

/*
 * Copyright (c) 2023.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.docenteinf.domain;

import java.util.Objects;

/**
 * Representa um resultado correspondente a um indicador.
 */
public record Resultado(String nome, String valor) {
    public Resultado {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(valor);
    }

    public double valorNumerico() {
        return Double.parseDouble(valor);
    }

    public boolean valorLogico() {
        return Boolean.parseBoolean(valor);
    }
}


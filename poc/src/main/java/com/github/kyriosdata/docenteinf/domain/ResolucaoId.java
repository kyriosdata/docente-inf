/*
 * Copyright (c) 2023.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.docenteinf.domain;

import java.util.Objects;

/**
 * Identificador de uma resolução.
 */
public record ResolucaoId(String nome, String versao) {
    public ResolucaoId {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(versao);
    }
}

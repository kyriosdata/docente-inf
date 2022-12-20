package com.github.kyriosdata.docenteinf.domain;

import java.util.Objects;

/**
 * Identifica uma resolução.
 */
public record ResolucaoId(String nome, String versao) {
    public ResolucaoId {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(versao);
    }
}

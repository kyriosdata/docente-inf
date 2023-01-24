/*
 * Copyright (c) 2023.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.docenteinf.domain;

public interface ResolucaoRepository {
    void salva(Resolucao resolucao);
    Resolucao recupera(String codigo);
}

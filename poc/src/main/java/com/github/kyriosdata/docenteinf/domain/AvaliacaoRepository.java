/*
 * Copyright (c) 2023.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.docenteinf.domain;

public interface AvaliacaoRepository {
    void salva(Avaliacao avaliacao);
    Avaliacao recupera(String codigo);
}

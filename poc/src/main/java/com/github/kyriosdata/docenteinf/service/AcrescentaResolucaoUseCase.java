/*
 * Copyright (c) 2023.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.docenteinf.service;

import com.github.kyriosdata.docenteinf.domain.ResolucaoId;

public class AcrescentaResolucaoUseCase {

    /**
     * Adiciona uma resolução ao conjunto de resoluções
     * disponíveis para avaliação.
     *
     * @param id Identificador da resolução.
     *
     * @param arquivo A sequência de bytes correspondente a
     *                um arquivo .zip ou .jar. Este arquivo
     *                deve conter a implementação de uma
     *                resolução.
     */
    public void acrescentaResolucao(ResolucaoId id, byte[] arquivo) {
        // TODO
    }

    /**
     * Remove resolução do conjunto daquelas a serem consideradas
     * em processos de avaliação.
     *
     * @param id O identificador da resolução a ser ignorada.
     */
    public void removeResolucao(ResolucaoId id) {
        // TODO
    }
}

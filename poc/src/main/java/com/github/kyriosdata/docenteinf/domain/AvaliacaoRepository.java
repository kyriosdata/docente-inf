package com.github.kyriosdata.docenteinf.domain;

public interface AvaliacaoRepository {
    void salva(Avaliacao avaliacao);
    Avaliacao recupera(String codigo);
}

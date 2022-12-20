package com.github.kyriosdata.docenteinf.domain;

public interface ResolucaoRepository {
    void salva(Resolucao resolucao);
    Resolucao recupera(String codigo);
}

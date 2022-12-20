package com.github.kyriosdata.docenteinf.resolucaox;

import com.github.kyriosdata.docenteinf.domain.Analise;
import com.github.kyriosdata.docenteinf.domain.Contexto;
import com.github.kyriosdata.docenteinf.domain.Resolucao;
import com.github.kyriosdata.docenteinf.domain.ResolucaoId;

import java.util.List;

public class ResolucaoX implements Resolucao {

    /**
     * O identificador único da resolução implementada.
     * Naturalmente, este identificador não muda.
     */
    private ResolucaoId id = new ResolucaoId("X", "1.0");

    /**
     * O identificador da resolução implementada.
     *
     * @return O identificador da resolução.
     */
    @Override
    public ResolucaoId getId() {
        return id;
    }

    /**
     * Avalia um docente conforme os indicadores fornecidos
     *
     * @param entrada Os indicadores a serem empregados na avaliação.
     * @return A análise correspondente.
     */
    @Override
    public Analise avalia(Contexto entrada) {
        return null;
    }

    /**
     * Recupera os indicadores (nomes) produzidos pela resolução.
     * Observe que indicadores empregados para a avaliação da
     * resolução são identificados para cada indicador.
     *
     * @return Os identificadores dos indicadores produzidos pela
     * resolução.
     */
    @Override
    public List<String> indicadores() {
        return List.of("idade mínima", "totalPalestras");
    }
}

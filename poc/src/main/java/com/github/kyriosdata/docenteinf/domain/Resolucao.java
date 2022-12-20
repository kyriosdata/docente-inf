package com.github.kyriosdata.docenteinf.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Representa o acesso a uma implementação de uma resolução.
 * A implementação deve possuir um identificador único e
 * oferecer como resultado da avaliação correspondente uma
 * {@link Analise}. A análise deve reunir os resultados
 * correspondentes aos indicadores produzidos pela
 * resolução ({@link #indicadores()}).
 */
public interface Resolucao {

    /**
     * @return Identificador da resolução.
     */
    ResolucaoId getId();

    /**
     * Avalia um docente conforme os indicadores fornecidos
     *
     * @param entrada Os indicadores a serem empregados na avaliação.
     * @return A análise correspondente.
     */
    default Analise avalia(Contexto entrada) {
        OrdenacaoTopologica sort = new OrdenacaoTopologica();
        Map<String, Indicador> mapa = indicadores().stream()
                .collect(Collectors.toMap(Indicador::nome, i -> i));
        Set<String> nos = mapa.keySet();
        nos.forEach(v -> mapa.get(v).usa().forEach(d -> sort.criaAresta(d, v)));

        // Todos os nós relevantes para a análise
        // (indicadores e entrada)
        List<String> ordenacao = sort.topologicalSort();

        for (String v : ordenacao) {
            // Apenas indicadores devem ser avaliados
            if (entrada.get(v) == null) {
                Resultado r = mapa.get(v).avalia(entrada);
                entrada.put(r.nome(), r);
            }
        }

        // Dentre todos os resultados (entrada),
        // selecione os pertinentes à resolução.
        Contexto saida = new Contexto();
        indicadores().stream()
                .map(i -> entrada.get(i.nome()))
                .forEach(r -> saida.put(r.nome(), r));

        Analise analise = new Analise();
        analise.setResolucao(getId());
        analise.setEntrada(entrada);
        analise.setSaida(saida);

        return analise;
    }

    /**
     * Recupera os indicadores (nomes) produzidos pela resolução.
     * Observe que indicadores empregados para a avaliação da
     * resolução são identificados para cada indicador.
     *
     * @return Os identificadores dos indicadores produzidos pela
     * resolução.
     */
    default Set<Indicador> indicadores() {
        return Collections.emptySet();
    }
}

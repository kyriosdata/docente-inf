package com.github.kyriosdata.docenteinf.domain;

import java.util.*;

/**
 * Implementação de algoritmo de ordenação topológica.
 *
 * <p>Uma instância deve ser criada e acrescida de todas as
 * arestas v -> w que representam todas as dependências.
 * Neste caso, indica que w depende de v, ou que v precede w.</p>
 */
public class OrdenacaoTopologica {

    private Map<String, List<String>> arestas = new HashMap<>();

    public void criaAresta(String v, String w) {
        arestas.putIfAbsent(v, new ArrayList<>());
        arestas.putIfAbsent(w, new ArrayList<>());
        arestas.get(v).add(w);
    }

    private void topologicalSort(String vertice, Map<String, Boolean> visitados, Deque<String> pilha) {
        visitados.put(vertice, true);

        Iterator<String> its = arestas.get(vertice).iterator();
        while (its.hasNext()) {
            String next = its.next();
            if (!visitados.get(next))
                topologicalSort(next, visitados, pilha);
        }

        pilha.push(vertice);
    }

    /**
     * Ordena os vértices do grafo montado a partir das arestas
     * inseridas pelo método {@link #criaAresta(String, String)}.
     * A sequência de vértices é retornada conforme a ordenação
     * topológica dos vértices.
     *
     * @return Sequência de vértices ordenados topologicamente.
     */
    List<String> topologicalSort() {
        Deque<String> pilha = new ArrayDeque<>();

        // Inicialmente nenhum nó foi visitado
        Map<String, Boolean> visitados = new HashMap<>();
        arestas.keySet().stream().forEach(i -> visitados.put(i, false));

        arestas.keySet().stream().forEach(i -> {
            if (!visitados.get(i))
                topologicalSort(i, visitados, pilha);
        });

        List<String> sequenciaParaExecucao = new ArrayList<>();
        pilha.forEach(i -> sequenciaParaExecucao.add(i));

        return sequenciaParaExecucao;
    }
}

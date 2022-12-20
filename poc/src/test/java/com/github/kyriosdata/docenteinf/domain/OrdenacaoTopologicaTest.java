package com.github.kyriosdata.docenteinf.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdenacaoTopologicaTest {

    @Test
    public void classico() {
        OrdenacaoTopologica grafo = new OrdenacaoTopologica();
        grafo.criaAresta("5", "2");
        grafo.criaAresta("5", "0");
        grafo.criaAresta("4", "0");
        grafo.criaAresta("4", "1");
        grafo.criaAresta("2", "3");
        grafo.criaAresta("3", "1");

        List<String> ordenados = grafo.topologicalSort();

        assertTrue(antesDe(ordenados, "5", "2"));
        assertTrue(antesDe(ordenados, "5", "0"));
        assertTrue(antesDe(ordenados, "4", "0"));
        assertTrue(antesDe(ordenados, "4", "1"));
        assertTrue(antesDe(ordenados, "2", "3"));
        assertTrue(antesDe(ordenados, "3", "1"));
        assertTrue(antesDe(ordenados, "2", "1"));
        assertTrue(antesDe(ordenados, "5", "1"));
    }

    private boolean antesDe(List<String> ordenados, String v, String w) {
        int i = ordenados.indexOf(v);
        int j = ordenados.indexOf(w);
        return i < j;
    }
}


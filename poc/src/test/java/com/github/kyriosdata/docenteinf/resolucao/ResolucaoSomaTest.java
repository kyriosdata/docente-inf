package com.github.kyriosdata.docenteinf.resolucao;

import com.github.kyriosdata.docenteinf.domain.Analise;
import com.github.kyriosdata.docenteinf.domain.Contexto;
import com.github.kyriosdata.docenteinf.domain.Resolucao;
import com.github.kyriosdata.docenteinf.domain.Resultado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResolucaoSomaTest {

    @Test
    public void classico() {
        Resolucao soma = new ResolucaoSoma();
        Contexto entrada = new Contexto();
        entrada.put("a", new Resultado("a", "1"));
        entrada.put("b", new Resultado("b", "2"));

        Analise analise = soma.avalia(entrada);
        Contexto saida = analise.getSaida();
        assertEquals(3.0, saida.get("soma").valorNumerico());
    }
}

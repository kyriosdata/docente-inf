## Domínio

- Análise (resultado da aplicação de uma resolução para um dado contexto). Ou seja, uma análise é definida por um conjunto de resultados obtido de indicadores definidos por uma resolução.
- Contexto (dados necessários para a análise)
- Docente (o docente avaliado).
- Indicador. Possui um nome, "quantidade de horas de ensino" e "total de artigos A1", por exemplo, e uma expressão que produz o valor correspondente. Um indicador pode ser calculado em função dos resultados de outros indicadores.
- Resultado (de avaliação de indicador). Enquanto um indicador identifica uma métrica relevante para uma resolução, é a medida correspondente, ou resultado, que registra o valor correspondente.
- Resolução. Métodos: avalia(contexto): Análise. Resolução possui identificador único e versão. Uma resolução é definida por uma combinação de indicadores.
- AnaliseRepository. Mantém análises realizadas.
- ResolucaoRepository. Mantém resoluções disponíveis para serem empregadas pelo AD.

![modelo](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/kyriosdata/docente-inf/main/documentacao/diagramas/dominio-code.puml)

## Repositórios

- AnaliseRepository oferece acesso a uma análise pelo identificador correspondente (cache). Dependendo do contexto em que a solução será executada, a implementação deverá ser AnaliseRepositoryFileSystem, ou AnaliseRepositoryAzureBlob, AnaliseRepositoryAwsBucket, ...
-
- Loader. Método carrega(arquivo) : Resolução

## Diagrama de componentes

O contêiner API é organizado observando-se as diretrizes conhecidas por
_clean architecture_, arquitetura hexagonal ou ainda _onion architecture_. Em particular, motivada
por um negócio "relativamente sofisticado" que deve ser isolado e
permitir fácil evolução, conforme definido na visão do produto.

Desta forma, uma requisição é recebida via REST API, que repassa
a requisição para o serviço "Gera Análise" ou "Recupera Análise".

O componente Domínio reúne a implementação do negócio, ou seja,
as regras definidas por cada resolução. De fato, a expectativa é
de que uma resolução possa ser implementada e fornecida, inclusive
em tempo de execução, para uso pelo AD. Desta forma, dois componentes
se destacam, o Domínio propriamente que se limita a partes invariantes
e interfaces, cujas implementações são fornecidas por um ou mais
componentes Resolução.

![modelo](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/kyriosdata/docente-inf/main/documentacao/diagramas/c4-component.puml)

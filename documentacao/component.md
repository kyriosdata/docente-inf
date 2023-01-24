## Diagrama de componentes

A organização abaixo é oriendata por diretrizes conhecidas por
_clean architecture_, arquitetura hexagonal ou ainda _onion architecture_.

Esta decisão é motivada
por um negócio "relativamente sofisticado", a saber, os cômputos da avaliação pertinentes
a uma resolução e, em particular, a necessidade de evolução e coexistência de resoluções.

Desta forma, uma requisição é recebida (_REST API_), que repassa
a requisição para os casos de uso "Gera Análise", "Recupera Análise" ou 
"Acrescenta resolução" (_Casos de Uso_). Cabe a este componente requisitar as conversões 
necessárias, em ambos os sentidos, para converter DTO em objetos do 
domínio e vice-versa (_Conversores_).

O Caso de Uso "Acrescenta resolução" faz uso do 
[Loader](https://github.com/kyriosdata/dynamic-load) (_Loader_) para 
dinamicamente receber um arquivo .zip ou .jar contendo a implementação 
de uma nova resolução, uma versão ou correção de erro de resolução 
existente. Esta carga dinâmica permite que todo o sistema continue 
em funcionamento, sem precisar interrupção, mesmo quando uma
nova versão é disponibilizada.

O Domínio (_Domínio_) reúne parte da implementação de resoluções. 
Ou seja, partes invariantes, que independem de resoluções específicas.
Inclui interfaces cujas implementações são fornecidas por um ou mais
componentes Resolução (_Repositório de resoluções_). 

![modelo](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/kyriosdata/docente-inf/main/documentacao/diagramas/c4-component.puml)

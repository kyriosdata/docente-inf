# Contexto corrente (a ser substituído)

As funções necessárias para automatizar a avaliação de
desempenho de docentes estão implementadas em uma aplicação [cli.py](../cli.py).

Tal implementação desempenha dois
propósitos básicos: (a) mostrar que podemos automatizar a avaliação e
(b) ilustrar a funcionalidade esperada de um sistema de
informação desejado (a ser construído).

De fato, o desenvolvimento de um sistema de informação que realiza tal funcionalidade
 é o foco de atenção do presente projeto.

# Visão da avaliação de docente

A avaliação é baseada em resoluções (documentos formais).
Cada resolução é produzida ao longo do tempo e formada por
"indicadores" (métricas). Os valores dos indicadores são,
em geral, combinados formando outros indicadores.

O resultado da avaliação é um conjunto
de valores, cada um deles definido por um ou mais indicadores.

Conforme já mencionado, estas funções estão ilustradas pela aplicação em [cli.py](../cli.py).

# Necessidade

A aplicação citada, apesar da sua utilidade, deve ser
substituída por sistema de informação a ser incorporado
ao ecossistema da UFG. Neste novo sistema, Sistema de Avaliação Docente, ou simplesmente AD, a funcionalidade
será usufruída de forma automática por toda a UFG, sem
depender de ação técnica e manual, por um
processo de avaliação completamente automatizado.

Naturalmente, quando há mudança na resolução ou novas resoluções são
criadas, é esperada que a atualização do sistema que contemple
as mudanças possa ocorrer "rapidamente".

# Demanda

Proposta de _software design_ para o AD conforme a necessidade definida acima.

# Restrições

Temos uma rigorosa e embaraçosa restrição: não temos mais informações,
além daquelas citadas acima, nem teremos acesso à fonte de informações
antes de uma primeira apresentação da proposta. Relaxe. É esperada uma
havalanche de sugestões e ajustes, é a cultura desta instituição. Contudo,
a expectativa é de que a proposta seja "coerente".

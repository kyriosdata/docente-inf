# Contexto corrente

Temos uma aplicação [cli.py](cli.py) que automatiza a
avaliação de desempenho de docentes. Ela desempenha dois
propósitos básicos: (a) podemos automatizar a avaliação e
(b) ilustra a funcionalidade esperada de um sistema de 
informação desejado.

# Visão da avaliação de docente

A avaliação é baseada em resoluções (documentos formais).
Cada resolução é produzida ao longo do tempo e formada por
"indicadores" (métricas). Os valores dos indicadores são,
em geral, combinados em um "valor final". 

A análise do
contexto de um docente, portanto, resulta em um conjunto
de valores (resultados), cada um deles definido por um
ou mais indicadores.

Estas funções são ilustradas pela aplicação em [cli.py](cli.py).

# Necessidade

A aplicação citada, apesar da sua utilidade, deve ser 
substituída por sistema de informação a ser incorporado
ao ecossistema da UFG. Neste novo sistema a funcionalidade 
será usufruída de forma automática por toda a UFG, sem
depender de ação técnica e manual, no contexto de um
processo de avaliação completamente automatizado. 

Naturalmente, quando há mudança na resolução ou novas resoluções são
criadas, é esperada que a atualização do sistema para contemplar
as mudanças ocorra "rapidamente". 

# Demanda

Proposta de _software design_ que atenda à necessidade definida. 

# Restrições

Temos uma rigorosa e embaraçosa restrição: não temos mais informações,
além daquelas citadas acima, nem teremos acesso à fonte de informações 
antes de uma primeira apresentação da proposta. Relaxe. É esperada uma
havalanche de sugestões e ajustes, é a cultura do contexto. Contudo, 
a expectativa é de que a proposta seja "coerente". 

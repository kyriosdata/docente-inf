# Terceira versão (v3) (apta para desenvolvimento)

O _software design_ do AD tem seu registro inspirado no
Modelo C4 (consulte o [C4Model](https://c4model.com)
para detalhes). Artefatos produzidos:

- Diagrama de [Contexto](contexto.md) estabelecendo a relação do AD com o ambiente externo com o qual irá interagir.
- Identificação dos [Contêineres](container.md) que distribuem as responsabilidades atribuídas ao AD. Quando em operação, este conjunto de contêineres deve oferecer a funcionalidade esperada do AD.
- Dentre os contêineres se encontra aquele identificado por API, cujos [Componentes](component.md) identificam as partes necessárias para a implementação do contêiner com este nome.
- O componente mais "sofisticado" do AD é aquele identificado por Domínio cujas [classes](codigo.md) merecem atenção especial.

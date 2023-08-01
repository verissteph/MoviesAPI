# Projeto de Estudo - Aplicativo de Filmes com The Movie DB API

Este é um aplicativo Android criado como parte do meu processo de aprendizagem e estudo em desenvolvimento Android com Kotlin. O objetivo deste projeto é aprender e praticar as principais tecnologias e práticas usadas no desenvolvimento Android moderno.

O aplicativo utiliza a API The Movie DB para buscar e exibir uma lista de filmes.

## Tecnologias e Técnicas Utilizadas

Este projeto é um exemplo prático do uso de várias tecnologias e técnicas modernas de desenvolvimento Android, incluindo:

- **Kotlin**: A linguagem de programação oficial para o desenvolvimento Android.
- **Coroutines**: Uma biblioteca Kotlin para operações assíncronas.
- **Flow**: Uma API Kotlin para lidar com fluxos de dados assíncronos e reativos.
- **XML**: Utilizado para criar layouts de interface do usuário.
- **Retrofit**: Uma biblioteca popular para realizar solicitações HTTP em Android.

## Uso

Para utilizar este projeto, é necessário possuir uma chave da API The Movie DB. Essa chave pode ser obtida através do site The Movie DB após a criação de uma conta.

Após obter a chave da API, insira-a em seu arquivo `local.properties` da seguinte maneira:

```properties
api_key=YOUR_API_KEY
```

Substitua `YOUR_API_KEY` pela sua chave da API real.

## Estrutura do Projeto

Este projeto segue a arquitetura MVVM (Model-View-ViewModel) e utiliza o padrão de repositório para abstrair o acesso aos dados. As principais classes do projeto são:

- `Movie`: A classe de dados que representa um filme.
- `MovieResponse`: A classe de dados que representa uma resposta da API The Movie DB.
- `ApiService`: A interface Retrofit que define como realizar as solicitações da API.
- `MovieRepository`: A classe de repositório que utiliza a `ApiService` para obter dados.
- `MovieViewModel`: O ViewModel que fornece os dados para a UI e gerencia o estado da UI.
- `MainActivity`: A Activity principal do aplicativo que exibe a lista de filmes.

## Futuras Features e Melhorias

Algumas melhorias e recursos adicionais estão sendo considerados para futuras versões deste projeto:

- **Detalhes do Filme**: Uma nova tela para mostrar detalhes mais completos sobre cada filme, incluindo atores, avaliações e trailers.
- **Pesquisa de Filmes**: Uma funcionalidade de pesquisa para encontrar filmes específicos na lista.
- **Favoritos**: A capacidade de marcar filmes como favoritos e uma nova tela para visualizar todos os filmes favoritos.
- **Testes**: Testes unitários para garantir a qualidade do código e a usabilidade do aplicativo.

## Conclusão

Este projeto é um resultado direto do meu compromisso com o aprendizado e a prática contínua em desenvolvimento Android. Sinta-se à vontade para explorar o código e utilizá-lo como referência para seus próprios projetos. Seu feedback é sempre bem-vindo!

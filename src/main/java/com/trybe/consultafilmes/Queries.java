package com.trybe.consultafilmes;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Queries {

  private final Collection<Movie> movies;

  public Queries(Collection<Movie> movies) {
    this.movies = movies;
  }

  /**
   * Consulta 1: a partir da coleção de filmes desta classe, este método retorna o conjunto
   * de atores que interpretaram a si próprios em pelo menos um desses filmes.
   *
   * <p>Considera-se "atores que interpretaram a si próprios" aqueles que têm o seu nome como
   * uma das chaves do Map `atoresPorPersonagem` e também como um dos itens pertencentes ao
   * conjunto associado a esta mesma chave.</p>
   */
  public Set<String> actorsThatInterpretThemselves() {
    return this.movies.stream()
        .flatMap(movie -> movie.getActorsByCharacters().entrySet().stream())
        .filter(entry -> entry.getValue().contains(entry.getKey()))
        .map(Entry::getKey)
        .collect(Collectors.toSet());
    // Alternativa
//    return movies.stream()
//        .flatMap(filme ->
//            filme.actorsByCharacters.keySet().stream()
//                .filter(personagem ->
//                    filme.actorsByCharacters.get(personagem).contains(personagem)
//                )
//        )
//        .collect(toSet());
  }

  /**
   * Consulta 2: a partir da coleção de filmes desta classe, este método retorna a lista de atores
   * que atuaram em pelo menos um filme de um determinado diretor. A lista retornada está disposta
   * em ordem alfabética.
   *
   * <p>Considera-se que um ator tenha atuado em um filme de um determinado diretor se ele tem o
   * seu nome como um dos itens do campo `atores`, ao mesmo tempo em que o diretor em questão
   * tem o seu nome como um dos itens do campo `directors` do mesmo filme.</p>
   */
  public List<String> actorsThatActedInMoviesOfDirectorInAlphabeticOrder(String diretor) {
    return movies.stream()
        .filter(movie -> movie.getDirectors().contains(diretor))
        .flatMap(movie -> movie.getActors().stream())
        .distinct()
        .sorted()
        .collect(Collectors.toList());

    // Alternativa
//    return movies.stream()
//        .filter(movie -> movie.getDirectors().contains(diretor))
//        .flatMap(movie -> movie.getActors().stream())
//        .collect(Collectors.toSet())
//        .stream()
//        .sorted()
//        .collect(Collectors.toList());
  }

  /**
   * Consulta 3: a partir da coleção de filmes desta classe, este método retorna a lista de filmes
   * em que pelo menos um dos directors tenha atuado. A lista retornada está disposta em ordem de
   * lançamento, com os filmes mais recentes no início.
   *
   * <p>Considera-se "filmes em que pelo menos um dos directors tenha atuado" aqueles em que
   * pelo menos um dos itens do campo `directors` também é um item do campo `atores`.</p>
   */
  public List<Movie> moviesWithAtLeastOneDirectorActedMostRecentFirst() {
    return movies.stream()
        .flatMap(movie -> movie.directors.stream()
            .filter(director -> movie.getActors().contains(director))
            .map(director -> movie)
        )
        .distinct()
        .sorted(Comparator.comparing(Movie::getReleaseYear).reversed())
        .collect(Collectors.toList());


  }

  /**
   * Consulta 4: a partir da coleção de filmes desta classe, este método retorna um Map contendo
   * all os filmes lançados em um determinado ano agrupados por categoria.
   *
   * <p>Cada chave do Map representa uma categoria, enquanto cada valor representa o
   * conjunto de filmes que se encaixam na categoria da chave correspondente.</p>
   */
  public Map<String, Set<Movie>> moviesReleasedInYearGroupedByCategory(int ano) {
    List<Movie> filteredMovies = movies.stream()
        .filter(filme -> filme.getReleaseYear() == ano)
        .collect(Collectors.toList());

    List<SimpleImmutableEntry<String, Movie>> categoryMoviePairs = filteredMovies.stream()
        .flatMap(filme -> filme.getCategories().stream()
            .map(category -> new SimpleImmutableEntry<>(category, filme))
        )
        .collect(Collectors.toList());

    return categoryMoviePairs.stream()
        .collect(Collectors.groupingBy(
            SimpleImmutableEntry::getKey,
            Collectors.mapping(SimpleImmutableEntry::getValue, Collectors.toSet())
        ));


    // Alternativa (gabarito)
    //    return movies.stream()
    //        .filter(filme -> filme.releaseYear == ano)
    //        .flatMap(filme -> filme.categories.stream()
    //            .map(category -> new SimpleImmutableEntry<>(category, filme))
    //        )
    //        .collect(
    //            groupingBy(
    //                Entry::getKey,
    //                mapping(Entry::getValue, toSet())
    //            )
    //   );

  }
}

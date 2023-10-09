package com.trybe.consultafilmes;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Movie {

  public final String title;
  public final int releaseYear;
  public final Set<String> categories;
  public final Set<String> directors;
  public final Set<String> actors;
  public final Set<String> characters;
  public final Map<String, Set<String>> actorsByCharacters;

  /**
   * Constroi um objeto que representa um filme.
   *
   * @param title Título do filme.
   * @param releaseYear Ano de lançamento do filme.
   * @param categories Conjunto de categories a que pertence o filme (ação, comédia, drama, etc).
   * @param directors Conjunto de directors do filme.
   * @param actorsByCharacters Mapa que associa o nome de cada character do filme ao conjunto
   *                            de atores que o interpretaram.
   */
  public Movie(
      String title,
      int releaseYear,
      Collection<String> categories,
      Collection<String> directors,
      Map<String, Set<String>> actorsByCharacters
  ) {
    this.title = title;
    this.releaseYear = releaseYear;
    this.categories = Set.copyOf(categories);
    this.directors = Set.copyOf(directors);
    this.actorsByCharacters = Collections.unmodifiableMap(actorsByCharacters);

    this.characters = Collections.unmodifiableSet(actorsByCharacters.keySet());
    this.actors = actorsByCharacters.values().stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toUnmodifiableSet());
  }

  @Override
  public String toString() {
    return String.format("%s (%d)", title, releaseYear);
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public Set<String> getCategories() {
    return categories;
  }

  public Set<String> getDirectors() {
    return directors;
  }

  public Set<String> getActors() {
    return actors;
  }

  public Set<String> getCharacters() {
    return characters;
  }

  public Map<String, Set<String>> getActorsByCharacters() {
    return actorsByCharacters;
  }

  public String getTitle() {
    return title;
  }
}

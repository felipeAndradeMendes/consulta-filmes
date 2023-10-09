package com.trybe.consultafilmes;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovieConstructor {

  private final String title;
  private final int releaseYear;
  private final Set<String> categories = new HashSet<>();
  private final Set<String> directors = new HashSet<>();
  private final Map<String, Set<String>> actorsByCharacter = new HashMap<>();

  public MovieConstructor(String title, int releaseYear) {
    this.title = title;
    this.releaseYear = releaseYear;
  }

  public Movie construct() {
    return new Movie(title, releaseYear, categories, directors, actorsByCharacter);
  }

  public MovieConstructor categories(String... tags) {
    Collections.addAll(this.categories, tags);
    return this;
  }

  public MovieConstructor directors(String... directors) {
    Collections.addAll(this.directors, directors);
    return this;
  }

  public MovieConstructor character(String character, String... actor) {
    actorsByCharacter.put(character, Set.of(actor));
    return this;
  }
}

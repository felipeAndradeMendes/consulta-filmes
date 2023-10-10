package com.trybe.consultafilmes;

import java.util.List;
import java.util.Set;

public class Main {

  /**
   * Função utilizada apenas para validação da solução do desafio!.
   *
   * @param args Não utilizado.
   */
  public static void main(String[] args) {
    Queries queries = new Queries(Movies.all());
    Set<String> resultados = queries.actorsThatInterpretThemselves();
    System.out.println("Atores que interpretam a si mesmos: " + resultados);

    List<String> actors = queries
        .actorsThatActedInMoviesOfDirectorInAlphabeticOrder("Quentin Tarantino");
    System.out.println("Atores que atuaram no filme de um determinado diretor: " + actors);
  }
}

package com.trybe.consultafilmes;

import java.util.Set;

public class Main {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   */
  public static void main(String[] args) {
    Queries queries = new Queries(Movies.all());
    Set<String> resultados = queries.actorsThatInterpretThemselves();
    System.out.println(resultados);
  }
}

package com.trybe.consultafilmes;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Queries3Test {

  @Test
  @DisplayName("Consulta 3 - consulta com base em coleção vazia deve retornar uma lista vazia")
  public void consultaComBaseEmColecaoVazia() {
    testarConsulta(emptySet(), emptyList());
  }

  @Test
  @DisplayName(
      "Consulta 3 - consulta deve retornar uma lista vazia quando nenhum filme atende ao requisito"
  )
  public void nenhumFilmeAtendeAoRequisito() {
    testarConsulta(
        Set.of(Movies.spaceJam2021, Movies.homemAranhaSemVoltaParaCasa, Movies.djangoLivre),
        emptyList()
    );
  }

  @Test
  @DisplayName("Consulta 3 - consulta deve retornar resultados corretos na ordem correta")
  public void algunsFilmesAtendemAoRequisito() {
    testarConsulta(
        Movies.all(),
        List.of(Movies.coracaoValente, Movies.rockyII, Movies.oGrandeDitador)
    );
  }

  @Test
  @DisplayName("Consulta 3 - nenhum filme deve aparecer mais de uma vez na lista de resultados")
  public void itensDuplicados() {
    List<Movie> movies = List.of(Movies.coracaoValente, Movies.coracaoValente);
    Queries queries = new Queries(movies);
    List<Movie> resultados = queries.moviesWithAtLeastOneDirectorActedMostRecentFirst();

    long contagemCoracaoValente = resultados.stream()
        .filter(filme -> filme.equals(Movies.coracaoValente))
        .count();

    assertEquals(1, contagemCoracaoValente);
  }

  private static void testarConsulta(Collection<Movie> movies, List<Movie> saidasEsperadas) {
    Queries queries = new Queries(movies);
    List<Movie> saidasReais = queries.moviesWithAtLeastOneDirectorActedMostRecentFirst();
    assertEquals(saidasEsperadas, saidasReais);
  }
}

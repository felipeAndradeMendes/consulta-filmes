package com.trybe.consultafilmes;

import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Queries4Test {

  @Test
  @DisplayName("Consulta 4 - consulta com base em coleção vazia deve retornar um Map vazio")
  public void consultaComBaseEmColecaoVazia() {
    testarConsulta(emptySet(), 2021, emptyMap());
  }

  @Test
  @DisplayName(
      "Consulta 4 - consulta deve retornar um Map vazio quando nenhum filme atende ao requisito"
  )
  public void nenhumFilmeAtendeAoRequisito() {
    testarConsulta(
        Set.of(Movies.coracaoValente, Movies.bastardosInglorios, Movies.vingadoresUltimato),
        2021,
        emptyMap()
    );
  }

  @Test
  @DisplayName("Consulta 4 - consulta deve retornar resultados corretos")
  public void algunsFilmesAtendemAoRequisito() {
    testarConsulta(
        Movies.all(),
        2021,
        Map.of(
            "Ficção científica", Set.of(
                Movies.naoOlheParaCima,
                Movies.matrixResurrections,
                Movies.homemAranhaSemVoltaParaCasa,
                Movies.spaceJam2021),
            "Comédia", Set.of(
                Movies.naoOlheParaCima,
                Movies.spaceJam2021),
            "Ação", Set.of(
                Movies.matrixResurrections,
                Movies.homemAranhaSemVoltaParaCasa),
            "Drama", Set.of(
                Movies.naoOlheParaCima),
            "Animação", Set.of(
                Movies.spaceJam2021),
            "Aventura", Set.of(
                Movies.matrixResurrections,
                Movies.homemAranhaSemVoltaParaCasa),
            "Família", Set.of(
                Movies.spaceJam2021)
        )
    );
  }

  @Test
  @DisplayName(
      "Consulta 4 - filme que atende os requisitos e pertence a mais de uma categoria deve aparecer"
          + " em todas elas"
  )
  public void multiplasCategorias() {
    Set<Movie> movies = Set.of(Movies.homemAranhaSemVoltaParaCasa);
    Queries queries = new Queries(movies);
    Map<String, Set<Movie>> saidasReais = queries.moviesReleasedInYearGroupedByCategory(2021);

    Map<String, Set<Movie>> saidasEsperadas = Map.of(
        "Ação", Set.of(Movies.homemAranhaSemVoltaParaCasa),
        "Aventura", Set.of(Movies.homemAranhaSemVoltaParaCasa),
        "Ficção científica", Set.of(Movies.homemAranhaSemVoltaParaCasa)
    );

    assertEquals(saidasEsperadas, saidasReais);
  }

  private static void testarConsulta(
      Collection<Movie> movies,
      int anoDeLancamento,
      Map<String, Set<Movie>> saidasEsperadas) {

    Queries queries = new Queries(movies);

    Map<String, Set<Movie>> saidasReais =
        queries.moviesReleasedInYearGroupedByCategory(anoDeLancamento);

    assertEquals(saidasEsperadas, saidasReais);
  }
}

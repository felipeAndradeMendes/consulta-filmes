package com.trybe.consultafilmes;

import java.util.Set;

public class Movies {

  public static final Movie spaceJam2021 =
      new MovieConstructor("Space Jam", 2021)
          .categories("Família", "Animação", "Comédia", "Ficção científica")
          .directors("Malcolm D. Lee")
          .character("LeBron James", "LeBron James", "Stephen Kankole")
          .character("AI G", "Don Cheadle")
          .character("Dominic 'Dom' James", "Cedric Joe")
          .construct();

  public static final Movie queroSerJohnMalkovich =
      new MovieConstructor("Quero Ser John Malkovich", 1999)
          .categories("Comédia", "Drama", "Fantasia")
          .directors("Spike Jonze")
          .character("Craig Schwartz", "John Cusack")
          .character("John Malkovich", "John Malkovich")
          .character("Lotte Schwartz", "Cameron Diaz")
          .character("Maxine Lund", "Catherine Keener")
          .character("Floris", "Mary Kay Place")
          .construct();

  public static final Movie homemAranhaSemVoltaParaCasa =
      new MovieConstructor("Homem-Aranha: Sem Volta Para Casa", 2021)
          .categories("Ação", "Aventura", "Ficção científica")
          .directors("Jon Watts")
          .character("Peter Parker / Homem Aranha", "Tom Holland")
          .character("Michelle 'MJ' Jones", "Zendaya")
          .character("Stephen Strange / Doutor Estranho", "Benedict Cumberbatch")
          .character("Max Dillon / Electro", "Jamie Foxx")
          .character("Dr. Otto Octavius / Doutor Octopus", "Alfred Molina")
          .construct();

  public static final Movie matrixResurrections =
      new MovieConstructor("Matrix Resurrections", 2021)
          .categories("Ficção científica", "Ação", "Aventura")
          .directors("Lana Wachowski")
          .character("Thomas A. Anderson / Neo", "Keanu Reeves")
          .character("Tiffany / Trinity", "Carrie-Anne Moss")
          .character("Morpheus", "Yahya Abdul-Mateen II")
          .character("Smith", "Jonathan Groff")
          .character("The Analyst", "Neil Patrick Harris")
          .construct();

  public static final Movie naoOlheParaCima =
      new MovieConstructor("Não Olhe para Cima", 2021)
          .categories("Comédia", "Drama", "Ficção científica")
          .directors("Adam McKay")
          .character("Kate Dibiasky", "Jennifer Lawrence")
          .character("Dr. Randall Mindy", "Leonardo DiCaprio")
          .character("President Orlean", "Meryl Streep")
          .character("Dr. Teddy Oglethorpe", "Rob Morgan")
          .construct();

  public static final Movie vingadoresUltimato =
      new MovieConstructor("Vingadores: Ultimato", 2019)
          .categories("Aventura", "Ficção científica", "Ação")
          .directors("Joe Russo", "Anthony Russo")
          .character("Tony Stark / Homem de Ferro", "Robert Downey Jr.")
          .character("Steve Rogers / Capitão América", "Chris Evans")
          .character("Bruce Banner / Hulk", "Mark Ruffalo")
          .character("Thor Odinson", "Chris Hemsworth")
          .character("Natasha Romanoff / Viúva Negra", "Scarlett Johansson")
          .character("Clint Barton / Gavião Arqueiro", "Jeremy Renner")
          .character("Thanos", "Josh Brolin")
          .construct();

  public static final Movie pulpFiction =
      new MovieConstructor("Pulp Fiction: Tempo de Violência", 1994)
          .categories("Thriller", "Crime")
          .directors("Quentin Tarantino")
          .character("Vincent Vega", "John Travolta")
          .character("Jules Winnfield", "Samuel L. Jackson")
          .character("Mia Wallace", "Uma Thurman")
          .character("Butch Coolidge", "Bruce Willis")
          .character("Marsellus Wallace", "Ving Rhames")
          .character("Winston 'The Wolf' Wolfe", "Harvey Keitel")
          .construct();

  public static final Movie djangoLivre =
      new MovieConstructor("Django Livre", 2012)
          .categories("Drama", "Faroeste")
          .directors("Quentin Tarantino")
          .character("Django Freeman", "Jamie Foxx")
          .character("Dr. King Schultz", "Christoph Waltz")
          .character("Calvin J. Candie", "Leonardo DiCaprio")
          .character("Broomhilda von Shaft", "Kerry Washington")
          .character("Stephen", "Samuel L. Jackson")
          .construct();

  public static final Movie bastardosInglorios =
      new MovieConstructor("Bastardos Inglórios", 2009)
          .categories("Drama", "Ação", "Thriller", "Guerra")
          .directors("Quentin Tarantino")
          .character("First Lieutenant Aldo 'The Apache' Raine", "Brad Pitt")
          .character("Shosanna Dreyfus / Emmanuelle Mimieux", "Mélanie Laurent")
          .character("SS Colonel Hans 'The Jew Hunter' Landa", "Christoph Waltz")
          .character("Staff Sergeant Donny 'The Bear Jew' Donowitz", "Eli Roth")
          .character("Lieutenant Archie Hicox", "Michael Fassbender")
          .character("Bridget von Hammersmark", "Diane Kruger")
          .construct();

  public static final Movie coracaoValente =
      new MovieConstructor("Coração Valente", 1995)
          .categories("Ação", "Drama", "História", "Guerra")
          .directors("Mel Gibson")
          .character("William Wallace", "Mel Gibson")
          .character("Murron MacClannough", "Catherine McCormack")
          .character("Princess Isabelle", "Sophie Marceau")
          .character("King Edward", "Patrick McGoohan")
          .character("Robert the Bruce", "Angus Macfadyen")
          .construct();

  public static final Movie rockyII =
      new MovieConstructor("Rocky II: A Revanche", 1979)
          .categories("Drama")
          .directors("Sylvester Stallone")
          .character("Robert 'Rocky' Balboa", "Sylvester Stallone")
          .character("Adrianna 'Adrian' Balboa", "Talia Shire")
          .character("Paulie Pennino", "Burt Young")
          .character("Apollo Creed", "Carl Weathers")
          .character("Mickey Goldmill", "Burgess Meredith")
          .character("Tony 'Duke' Evers", "Tony Burton")
          .construct();

  public static final Movie oGrandeDitador =
      new MovieConstructor("O Grande Ditador", 1940)
          .categories("Comédia", "Guerra")
          .directors("Charlie Chaplin")
          .character("Adenoid Hynkel", "Charlie Chaplin")
          .character("Benzino Napaloni", "Jack Oakie")
          .character("Commander Schultz", "Reginald Gardiner")
          .character("Garbitsch", "Henry Daniell")
          .character("Field Marshal Herring", "Billy Gilbert")
          .construct();

  /**
   * Fornece um conjunto de filmes. Os dados estão incompletos, mas já são suficientes para testar
   * as consultas do desafio.
   *
   * @return Conjunto de filmes.
   */
  public static Set<Movie> all() {
    return Set.of(
        spaceJam2021,
        queroSerJohnMalkovich,
        homemAranhaSemVoltaParaCasa,
        matrixResurrections,
        naoOlheParaCima,
        vingadoresUltimato,
        pulpFiction,
        djangoLivre,
        bastardosInglorios,
        coracaoValente,
        rockyII,
        oGrandeDitador);
  }
}

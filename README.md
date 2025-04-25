# Film-API med Spring Boot – Testning

## Syfte
Syftet med projektet är att visa förståelse för olika testnivåer i ett Spring Boot API som hanterar filmer. Testerna bevisar att systemet fungerar korrekt på flera lager – från service till hela API:t.

## Teststrategi

Jag har använt tre nivåer av tester:

| Testtyp          | Syfte                                         | Teknik                   |
|------------------|-----------------------------------------------|--------------------------|
| Enhetstest       | Testar tjänstelogik isolerat från databas     | JUnit, Mockito           |
| Komponenttest    | Testar service + repo tillsammans             | Spring Context           |
| Integrationstest | Testar hela flödet (API → Service → DB)       | TestRestTemplate, JPA    |

---

##  Vilka metoder testas och varför

| Klass              | Metod                   | Anledning                                                        |
|--------------------|-------------------------|------------------------------------------------------------------|
| `MoviesService`    | `getAllMovies()`        | Kontrollera att hämtning fungerar med mockad datakälla           |
| `MoviesService`    | `createMovies()`        | Säkerställa att duplicering förhindras                          |
| `MoviesService`    | `getMoviesById()`       | Verifierar att rätt film kan hämtas efter att den sparats        |
| `MoviesController` | `POST /movies` & `GET`  | Testar hela HTTP-kedjan mot databasen                           |

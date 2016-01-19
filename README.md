# Tic-Tac-Toe

## Opdracht
* Maak het spelletje Tic-Tac-Toe o.b.v. de onderstaande product backlog.
* Gebruik de aangeleverde broncode als vertrekpunt van het project.
* Niet alle functionaliteiten hoeven te worden gerealiseerd.
* Zorg dat je blij bent met de gerealiseerde functionaliteiten.
* Stuur de door jou gebouwde oplossing uiterlijk één werkdag voor het gesprek terug.
  * Wij zullen de applicatie bekijken zodat we hem samen kunnen bespreken.
  * Primair belang is dat je gemaakte keuzes in het gesprek kan motiveren.
* ***Veel succes met de opdracht, maak er iets moois van!***

## Product backlog
*. *Als* speler *wil ik* Tic-Tac-Toe tegen de computer kunnen spelen *zodat* ik mezelf kan vermaken.
  * ***Acceptatie criteria***
    * De speler en de computer spelen ieder beurt om beurt.
    * De speler die als eerste drie op een rij heeft wint.
    * Drie op een rij kan zowel horizontaal, verticaal als diagonaal worden behaald.
    * Wanneer het spel is gewonnen kan een nieuw spel worden gestart.
    * De behaalde score wordt geregistreerd.
*. *Als* speler *wil ik* dat mijn top-scores worden onthouden *zodat* ik kan bekijken hoe goed ik heb gespeeld.
  * ***Acceptatie criteria***
    * De score wordt berekend op basis van het minst aantal zetten i.c.m. speeltijd.
    * Alleen de 10 best behaalde scores worden onthouden.
    * De scores mogen in-memory worden gehouden, persistentie in een datastore is niet nodig.
*. *Als* speler *wil ik* mijn naam kunnen instellen *zodat* anderen kunnen zien wie welke score heeft behaald.
  * ***Acceptatie criteria***
    * De gebruiker kan zijn naam ingeven bij de start van het spel.
*. *Als* speler *wil ik* mijn actuele score ten opzichte van andere spelers zien *zodat* ik weet hoe goed ik het huidige potje speel.
  * ***Acceptatie criteria***
    * De score van het huidige potje is altijd in beeld.
    * De huidige score wordt in verhouding tot de top-scores getoond.

## Aangeleverde broncode
* In het **Trifork - Tic-Tac-Toe** zip-bestand vind je een basis applicatie.
* De toegepaste technologieën in deze applicatie zijn:
  * [Spring-Boot](http://projects.spring.io/spring-boot/)
  * [Thymeleaf](http://www.thymeleaf.org/)
  * [Material Design Light](http://www.getmdl.io/)
  * [Maven](https://maven.apache.org/)
  * [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html)
* De basis applicatie bevat de volgende begin elementen:
  * Een index pagina i.c.m. een gemapte controller.
  * Een CSS bestand met daarin de styling van het spel.
  * Een Javascript bestand dat de game initialiseert.
  * Een properties bestand die gebruikt kan worden voor teksten.
  * Een REST controller die de POST van "/rest/executeTurn" afhandeld i.c.m. de parameters:
    * **turn**: boolean
    * **column**: int
    * **row**: int
* Je mag nieuwe technologieën inzetten om het project te realiseren:
  * Bijvoorbeeld inzet van AngularJS voor de presenatie componenten.
* De applicatie kan eenvoudig gestart worden met het volgende commando:
  *   ```$ mvn spring-boot:run```

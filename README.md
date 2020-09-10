# M223: Punchclock (SpringBoot REST-API)
Dieses Projekt ist der Backend Bestandteil der Punchclock-Applikation. 
Sie stellt die nötigen Daten und REST-Methoden zur Verfügung für die Frontend-Applikation.

##Funktionen
* Erstellen, Ändern und Löschen von Zeiteinträgen (inklusive Datumsvalidierung)
* Erstellen, Ändern und Löschen von Benutzern
* Erstellen und Ändern von Kategorien (ohne REST-API Endpunkt)
* Erstellen und Ändern von Departementen (ohne REST-API Endpunkt)
* Authentifizierung und Authorisierung der Benutzer mittels JWT
* Initialisierung eines Startdatensets ab import.sql (für Testzwecke)

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
2. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
3. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
4. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation (mit Initialdaten gemäss import.sql): http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console
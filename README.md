# Exam - Java

## Sommaire

- [Présentation](#présentation)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Créateur](#créateur)
- [Copyright et licence](#copyright-et-licence)

## Présentation

Ce projet est une application de motivation pour employés utilisant Spring Boot. Il se compose de deux services distincts :

- Une **API** (Backend) qui fournit des citations inspirantes stockées en base de données.
- Une **Application Web** avec une interface où les utilisateurs peuvent écrire leurs préoccupations. Chaque message reçoit une réponse inspirante provenant de l'API, et toutes les conversations sont enregistrées en base de données.

## Prérequis

Avant de pouvoir exécuter ce projet Spring Boot, assurez-vous d'avoir les prérequis suivants installés sur votre machine :

- Avoir installé JDK 21 (java 21).
- Avoir Installé et configuré MySQL 8+.

## Installation

Pour récuperer le projet, vous pouvez utiliser la ligne de commande git suivante :

```git
$ git clone https://github.com/Christmann-Julian/exam-java
```
Ou vous pouvez télécharger le fichier .zip du projet en vous rendant sur le [github](https://github.com/Christmann-Julian/exam-java) du projet.

Vous devez ensuite installer les dépendances du projet en vous rendant d'abord dans le dossier ***exam-java-api*** puis dans le dossier ***exam-java-app***.

Puis vous devez créer les bases de données ***exam-java*** et ***exam-java-app*** dans votre sgbd MySQL.

Enfin vous devez modifier les informations de connexion à la base de données dans les fichiers ./exam-java-app/src/main/resources/application.properties et dans ./exam-java-api/src/main/resources/application.properties

```properties
spring.application.name=exam-java-app

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/exam-java-app
spring.datasource.username=votre nom 
spring.datasource.password=votre mot de passe
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

server.port=8081
```

```properties
spring.application.name=exam-java-api

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/exam-java
spring.datasource.username=votre nom
spring.datasource.password=votre mot de passe
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Maintenant vous êtes prêt à lancer les serveurs dans ./exam-java-app et dans ./exam-java-api.

Vous pouvez accéder à l'app depuis l'url :

```http
http://localhost:8081/
```

et à l'api depuis l'url :

```http
http://localhost:8080/api/quote
```

## Créateur

**Christmann-Julian**

- <https://github.com/Christmann-Julian>

## Copyright et licence

Code et documentation copyright 2025. Le Code du projet est publié sous [Licence MIT ](https://fr.wikipedia.org/wiki/Licence_MIT).
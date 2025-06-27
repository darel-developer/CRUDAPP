# 📦 Gestion de Stock - Application Spring Boot

## ✨ Fonctionnalités Clés

Cette application est dotée de fonctionnalités pensées pour optimiser votre gestion de stock au quotidien :

### 🚀 Fonctionnalités Métier

- *Gestion Complète des Produits* : Créez, lisez, mettez à jour et supprimez vos produits en toute simplicité.

- *Gestion des Catégories* : Organisez vos produits en catégories claires et facilement gérables.

- *Tableau de Bord Intuitif* : Accédez rapidement aux statistiques clés de votre stock pour une vue d'ensemble instantanée.

- *Interface Admin Conviviale* : Une interface claire et facile à utiliser pour une administration sans effort.

- *Design Entièrement Responsive* : Accédez à votre application sur n'importe quel appareil, du mobile à l'ordinateur de bureau.


### ⚙ Fonctionnalités Techniques

- *Spring Boot 3.5.3* : Le framework Java de référence pour des applications rapides et robustes.

- *Base de Données MySQL* : Stockage fiable et performant de toutes vos données.

- *Thymeleaf & Bootstrap 5* : Une interface utilisateur moderne et dynamique, basée sur des standards web.

- *Validation des Formulaires* : Assure l'intégrité des données saisies grâce à une validation robuste.

- *Prêt pour l'Intégration de Graphiques* : Architecture préparée pour l'ajout futur de visualisations de données.


## 🛠 Technologies Utilisées

Ce projet s'appuie sur un stack technologique moderne et éprouvé :

### Backend

- *Java 17* : Le langage de programmation principal.

- *Spring Boot 3.5.3* : Framework pour le développement d'applications Spring.

- *Spring Data JPA* : Facilite l'accès et la manipulation des données.

- *Hibernate 6.4.4* : Implémentation ORM pour la persistance des données.

- *MySQL 8.0* : Système de gestion de base de données relationnelle.


### Frontend

- *Thymeleaf* : Moteur de templates pour les pages web.

- *Bootstrap 5.3* : Framework CSS pour un design responsive et moderne.

- *Bootstrap Icons* : Bibliothèque d'icônes pour une meilleure expérience utilisateur.

- *Chart.js* : (Pour future intégration) Bibliothèque JavaScript pour les graphiques interactifs.


### Outils

- *Maven* : Outil de gestion de projet et de build.

- *Lombok* : Bibliothèque Java pour réduire le code répétitif (boilerplate code).


## 🚀 Configuration Requise

Pour démarrer l'application, assurez-vous d'avoir les éléments suivants installés :

- Java JDK 17+

- MySQL 8.0+

- Maven 3.8+


## 📦 Installation et Lancement

Suivez ces étapes simples pour mettre en place et exécuter l'application :

1. *Cloner le dépôt Git* :


    git clone https://github.com/votre-utilisateur/tp_exam.git
    cd tp_exam


2. *Configurer la base de données MySQL* :

    - Créez une nouvelle base de données MySQL nommée tp_exam_db.

    - Mettez à jour les identifiants de connexion (nom d'utilisateur et mot de passe) dans le fichier src/main/resources/application.properties pour qu'ils correspondent à votre configuration MySQL locale.

3. *Lancer l'application Spring Boot* :


    mvn spring-boot:run


4. Accéder à l'application :

   Ouvrez votre navigateur web et naviguez vers l'adresse : http://localhost:8080


## ⚙ Configuration du Projet

Le fichier src/main/resources/application.properties contient les configurations essentielles de l'application. Vous pouvez le modifier selon vos besoins :


# Database
spring.datasource.url=jdbc:mysql://localhost:3306/tp_exam_db
spring.datasource.username=root
spring.datasource.password=

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update # 'update' pour mettre à jour le schéma, 'create' pour recréer à chaque lancement.
spring.jpa.show-sql=true # Affiche les requêtes SQL dans la console.

# Thymeleaf
spring.thymeleaf.cache=false # Désactive le cache Thymeleaf en développement pour voir les changements instantanément.


## 🌐 API Endpoints Disponibles

Voici une liste des principaux points d'accès (endpoints) de l'API de l'application :

|   |   |   |
|---|---|---|
|*Méthode|Endpoint|Description*|
|GET|/|Accéder au tableau de bord.|
|GET|/produits|Afficher la liste de tous les produits.|
|GET|/produits/new|Afficher le formulaire pour créer un nouveau produit.|
|POST|/produits|Soumettre le formulaire pour créer un produit.|
|GET|/produits/edit/{id}|Afficher le formulaire pour éditer un produit spécifique.|
|POST|/produits/update|Soumettre le formulaire pour mettre à jour un produit.|
|GET|/produits/delete/{id}|Supprimer un produit spécifique.|
|GET|/categories|Afficher la liste de toutes les catégories.|
|GET|/categories/new|Afficher le formulaire pour créer une nouvelle catégorie.|
|POST|/categories|Soumettre le formulaire pour créer une catégorie.|
|GET|/categories/edit/{id}|Afficher le formulaire pour éditer une catégorie spécifique.|
|POST|/categories/update|Soumettre le formulaire pour mettre à jour une catégorie.|
|GET|/categories/delete/{id}|Supprimer une catégorie spécifique.|

## 👨‍💻 Développement

Pour les développeurs souhaitant contribuer ou explorer le code :

### Compiler le projet


mvn clean install


### Lancer les tests unitaires


mvn test


### Packager l'application en un fichier JAR exécutable


mvn package

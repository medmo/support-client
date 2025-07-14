# Support Client Application

## Description
Une application Spring Boot qui fournit un service de support client intelligent utilisant Spring AI avec OpenAI. L'application expose une API REST pour interagir avec un assistant IA.

## Spécifications Techniques
- Java SDK 24
- Spring Boot 3.5.4-SNAPSHOT
- Spring AI 1.0.0
- Spring Web
- Spring DevTools

## Prérequis
- Java SDK 24
- Maven
- Une clé API OpenAI
- IntelliJ IDEA 2025.1.2 (ou version ultérieure)

## Configuration
### Variables d'Environnement Requises
### Properties
## API Endpoints
### Assistant
- **GET** `/assistant`
    - **Description** : Envoie une question à l'assistant IA
    - **Paramètre** : `question` (query parameter)
    - **Retourne** : La réponse générée par l'IA

## Installation et Démarrage
1. Clonez le repository
2. Configurez la variable d'environnement `OPENAI_API_KEY`
3. Exécutez l'application :
   ```bash
   ./mvnw spring-boot:run
   ```

## Développement
### Build
### Tests
### Hot Reload
L'application utilise Spring DevTools pour le rechargement automatique pendant le développement.

## Dépendances Principales
- `spring-boot-starter-web` : Support web et REST
- `spring-ai-starter-model-openai` : Intégration OpenAI via Spring AI
- `spring-boot-devtools` : Outils de développement (hot reload, etc.)

## Repositories
L'application utilise les repositories Spring Snapshots pour les dépendances :
- URL : https://repo.spring.io/snapshot

## Groupe et Artifact
- GroupId : `dev.guava`
- ArtifactId : `support-client`
- Version : `0.0.1-SNAPSHOT`

## Sécurité
⚠️ Ne partagez jamais votre clé API OpenAI. Assurez-vous qu'elle est stockée de manière sécurisée dans vos variables d'environnement.

# Jeu de Stratégie au Tour par Tour

## Description

Ce projet implémente un jeu de stratégie au tour par tour en utilisant Java. Le jeu oppose entre 2 et n joueurs sur une grille en 2 dimensions de taille paramétrable. Chaque joueur dispose de points de vie, de points d'action, ainsi que d'équipements comme des armes avec des munitions limitées. Le but est de rester le dernier joueur en vie sur la grille.

L'implémentation utilise différents design patterns tels que Proxy, Stratégie, Adapter, et Factory, pour assurer une architecture claire et modulaire. Le projet est organisé selon l'architecture MVC (Modèle, Vue, Contrôleur) pour séparer les logiques de présentation, de contrôle et de données.

## Fonctionnalités

- **Architecture MVC** : Une séparation claire entre la logique, la présentation et les interactions du jeu.
- **Pattern Proxy** : Chaque joueur n'a qu'une vision partielle de la grille, ne voyant que les éléments qu'il a posés lui-même.
- **Pattern Stratégie** : Différentes stratégies pour l'initialisation de la grille et les déplacements des combattants.
- **Pattern Adapter** : Gestion de l'affichage des combattants dans une interface graphique.
- **Pattern Factory** : Création des objets combattants de manière abstraite.
- **Interface graphique et console** : Le jeu peut être joué via une interface graphique ou en ligne de commande.

## Prérequis

- Java JDK 8 ou version supérieure
- Apache Ant (facultatif, pour la compilation via Ant)

## Installation et Exécution

### Utilisation d'Apache Ant

1. Assurez-vous qu'Apache Ant est installé et configuré sur votre machine.
2. Clonez ce dépôt sur votre machine locale :
   ```sh
   git clone <URL-du-dépôt>
   ```
3. Naviguez vers le répertoire du projet :
   ```sh
   cd chemin/vers/le/projet
   ```
4. Exécutez la commande suivante pour compiler le projet :
   ```sh
   ant compile
   ```
5. Pour exécuter l'application, utilisez la commande :
   ```sh
   ant run
   ```

### Utilisation du Fichier JAR

1. Compilez le projet en utilisant votre IDE ou la ligne de commande.
2. Naviguez vers le dossier contenant le fichier JAR généré.
3. Lancez l'application en utilisant la commande suivante :
   ```sh
   java -jar dist/TurnBasedGame-0.1.jar
   ```

## Structure du Projet

Le projet est organisé selon l'architecture MVC et comporte plusieurs packages pour la gestion des différentes fonctionnalités. Voici la structure principale :

```
├── build
│   ├── content
│   │   └── images
│   ├── controller
│   ├── main
│   ├── model
│   │   ├── observer
│   │   └── strategies
│   └── view
├── dist
│   └── docs
│       └── api
│           ├── controller
│           ├── main
│           ├── model
│           │   ├── observer
│           │   └── strategies
│           ├── resources
│           ├── script-dir
│           └── view
└── src
    ├── content
    │   └── images
    ├── controller
    ├── main
    ├── model
    │   ├── observer
    │   └── strategies
    └── view
```

## Collaborateurs

- Fatoumata M’balou Diallo
- Mamoudou Camara
- Arafat Feical Idriss
- Ismael Sow

## Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.


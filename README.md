# Snake Game - Java/Javafx

## Introduction

This repository contains a Java and JavaFX implementation of the classic Snake game, developed for the "Software Development Methods" exam at the University of Trieste.

The goal of the project was to create a game while applying key principles from the course, such as Continuous Integration (CI), automated testing, and Test-Driven Development (TDD) to promote iterative code improvement.

The project is built using Gradle.
## Gameplay
-------------------------------------------------- da aggiungere l'immagine
### Objective
The goal of the game is to control the snake, eat food to grow, and avoid collisions with the screen edges or the snake’s own body. The longer the snake grows, the higher your score.

### How to Play

Controls:

Move the Snake: Use the arrow keys to change the direction of the snake.

-W Arrow: Move the snake up.

-S Arrow: Move the snake down.

-A Arrow: Move the snake left.

-D Arrow: Move the snake right.

-Eat Food: The snake grows in lenght each time it consumes food, and your score increases.

-Avoid Collisions: If the snake collides with the edges of the screen or with its own body it's GAME OVER.

## Project Structure

We organized the structure in the following directories:

- `logic`: Contains the core game logic.
- `main`: Is responsible for initializing the game.
- `model`: Defines the game models such as Board, Fruit, and Snake, representing the game's core elements.
- `view`: This package is responsible for the game's visual representation.

## Requirements

- Java 22
  
- JavaFX SDK properly set up in your environment.

Building the project with gradle should manage all the dependencies.

## Javadoc Documentation
This project uses Javadoc to document classes and methods. You can generate the documentation using gradle.

## License

- This project is licensed under the MIT License. See the _license_ file for more details.

## Authors
- Emanuele Giacomazzi
- Francesco Poloni
- Giacomo Guidolin
- Nicolò Davide










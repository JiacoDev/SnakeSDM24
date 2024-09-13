# Snake Game - Java/Javafx

## Introduction

This repository contains an implementation of the classic Snake game built using Java and JavaFX. 

The goal is to control the snake, eat food to grow, and avoid collisions with the screen edges or the snake’s own body.

The objective of this project was to create a game while practicing what we've learned during the Software Development Methods lectures such as: Continuous Integration (CI), applying automated testing and Test Driven Development (TDD) which are some of the principles for iterative code improvement.

## Gameplay
-------------------------------------------------- da aggiungere

### Project Structure

- `resources` : Includes any external resources, such as images.
  
- `snake` : Manages anything from, game controls and menu, to the fruit spawns and collision.
  
- `test` : The word speaks for it's self, contains the tests we performed during development.

## Requirements

- Java 11+ (or any compatible version)
  
- JavaFX SDK properly set up in your environment.

## Setting Up JavaFX
If you're using an IDE like IntelliJ IDEA or Eclipse, add the JavaFX SDK as a project dependency. Follow the IDE's documentation to configure the JavaFX libraries properly.

## Installation and Execution

If your IDE is properly configured with JavaFX, you can run the project directly from the IDE, alternatively:

1. Clone the repository: git clone ---------------------

2. Set Up JavaFX SDK: Ensure the JavaFX SDK is properly configured in your environment.

3. Compile the Code Compile the source files, specifying the JavaFX SDK path: javac --module-path -------------------

4.Run the Game Execute the compiled application with the JavaFX module path: java --module-path ----------------------------

## Objective
The goal of the game is to control the snake, eat food to grow, and avoid collisions with the screen edges or the snake’s own body. The longer the snake grows, the higher your score.

## How to Play

Controls:

Move the Snake: Use the arrow keys to change the direction of the snake.

-W Arrow: Move the snake up.

-S Arrow: Move the snake down.

-A Arrow: Move the snake left.

-D Arrow: Move the snake right.

-Eat Food: The snake grows in lenght each time it consumes food, and your score increases.

-Avoid Collisions: If the snake collides with the edges of the screen or with its own body it's GAME OVER.

## License

- This project is licensed under the MIT License. See the _license_ file for more details.

## Authors
---------------










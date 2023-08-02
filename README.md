# Cowtopia - A Text-based Vegan Adventure Game

Welcome to Cowtopia, a text-based adventure game where you embark on a journey to explore the world of veganism and make impactful choices to save the planet and its animals. In this game, you will play as a VeganHero/ine and navigate through various challenges and scenarios to spread awareness and promote a cruelty-free lifestyle.

## Getting Started

To play Cowtopia, you need Java installed on your machine. Simply follow the instructions below to get started:

1. Clone the repository to your local machine using `git clone https://github.com/yourusername/Cowtopia.git`.
2. Navigate to the project directory: `cd Cowtopia`.
3. Compile the Java files: `javac *.java`.
4. Run the game: `java Main`.

## How to Play

1. Upon starting the game, you will be greeted with an introductory text and asked to enter your name.
2. The game will present you with a series of scenarios, and you must make choices by entering the corresponding letter (a, b, or c) to proceed.
3. Each choice you make will impact your Compassion and Charisma points, affecting the outcome of the game.
4. The goal is to make choices that promote veganism and positively impact the environment and animals.
5. As you progress through each day, you'll see the impact of your choices on various statistics and the growth of veganism worldwide.

## Game Structure

- `Main.java`: The main entry point of the game, responsible for displaying the game's introduction and handling player inputs.
- `Player.java`: Defines the `Player` class with attributes like name, compassion, charisma, and methods to calculate impact and vegan growth.
- `Utils.java`: Contains utility functions for text animations, file reading, and processing challenges.
- `DayChallenges.java`: Handles the challenges for each day of the game.

## Adding More Days and Challenges

To extend the game and add more days and challenges, follow these steps:

1. Create a new, or modify the existent, `challenges.json` file with the challenges for the day.
2. Define the challenges in the JSON file using the structure defined in `challenges.json`.
3. Update the `Main.java` file to read and process challenges from the new JSON file. 
- Set the number of days to be parsed available in the `challenges.json`. That would be the length of the game:
```java
            // Set the number of days for the game
            int gameLength = 2; // Change this to the total number of days in the game

```
## Credits

This game was developed as part of the course ["Java Grundkurs"](https://www.cimdata.de/weiterbildung/java-grundkurs/) of Cimdata with the mentoring of Lars Petersen.
Inspired by text-based adventure games. The ASCII art for the mentor "Nandi" is sourced from the package [`cowsay`](https://en.wikipedia.org/wiki/Cowsay).
This game was developed with ChatGPT.

## Contributions

Contributions to Cowtopia are welcome! If you have ideas for improvements, bug fixes, or new features, feel free to open an issue or submit a pull request.

## License

Cowtopia is released under the MIT License. See the [LICENSE](LICENSE) file for details.

Enjoy your journey in Cowtopia and have fun saving the world one choice at a time!

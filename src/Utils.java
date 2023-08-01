import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {
	
	public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void animateText(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delay);
        }
    }
    
    public static void waitForEnter() {
        try {
            while (System.in.available() == 0) {
                Thread.sleep(50);
            }
            while (System.in.available() > 0) {
                System.in.read();
            }
            System.out.println(); // Move to the next line after skipping animation
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void delayPrint(String message, int delayInMilliseconds) {
        try {
            for (char c : message.toCharArray()) {
                System.out.print(c);
                Thread.sleep(delayInMilliseconds);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   public static int getValidIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer:");
            scanner.next();
        }
        return scanner.nextInt();
    }
public static void printFile(String messageIn, String pathIn) {
	//Ziel: aus einer bestehenden Datei Inhalte zeilweise auslesen
	
	try {
		
		// 1. Zugriff auf Datei per File-Klasse
		File datei = new File(pathIn);
		// 2. per Scanner den Inhalt einlesen
		Scanner inhalt = new Scanner(datei);
		// 3. per Schleife alle zeilen auslesen solange Inhalt verfuegbar ist
		
		System.out.println("\n"+messageIn);
		
		while(inhalt.hasNextLine()) {
			
			String line = inhalt.nextLine();
			System.out.println(line);
	
		}
		// 4. Datei-Zugriff beenden
		inhalt.close();
		
	}
	catch (IOException ioe)
	{
		System.out.println("Fehler: " + ioe);
	}
	
}

// Method to display the vegan graph
public static void displayVeganGraph(int day, long newVegans, double veganPercentage, long worldPopulation) {
    System.out.println("\n--- Vegan Growth Graph ---\n");
    System.out.println("Day " + day + " Total: " + newVegans + " new vegans");

    // Calculate the number of bars for the vegan percentage graph
    int bars = (int) Math.round(veganPercentage / 2.0); // Scale the vegan percentage to fit within 50 bars

    // Draw the bar graph
    System.out.print("[");
    for (int i = 0; i < 50; i++) {
        if (i < bars) {
            System.out.print("|"); // Fill bars with "|"
        } else {
            System.out.print(" "); // Empty spaces for the remaining bars
        }
    }
    System.out.println("]");

    System.out.println(String.format("%.2f", veganPercentage)+ " of the 9B world Population\nhas now become aware!");
}

public static String veganImpactstr(Player player, int vgnbdays) {
    // Calculate the impact based on the number of vegan days
    int water = (int) Math.round(vgnbdays * 4.164);
    int grain = vgnbdays * 18;
    int forested = vgnbdays * 3;
    int co2 = vgnbdays * 9;
    int animals = (int) Math.round(vgnbdays * 0.22);
    int animals2 = animals + 1;

    // Set the impact attributes in the player object
    player.setWaterSavedLiters(water);
    player.setGrainSavedKg(grain);
    player.setForestedLandSavedSqM(forested);
    player.setCO2SavedKg(co2);
    player.setAnimalLivesSaved(animals);

    // Prepare and return the impact summary string
    String s = "Fellow VeganHero/ine, so far you have saved: \n" +
            "    💧 " + water + " Liters of water,\n" +
            "    🌽 " + grain + " Kg of grain,\n" +
            "    🌲 " + forested + " Sq.m of forested land,\n" +
            "    ☁️ " + co2 + " kg CO2 and,\n" +
            "    🐄 " + animals + " Animal lives!!\n     > " +
            animals2 + " Animals thank you! :)\n" +
            "\n\n source: 5vegan.org";

    return s;
}




public static HashMap<Integer, String> readScenesFromFile(String filePath) {
    HashMap<Integer, String> scenes = new HashMap<>();
    StringBuilder sceneText = new StringBuilder();
    int sceneIndex = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains("=")) {
                scenes.put(sceneIndex, sceneText.toString());
                sceneText = new StringBuilder();
                sceneIndex++;
            } else {
                sceneText.append(line).append("\n");
            }
        }

        // Store the last scene
        scenes.put(sceneIndex, sceneText.toString());

    } catch (IOException e) {
        e.printStackTrace();
    }

    return scenes;
}

public static String replaceAndTrim(String input, String newString) {
    int emptySpacesToRemove = newString.length();
    String trimmedString = input.replace("*", newString+'!').trim();
    return trimmedString.replace((" ".repeat(emptySpacesToRemove - 1)+"\\.") ,"\\");
}


public static JsonObject readChallengesFromJsonFile(String filename) {
    Gson gson = new Gson();
    JsonObject jsonObject = null;
    try (FileReader reader = new FileReader(filename)) {
        // Use Gson to parse the JSON file into a JsonObject
        jsonObject = gson.fromJson(reader, JsonObject.class);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return jsonObject;
}

static void processChallenge(JsonObject challenge, Player player, Scanner scanner) {
    Utils.printFile("", "cowSay.txt");
    Utils.animateText(challenge.get("question").getAsString() + "\n\n", 30);

    JsonObject options = challenge.getAsJsonObject("options");
    JsonObject feedback = challenge.getAsJsonObject("feedback");

    Utils.animateText("a) " + options.get("a").getAsString(), 30);
    Utils.animateText("\nb) " + options.get("b").getAsString(), 30);
    Utils.animateText("\nc) " + options.get("c").getAsString(), 30);

    System.out.print("\nEnter the letter corresponding to your choice: \n\n");
    String choice = scanner.nextLine().trim().toLowerCase();

    // Handle the player's choice for the current challenge
    System.out.print("\n\n\n\n");
    
    int initialCompassion = player.getCompassion();
    int initialCharisma = player.getCharisma();
    
    if (choice.equals("a")) {
        Utils.sleep(500); // Short pause
        System.out.println(feedback.get("a").getAsString());
        player.increaseCompassion();
        player.increaseCharisma();
        player.increaseOptimism();
    } else if (choice.equals("b")) {
        Utils.sleep(500); // Short pause
        System.out.println(feedback.get("b").getAsString());
        player.decreaseCompassion();
    } else if (choice.equals("c")) {
        Utils.sleep(500); // Short pause
        System.out.println(feedback.get("c").getAsString());
        player.decreaseCompassion();
        player.decreaseCharisma();
    } else {
        Utils.sleep(800);
        System.out.println("\nInvalid choice. Please try again.");
        Utils.sleep(1000);
        processChallenge(challenge, player, scanner); // Retry the current challenge if the player made an invalid choice
        return;
    }
    int finalCompassion = player.getCompassion();
    int finalCharisma = player.getCharisma();

    System.out.println("\n...Press enter to continue.");
    Utils.waitForEnter(); // Wait for the user to press Enter before moving to the next question

    // Generate and display the player's statistics summary
    displayPlayerStatsSummary(initialCompassion, finalCompassion, initialCharisma, finalCharisma);
}


private static void displayPlayerStatsSummary(int initialCompassion, int finalCompassion, int initialCharisma, int finalCharisma) {
    int compassionChange = finalCompassion - initialCompassion;
    int charismaChange = finalCharisma - initialCharisma;

    System.out.println("\nYour choice had this inpact on your PlayerScore:");
    System.out.println("Compassion Points: " + finalCompassion + " (" + (compassionChange > 0 ? "+" : "") + compassionChange + ")");
    System.out.println("Charisma Points: " + finalCharisma + " (" + (charismaChange > 0 ? "+" : "") + charismaChange + ")");
}
}





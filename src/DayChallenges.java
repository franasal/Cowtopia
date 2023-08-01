import java.util.Scanner;
import com.google.gson.JsonObject;

public class DayChallenges {
    public static void start(int dayNumber, int totalDays, Player player, Scanner scanner) {
        String filename = "challenges.json";
        JsonObject jsonChallenges = Utils.readChallengesFromJsonFile(filename);
        String dayKey = "Day " + dayNumber;
        JsonObject jsonDayChallenges = jsonChallenges.getAsJsonObject(dayKey);

        if (jsonDayChallenges != null) {
            for (int i = 1; i <= 3; i++) { // Assuming you have 3 challenges for each day
                String challengeKey = "Challenge " + i;
                if (jsonDayChallenges.has(challengeKey)) {
                    JsonObject challenge = jsonDayChallenges.getAsJsonObject(challengeKey);
                    Utils.processChallenge(challenge, player, scanner);
                }
            }
        }

        // End of the day Animation
        System.out.println("\n--- End of Day " + dayNumber + " ---");
        System.out.println("Your impact as a VeganHero/ine:");
        int veganDays = dayNumber;
        System.out.println(Utils.veganImpactstr(player, veganDays));

        // Calculate and display the number of new vegans and update the world population
 
        Utils.displayVeganGraph(veganDays, player.getNewVegansPerDay(),
                player.calculateVeganPercentage(dayNumber), Player.WORLD_POPULATION);

        Utils.sleep(1000); // Short pause before moving to the next day
    }
}
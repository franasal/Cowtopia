import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
		
		// Greeting text and ask for the name of the Player
		
		Utils.printFile("", "intro.txt");
        Scanner scanner = new Scanner(System.in);
        
        
        
        String startOption = scanner.nextLine().trim().toLowerCase();

        if (startOption.equals("q")) {
            System.out.println("Thank you for considering to play Cowtopia! See you next time!");
        } else {
            System.out.println("Enter your name: ");
            String playerName = scanner.nextLine().trim();
            Player player = new Player(playerName);
            
            // Intro
            HashMap<Integer, String> scenes = Utils.readScenesFromFile("altCow.txt");
        	 // prints introduction and ascii art of the Nandi, the Mentor
            System.out.println(Utils.replaceAndTrim(scenes.get(0), player.name));

        	Utils.animateText("...Press enter to continue.\n 1\\4", 20);
            Utils.waitForEnter(); // Wait for the user to press Enter before moving to the next question
            
            System.out.println(scenes.get(1));
            Utils.animateText("...Press enter to continue.\n 2\\4", 20);
            Utils.waitForEnter(); // Wait for the user to press Enter before moving to the next question
            
            System.out.println(scenes.get(2));
            Utils.animateText("...Press enter to continue.\n 3\\4", 20);
            Utils.waitForEnter(); // Wait for the user to press Enter before moving to the next question
            
            System.out.println(scenes.get(3));
            Utils.animateText("...Press enter to continue.\n 4\\4", 20);
            Utils.waitForEnter(); // Wait for the user to press Enter before moving to the next question
      
            
            // Set the number of days for the game
            int gameLength = 2; // Change this to the total number of days in the game
            
            player.setGameLengthInDays(gameLength);
            
            // Loop through each day and start the challenges
            for (int day = 1; day <= gameLength; day++) {
                DayChallenges.start(day,gameLength, player, scanner);
            }

            // Add other days here...

            // Game Conclusion
            conclusion(player);
            scanner.close();
        }
    }
	


    private static void conclusion(Player player) {
		// TODO Auto-generated method stub
		
	}


}

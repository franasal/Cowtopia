public class Player {
    String name;
    private int compassion;
    private int charisma;
    private int optimism;

    // New attributes for impact calculations
    private int waterSavedLiters;
    private int grainSavedKg;
    private int forestedLandSavedSqM;
    private int CO2SavedKg;
    private int animalLivesSaved;

    public static final long WORLD_POPULATION = 9000000000L; // Assuming a fixed world population
    private long newVegansPerDay;
    private int totalVegans; // Keep track of the total number of vegans

    private int gameLengthInDays; 
  
    
    public Player(String name) {
        this.name = name;
        this.compassion = 33;
        this.charisma = 33;
        this.optimism = 33;
        
        this.totalVegans = (int) Math.round(0.01 * WORLD_POPULATION); // Initialize the total vegans to 0 at the start of the game

        // Initialize the impact attributes to 0
        this.waterSavedLiters = 0;
        this.grainSavedKg = 0;
        this.forestedLandSavedSqM = 0;
        this.CO2SavedKg = 0;
        this.animalLivesSaved = 0;
    }

    // Getters and Setters for traits
    // ...
    // Getters and Setters for traits
    public int getCompassion() {
        return compassion;
    }

    public void increaseCompassion() {
        if (compassion < 100) {
            compassion += 10;
        }
    }

    public void decreaseCompassion() {
        if (compassion > 0) {
            compassion -= 10;
        }
    }

    public int getCharisma() {
        return charisma;
    }

    public void increaseCharisma() {
        if (charisma < 100) {
            charisma += 10;
        }
    }

    public void decreaseCharisma() {
        if (charisma > 0) {
            charisma -= 10;
        }
    }

    public int getOptimism() {
        return optimism;
    }

    public void increaseOptimism() {
        if (optimism < 100) {
            optimism += 10;
        }
    }

    public void decreaseOptimism() {
        if (optimism > 0) {
            optimism -= 10;
        }
    }
    // Getters and Setters for impact attributes
    public int getWaterSavedLiters() {
        return waterSavedLiters;
    }

    public void setWaterSavedLiters(int waterSavedLiters) {
        this.waterSavedLiters = waterSavedLiters;
    }

    public int getGrainSavedKg() {
        return grainSavedKg;
    }

    public void setGrainSavedKg(int grainSavedKg) {
        this.grainSavedKg = grainSavedKg;
    }

    public int getForestedLandSavedSqM() {
        return forestedLandSavedSqM;
    }

    public void setForestedLandSavedSqM(int forestedLandSavedSqM) {
        this.forestedLandSavedSqM = forestedLandSavedSqM;
    }

    public int getCO2SavedKg() {
        return CO2SavedKg;
    }

    public void setCO2SavedKg(int CO2SavedKg) {
        this.CO2SavedKg = CO2SavedKg;
    }

    public int getAnimalLivesSaved() {
        return animalLivesSaved;
    }

    public void setAnimalLivesSaved(int animalLivesSaved) {
        this.animalLivesSaved = animalLivesSaved;
    }
    
    public long getNewVegansPerDay() {
        return newVegansPerDay;
    }

    // Method to calculate the projected population exponentially for a given day
    public long calculateProjectedPopulation(int currentDay, int totalDays) {
        double N1 = 0; // Initial population on day 1
        double ND = WORLD_POPULATION; // Population on day D (9 billion)

        // Calculate the estimated population on day d using linear interpolation formula
        double N = N1 + ((ND - N1) * (currentDay - 1) / (totalDays - 1));
        
        int baseNewVegans = (int) (optimism + charisma + compassion) ; // This value can be adjusted based on your game balance
        newVegansPerDay = (long) N* (1 + baseNewVegans/ 100);
        return newVegansPerDay;
    }
    
    // Method to calculate the percentage of the world population that has turned vegan
    public double calculateVeganPercentage(int totalDays) {
        return (double) newVegansPerDay / (WORLD_POPULATION * totalDays) * 100;
    }
    
    // Setter method for gameLengthInDays
    public void setGameLengthInDays(int gameLengthInDays) {
        this.gameLengthInDays = gameLengthInDays;
    }
    
    // Getter method for totalVegans
    public int getTotalVegans() {
        return totalVegans;
    }
    
}

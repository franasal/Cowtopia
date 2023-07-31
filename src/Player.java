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
    private int newVegansPerDay;
    private int totalVegans; // Keep track of the total number of vegans

  
    
    public Player(String name) {
        this.name = name;
        this.compassion = 50;
        this.charisma = 50;
        this.optimism = 50;
        
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
    
    public int getNewVegansPerDay() {
        return newVegansPerDay;
    }

    // Method to calculate the number of new vegans each day
    public int calculateNewVegans() {
        // Calculate the number of new vegans based on player's traits and choices
        // For simplicity, let's assume a linear relationship with the player's optimism and charisma
        int baseNewVegans = (int) (optimism + charisma) / 10; // This value can be adjusted based on your game balance
        int exponentialFactor = 2; // Increase this value to make the growth more exponential
        return (int) Math.pow(baseNewVegans, exponentialFactor);
    }

    // Method to update the world population based on the number of new vegans each day
    public void updateWorldPopulation() {
        int newVegans = calculateNewVegans();
        newVegansPerDay = newVegans;
        totalVegans += newVegans; // Accumulate the new vegans each day
    }

    // Method to calculate the percentage of the world population that has turned vegan
    public double calculateVeganPercentage() {
        return (double) totalVegans / WORLD_POPULATION * 100;
    }
    // Getter method for totalVegans
    public int getTotalVegans() {
        return totalVegans;
    }
    
}

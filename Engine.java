public class Engine implements EngineRequirements {

    // Attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Constructor
     * @param f the type of fuel used by the engine
     * @param currentFuelLevel the current level of fuel left in the engine
     * @param maxFuelLevel the engine's maximum level of fuel 
     */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel) {
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    /**
     * Accessor for fuel type
     * @return the engine's fuel type
     */
    public FuelType getFuelType() {
        return this.f;
    }

    /**
     * Accessor for the cars's maximum fuel level
     * @return the cars's maximum fuel level
     */
    public double getMaxFuel() {
        return this.maxFuelLevel;
    }

    /**
     * Accessor for the car's current fuel level
     * @return the car's current fuel level
     */
    public double getCurrentFuel() {
        return this.currentFuelLevel;
    }
    
    /**
     * set current fuel level to maximum fuel level
     */
    public void refuel() {
        this.currentFuelLevel = maxFuelLevel;
    } 

    /**
     * operation status of the car
     * @return T/F
     */
    public Boolean go() {
        this.currentFuelLevel -= 10;
        System.out.println("remaining fuel level: " + this.currentFuelLevel);
        if (this.currentFuelLevel > 0) {
            return true;
        } return false;
    }

    public String toString() {
        return ("Engine has fuel type " + this.f + " current fuel level: " + this.currentFuelLevel + " and max fuel level: " + this.maxFuelLevel);
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0.00, 100);
        myEngine.refuel();
        System.out.println(myEngine.getCurrentFuel());
        myEngine.go();
    }
}
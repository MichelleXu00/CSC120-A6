public class Passenger implements PassengerRequirements{
    
    //Attributes
    private String name;

    /**
     * Constructor
     * @param name the passenger's name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * add the passenger to a car
     * @param c the car that the passenger is getting onto
     */
    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
        } catch (RuntimeException e) {
            throw new RuntimeException (e);
        }
    }

    /**
     * remove the passenger from a car
     * @param c the car that the passenger is getting off from
     */
    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
        } catch (RuntimeException e) {
            throw new RuntimeException (e);
        }
    }
    
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        Passenger Michelle = new Passenger("Michelle");
        Passenger Cathy = new Passenger("Cathy");
        Car myCar = new Car(100);
        Michelle.boardCar(myCar);
        Cathy.getOffCar(myCar);
    }
}



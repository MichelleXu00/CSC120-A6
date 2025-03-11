public class Passenger implements PassengerRequirements{
    
    //Attributes
    private String name;

    //Constructor
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * add the passenger to a car
     */
    public void boardCar(Car c) {
        c.addPassenger(this);
    }

    /**
     * remove the passenger from a car
     */
    public void getOffCar(Car c) {
        c.removePassenger(this);
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



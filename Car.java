import java.util.ArrayList;

public class Car implements CarRequirements{

    //Attributes
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    /**
     * Constructor
     * @param capacity the maximum capacity of the car
     */
    public Car(int capacity) {
        this.maxCapacity = capacity;
        passengersOnboard = new ArrayList<>();
    }

    /**
     * Accessor
     * @return the car's maximum capacity
     */
    public int getCapacity() {
        return this.maxCapacity;
    }

    /**
     * calculate the seats available
     * @return the number of seats left in the car
     */
    public int seatsRemaining() {
        return this.maxCapacity - passengersOnboard.size();
    }

     /**
     * Onboard a passenger
     * @param p the passenger boarding the car
     * @return T/F Is the passenger board to the car if there is seat available? 
     */
    public Boolean addPassenger(Passenger p) {
        if (seatsRemaining() > 0) {
            passengersOnboard.add(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * remove a passenger
     * @param p 
     * @return T/F Does the passenger get off from the car if the person was on board? 
     */
    public Boolean removePassenger(Passenger p) {
        if (passengersOnboard.contains(p)) {
            passengersOnboard.remove(p);
            return true;
        } return false;
    }

    /**
     * print out all the passengers on the car
     */
    public void printManifest() {
        if (passengersOnboard.size() > 0) {
            System.out.println(passengersOnboard);
        } else {
            System.out.println("THis car is EMPTY");
        }
    }


    public static void main(String[] args) {
        Car myCar = new Car(100);
        System.out.println(myCar.getCapacity());
        Passenger Michelle = new Passenger("Michelle");
        Passenger Cathy = new Passenger("Cathy");
        myCar.addPassenger(Michelle);
        myCar.addPassenger(Cathy);
        myCar.printManifest();
        System.out.println(myCar.seatsRemaining());
    }
}

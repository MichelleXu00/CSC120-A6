import java.util.ArrayList;

public class Train implements TrainRequirements{

    //Attributes
    Engine myEngine;
    ArrayList<Car> cars;
    int trainCapacity;
    int trainSeatsR;

    /**
     * Constructor
     * @param fuelType the type of fuel that the train's engine uses
     * @param fuelCapacity the capacity of fuel tank of the train's engine
     * @param nCars the number of cars composing the train
     * @param passengerCapacity the train's total capacity of passengers
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        myEngine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        cars = new ArrayList<Car>();
        for (int i = 0; i < nCars; i++) {
            cars.add(new Car(passengerCapacity));
        }
    }

    /**
     * allow public access to engine information from train
     * @return engine
     */
    public Engine getEngine() {
        return myEngine;
    }

    /**
     * allow access to each car from the arraylist of cars
     * @param i the nth of car in the train
     * @return car
     */
    public Car getCar(int i) {
        return cars.get(i);
    }

    /**
     * aggregate the total maximum capacity for the train
     * @return number of people that can board the train
     */
    public int getMaxCapacity() {
        trainCapacity = 0;
        for (int i = 0; i < cars.size(); i++) {
            trainCapacity += this.getCar(i).getCapacity();
        } return trainCapacity;
    }

    /**
     * aggregate the total number of seats remaining across cars
     * @return number of seats available on the train
     */
    public int seatsRemaining() {
        trainSeatsR = 0;
        for (int i = 0; i < cars.size(); i++) {
            trainSeatsR += this.getCar(i).seatsRemaining();
        } return trainSeatsR;
    }

    /**
     * print out all the passengers on the train
     */
    public void printManifest() {
        for (int i = 0; i < cars.size(); i++) {
            this.getCar(i).printManifest();
        }
    }

    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 100, 4, 250);
        System.out.println(myTrain.getMaxCapacity());
        System.out.println(myTrain.seatsRemaining());
        myTrain.printManifest();
    }
}

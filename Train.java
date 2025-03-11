import java.util.ArrayList;

public class Train implements TrainRequirements{

    //Attributes
    Engine myEngine;
    ArrayList<Car> cars;
    int TrainCapacity;
    int TrainseatsR;

    //Constructor
    public Train(FuelType fueltype, double fuelcapacity, int nCars, int passengercapacity) {
        myEngine = new Engine(fueltype, fuelcapacity, fuelcapacity);
        cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++) {
            cars.add(new Car(passengercapacity));
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
        for (int i = 0; i < cars.size(); i++) {
            TrainCapacity += this.getCar(i).getCapacity();
        }
        return TrainCapacity;
    }

    /**
     * aggregate the total number of seats remaining across cars
     * @return number of seats available on the train
     */
    public int seatsRemaining() {
        for (int i = 0; i < cars.size(); i++) {
            TrainseatsR += this.getCar(i).seatsRemaining();
        }
        return TrainseatsR;
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

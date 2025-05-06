import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    Engine myEngine = new Engine(FuelType.ELECTRIC, 0.00, 100);
    @Test
    public void testEngineConstructor() {
        assertSame(100, myEngine.getMaxFuel());
    }

    @Test
    public void testEngineGo() {
        assertSame(90, myEngine.getCurrentFuel());
    }

    // Car Tests
    Car myCar = new Car(3);
    Passenger michelle = new Passenger("Michelle");
    Passenger cathy = new Passenger("Cathy");
    Passenger rachel = new Passenger("Rachel");
    Passenger alice = new Passenger("Alice");
    @Test
    public void testCarAddPassenger() {
        myCar.addPassenger(michelle);
        myCar.addPassenger(cathy);
        assertEquals(98, myCar.seatsRemaining());
    }

    @Test
    public void testCarRemovePassenger() {
        myCar.removePassenger(cathy);
        assertEquals(99,myCar.seatsRemaining());
        assertTrue(myCar.seatsRemaining() > 0);
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        michelle.boardCar(myCar);
        assertTrue(myCar.seatsRemaining() < myCar.getCapacity());
    }

    @Test (expected = Exception.class)
    public void testPassengerBoardCarFull() {
        michelle.boardCar(myCar);
        cathy.boardCar(myCar);
        rachel.boardCar(myCar);
        alice.boardCar(myCar);
    }

    // Train Tests
    Train myTrain = new Train(FuelType.ELECTRIC, 100, 4, 250);
    @Test
    public void testTrainConstructor() {
        assertEquals(4, myTrain.cars.size());
    }

    @Test
    public void testTrainPassengerCount() {
        assertEquals(999,myTrain.seatsRemaining());
    }

    @Test
    public void testTrainGetCar() {
        assertSame(myCar, myTrain.getCar(1));
    }

    @Test
    public void testTrainPrintManifest() {
        myTrain.printManifest(); //check manually
    }
}

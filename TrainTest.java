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
        assertEquals(90, myEngine.go());
    }

    // Car Tests
    Car myCar = new Car(100);
    Passenger michelle = new Passenger("Michelle");
    Passenger cathy = new Passenger("Cathy");
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
        assertTrue(myCar.seatsRemaining() < 0);
    }

    @Test
    public void testPassengerBoardCarFull() {
        assertTrue(myCar.seatsRemaining() <= 0);
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
        assertSame(michelle, myTrain.getCar(0));
    }
    
}

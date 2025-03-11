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
    Passenger Michelle = new Passenger("Michelle");
    Passenger Cathy = new Passenger("Cathy");
    @Test
    public void testCarAddPassenger() {
        myCar.addPassenger(Michelle);
        myCar.addPassenger(Cathy);
        assertEquals(98, myCar.seatsRemaining());
    }

    @Test
    public void testCarRemovePassenger() {
        myCar.removePassenger(Cathy);
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
        assertEquals("Michelle", myTrain.printManifest());
    }
    
}

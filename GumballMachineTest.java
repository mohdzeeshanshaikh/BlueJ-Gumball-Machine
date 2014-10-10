import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  Zeeshan
 * @version 1.0
 */
public class GumballMachineTest
{
    private GumballMachine MyGumballMachine;
    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        MyGumballMachine = new GumballMachine(5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testWithMoreThanFiftyCents()
    {
        System.out.println("\n***Test 1: testWithMoreThanFiftyCents***");
        MyGumballMachine.insertQuarter();
        MyGumballMachine.insertDime();
        MyGumballMachine.insertNickel();
        MyGumballMachine.insertQuarter();
        MyGumballMachine.turnCrank();
        assertEquals(true, MyGumballMachine.isGumballInSlot());
        MyGumballMachine.takeGumballFromSlot();
        assertEquals(false, MyGumballMachine.isGumballInSlot());
    }

    @Test
    public void testWithNoCoins()
    {
        System.out.println("\n***Test 2: testWithNoCoins***");
        MyGumballMachine.turnCrank();
        assertEquals(false, MyGumballMachine.isGumballInSlot());
    }

    @Test
    public void testForPickingTwoGumballsFromSlot()
    {
        System.out.println("\n***Test 3: testForPickingTwoGumballsFromSlot***");
        MyGumballMachine.insertQuarter();
        MyGumballMachine.insertQuarter();
        MyGumballMachine.turnCrank();
        MyGumballMachine.insertQuarter();
        MyGumballMachine.insertQuarter();
        MyGumballMachine.turnCrank();
        assertEquals(true, MyGumballMachine.isGumballInSlot());
        MyGumballMachine.takeGumballFromSlot();
        assertEquals(false, MyGumballMachine.isGumballInSlot());
    }

    @Test
    public void testToCheckBalanceAfterTurningCrankWithInsufficientAmount()
    {
        System.out.println("\n***Test 4: testToCheckBalanceAfterTurningCrankWithInsufficientAmount***");
        MyGumballMachine.insertDime();
        MyGumballMachine.turnCrank();
        assertEquals(10, MyGumballMachine.getCoins());
        MyGumballMachine.insertQuarter();
        assertEquals(35, MyGumballMachine.getCoins());
        MyGumballMachine.turnCrank();
        assertEquals(false, MyGumballMachine.isGumballInSlot());
    }

    @Test
    public void testToTurnCrankTwice()
    {
        System.out.println("\n***Test 5: testToTurnCrankTwice***");
        MyGumballMachine.insertQuarter();
        MyGumballMachine.insertQuarter();
        MyGumballMachine.turnCrank();
        MyGumballMachine.takeGumballFromSlot();
        MyGumballMachine.turnCrank();
        assertEquals(false, MyGumballMachine.isGumballInSlot());
    }

    @Test
    public void testOutOfGumball()
    {
        System.out.println("\n***Test 6: testOutOfGumball***");
        for(int i=0; i<6; i++){
        MyGumballMachine.insertQuarter();
        MyGumballMachine.insertQuarter();
        MyGumballMachine.turnCrank();
        }
        MyGumballMachine.takeGumballFromSlot();
        assertEquals(false, MyGumballMachine.isGumballInSlot());
    }
}









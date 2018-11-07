import sofia.micro.*;
import sofia.battleship.*;
import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 *  Tests the MyStrategy class and all of its contents
 *  including placement, devious play, and the next shot
 *
 *  @author lily chen (lilychen)
 *  @version (2017.10.30)
 */
public class MyStrategyTest extends TestCase
{
    //~ Fields ................................................................
    private BattleshipStrategy myStrategy;
    private TestableGameState state;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BattleshipTest test object.
     */
    public MyStrategyTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /*# Insert your own setup code here */
        state = new TestableGameState();
        myStrategy = new MyStrategy();
        myStrategy.newGame();
    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * tests the ship placement of CARRIER ship
     */
    public void testPlacement()
    {
        Random.setNextInts(1);
        ShipPlacementMove placement = myStrategy.placeShips(state);

        Ship carrier = placement.getShip(ShipType.CARRIER);

        assertTrue(carrier.isOrientedHorizontally());
    }

    /**
     * tests the canPlayDeviously() method
     */
    public void testCanPlayDeviously()
    {
        assertFalse(myStrategy.canPlayDeviously());
    }

    /**
     * test call shot move 
     */
    public void testCallShotMove()
    {
        Random.setNextInts(4, 4);
        CallShotMove shot = myStrategy.callNextShot(state);
        assertEquals(shot.getX(), 4);
        assertEquals(shot.getY(), 4);
    }

    /**
     * test call shot move 2
     */
    public void testCallShotMove2()
    {
        TestableBoard oppBoard = state.getOpponentsBoard();
        oppBoard.fireAt(4, 4);
        Random.setNextInts(4, 4, 5, 5);
        CallShotMove shot = myStrategy.callNextShot(state);
        assertEquals(shot.getX(), 5);
        assertEquals(shot.getY(), 5);
    }

}

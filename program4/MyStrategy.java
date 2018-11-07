import sofia.battleship.*;
import static sofia.battleship.ShipType.*;
import static sofia.battleship.CellStatus.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  This class represents the strategy that will be
 *  employed during each game.
 *  Contains methods for firing shots,
 *  and placement of ships.
 *
 *  @author lily chen (lilychen)
 *  @version (2017.10.30)
 */
public class MyStrategy implements BattleshipStrategy
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new MyStrategy object.
     */
    public MyStrategy()
    {
        /*# Do any work to initialize your class here. */
    }

    //~ Methods ...............................................................

    /**
     * method play to call player's next move
     * @param currentGameState    current state of player/opponent's board
     * @return  the coordinates (x, y) of shot
     */
    public CallShotMove callNextShot(GameState currentGameState )
    {
        int x = Random.generator().nextInt(10);
        int y = Random.generator().nextInt(10);
        while (!(currentGameState.getOpponentsBoard().canFireAt(x, y)))
        {
            x = Random.generator().nextInt(10);
            y = Random.generator().nextInt(10);
        }
        return new CallShotMove(x, y);

    }

    /**
     * can play deviously (reposition ships)
     * @return  whether or not DeviousPlay is allowed
     */
    public boolean canPlayDeviously()
    {
        return false;
    }

    /**
     * return name of player/strategy
     * @return  the name of the player (PID)
     */
    public String getName()
    {
        return "lilychen";
    }

    /**
     * re/initialize strategy to play new game (resets)
     */
    public void newGame()
    {
        // resetting to initial locations is unneccessary, 
        // thus this method returns nothing
    }

    /**
     * called to place ships on board
     * @param currentGameState    current state of player/opponents board(s)
     * @return  the placement of the ships
     */
    public ShipPlacementMove placeShips(GameState currentGameState)
    {
        ShipPlacementMove placement = new ShipPlacementMove(currentGameState);
        while (!placement.isValid())
        {
            for (int a = 0; a < 5; a++)
            {
                int x =  Random.generator().nextInt(5);
                int y = Random.generator().nextInt(10);
                placement.placeShip(ShipType.valueOf(a), x, y, true);
            }
        }
        return placement;
    }

}

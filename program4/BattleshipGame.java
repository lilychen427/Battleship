import sofia.battleship.*;

//-------------------------------------------------------------------------
/**
 *  A game of "Battleship".
 *
 *  @author lily chen (lilychen)
 *  @version (2017.10.28)
 */
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Lily Chen (lilychen)

public class BattleshipGame extends Game
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BattleshipGame object.
     */
    public BattleshipGame()
    {
        super();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Create a strategy object representing your player strategy.
     * @return The strategy I want to use in this game.
     */
    public BattleshipStrategy createMyStrategy()
    {
        /*# Replace this with your own strategy */
        return new MyStrategy();
    }


    // ----------------------------------------------------------
    /**
     * Create a strategy object representing your opponent's strategy.
     * @return The strategy my opponent will use in this game.
     */
    public BattleshipStrategy createOpponentsStrategy()
    {
        return new RandomStrategy();
    }
}

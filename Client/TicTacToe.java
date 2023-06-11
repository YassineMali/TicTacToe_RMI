import java.rmi.Remote;
import java.util.Random;

public interface TicTacToe extends Remote{

    public void firstTurn();
    
	public int[] check();
    
	public Random getRandom() ;

	public void setRandom(Random random) ;

	public boolean isPlayer1_turn() ;

	public boolean getPlayer1_turn() ;

	public int getPlayerNumber() ;

	public void setPlayer1_turn(boolean player1_turn) ;

	public String[] getMap() ;

	public void setMap(String[] map) ;

}

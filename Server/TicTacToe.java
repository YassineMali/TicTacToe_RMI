import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Random;

public interface TicTacToe extends Remote{

    public void firstTurn()throws RemoteException;
    
	public int[] check()throws RemoteException;
    
	public Random getRandom() throws RemoteException;

	public void setRandom(Random random) throws RemoteException;

	public boolean isPlayer1_turn() throws RemoteException;

	public boolean getPlayer1_turn() throws RemoteException;

	public int getPlayerNumber() throws RemoteException;

	public void setPlayer1_turn(boolean player1_turn) throws RemoteException;

	public String[] getMap() throws RemoteException;

	public void setMap(String[] map) throws RemoteException;

}

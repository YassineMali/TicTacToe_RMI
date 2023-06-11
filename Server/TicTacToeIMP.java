
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class TicTacToeIMP extends UnicastRemoteObject implements TicTacToe{
	static int nbr=0;
	Random random = new Random();
	boolean player1_turn;
	String[] map ;

	public TicTacToeIMP() throws RemoteException{
		super();
		 map = new String[9];
		Arrays.fill(map, "");
		firstTurn();
	}
	
	@Override
	public void firstTurn() throws RemoteException {
	
		if(random.nextInt(2)==0) {
			player1_turn=true;
		}
		else {
			player1_turn=false;
		}
	}
	
	@Override
	public int[] check() throws RemoteException {
		//check X win conditions
		
		if(
				(map[0].equals("X")) &&
				(map[1] .equals("X")) &&
				(map[2] .equals("X"))
				) {
			int[] result = {0,1,2,1};
			return result;
		}
		if(
				(map[3] .equals("X")) &&
				(map[4] .equals("X")) &&
				(map[5] .equals("X"))
				) {
			int[] result = {3,4,5,1};
			return result;
		}
		if(
				(map[6] .equals("X")) &&
				(map[7] .equals("X")) &&
				(map[8] .equals("X"))
				) {
			int[] result = {6,7,8,1};
			return result;
		}
		if(
				(map[0] .equals("X")) &&
				(map[3] .equals("X")) &&
				(map[6] .equals("X"))
				) {
			int[] result = {0,3,6,1};
			return result;
		}
		if(
				(map[1] .equals("X")) &&
				(map[4] .equals("X")) &&
				(map[7] .equals("X"))
				) {
			int[] result = {1,4,7,1};
			return result;
		}
		if(
				(map[2] .equals("X")) &&
				(map[5] .equals("X")) &&
				(map[8] .equals("X"))
				) {
			int[] result = {2,5,8,1};
			return result;
		}
		if(
				(map[0] .equals("X")) &&
				(map[4] .equals("X")) &&
				(map[8] .equals("X"))
				) {
			int[] result = {0,4,8,1};
			return result;
		}
		if(
				(map[2] .equals("X")) &&
				(map[4] .equals("X")) &&
				(map[6] .equals("X"))
				) {
			int[] result = {2,4,6,1};
			return result;
		}
		//check O win conditions
		if(
				(map[0] .equals("O")) &&
				(map[1] .equals("O")) &&
				(map[2] .equals("O"))
				) {
			int[] result = {0,1,2,2};
			return result;
		}
		if(
				(map[3] .equals("O")) &&
				(map[4] .equals("O")) &&
				(map[5] .equals("O"))
				) {
			int[] result = {3,4,5,2};
			return result;
		}
		if(
				(map[6] .equals("O")) &&
				(map[7] .equals("O")) &&
				(map[8] .equals("O"))
				) {
			int[] result = {6,7,8,2};
			return result;
		}
		if(
				(map[0] .equals("O")) &&
				(map[3] .equals("O")) &&
				(map[6] .equals("O"))
				) {
			int[] result = {0,3,6,2};
			return result;
		}
		if(
				(map[1] .equals("O")) &&
				(map[4] .equals("O")) &&
				(map[7] .equals("O"))
				) {
			int[] result = {1,4,7,2};
			return result;
		}
		if(
				(map[2] .equals("O")) &&
				(map[5] .equals("O")) &&
				(map[8] .equals("O"))
				) {
			int[] result = {2,5,8,2};
			return result;
		}
		if(
				(map[0] .equals("O")) &&
				(map[4] .equals("O")) &&
				(map[8] .equals("O"))
				) {
			int[] result = {0,4,8,2};
			return result;
		}
		if(
				(map[2] .equals("O")) &&
				(map[4] .equals("O")) &&
				(map[6] .equals("O"))
				) {
			int[] result = {2,4,6,2};
			return result;
		}
		int[] result = {0,0,0,0};
		return result;
	}
		
	@Override
	public Random getRandom() throws RemoteException{
		return this.random;
	}

	@Override
	public void setRandom(Random random) throws RemoteException{
		this.random = random;
	}

	@Override
	public boolean isPlayer1_turn() throws RemoteException{
		return this.player1_turn;
	}

	@Override
	public boolean getPlayer1_turn()throws RemoteException {
		return this.player1_turn;
	}

	@Override
	public void setPlayer1_turn(boolean player1_turn)throws RemoteException {
		this.player1_turn = player1_turn;
	}

	@Override
	public String[] getMap()throws RemoteException {
		return this.map;
	}
	
	@Override
	public void setMap(String[] map) throws RemoteException{
		this.map = map;
	}

	@Override
	public int getPlayerNumber() throws RemoteException{
		nbr++;
		if(nbr==3){
			nbr=1;
			map=null;
			map = new String[9];
			Arrays.fill(map,"");
		}
		return nbr;
	}

}

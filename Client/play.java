
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class play {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		TicTacToe ticTacToe =(TicTacToe)Naming.lookup("rmi://localhost:1099/tictactoe");
		new TicTacToeDESIGN(ticTacToe);
	}
}
    

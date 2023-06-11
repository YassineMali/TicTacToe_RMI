import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(1099);
        TicTacToeIMP ticTacToe = new TicTacToeIMP();
        Naming.rebind("rmi://localhost:1099/tictactoe", ticTacToe);
    }
}


import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.*;


public class TicTacToeDESIGN implements ActionListener{

	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	TicTacToe ticTacToe;
	int playerNumber;

	TicTacToeDESIGN(TicTacToe ticTacToe) throws MalformedURLException, RemoteException, NotBoundException{
		this.ticTacToe=ticTacToe;
		ticTacToe.firstTurn();
		playerNumber=ticTacToe.getPlayerNumber();
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);

		startListening();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(playerNumber == 1){
					if(ticTacToe.getPlayer1_turn()) {
						if(buttons[i].getText()=="") {
							buttons[i].setForeground(new Color(255,0,0));
							buttons[i].setText("X");
							ticTacToe.setPlayer1_turn(false);
							textfield.setText("O turn");
							String[] map = ticTacToe.getMap();
							map[i]="X";
							ticTacToe.setMap(map);
						}
					}
					else {
							//buttons[i].setEnabled(false);
					}
				}
				if(playerNumber == 2){
					if(ticTacToe.getPlayer1_turn()== false) {
						if(buttons[i].getText()=="") {
							buttons[i].setForeground(new Color(0,0,255));
							buttons[i].setText("O");
							ticTacToe.setPlayer1_turn(true);
							textfield.setText("X turn");
							String[] map = ticTacToe.getMap();
							map[i]="O";
							ticTacToe.setMap(map);

						}
					}
					else {
							//buttons[i].setEnabled(false);
					}
				}
				
			}			
		}
	}
	

	
	
	public void xWins(int a,int b,int c) {
		if(playerNumber == 1) {
			buttons[a].setBackground(new Color(130, 255,130));
			buttons[b].setBackground(new Color(130, 255,130));
			buttons[c].setBackground(new Color(130, 255,130));

			textfield.setText("YOU WIN");
		}else{
			buttons[a].setBackground(new Color(255, 130, 130));
			buttons[b].setBackground(new Color(255, 130, 130));
			buttons[c].setBackground(new Color(255, 130, 130));

			textfield.setText("YOU LOST");	
		}
	}
	
	public void oWins(int a,int b,int c) {
		
		if(playerNumber == 2) {
			buttons[a].setBackground(new Color(130, 255,130));
			buttons[b].setBackground(new Color(130, 255,130));
			buttons[c].setBackground(new Color(130, 255,130));

			textfield.setText("YOU WIN");
		}else{
			buttons[a].setBackground(new Color(255, 130, 130));
			buttons[b].setBackground(new Color(255, 130, 130));
			buttons[c].setBackground(new Color(255, 130, 130));

			textfield.setText("YOU LOST");	
		}
	}
private void startListening() {
    int delay = 100; // Delay in milliseconds
    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String[] map = ticTacToe.getMap();
				boolean state= false;
				
                for (int i = 0; i < 9; i++) {
                    if (map[i].equals("X")) {
                        buttons[i].setText("X");
						buttons[i].setForeground(new Color(255,0,0));
                    } else if (map[i].equals("O")) {
                        buttons[i].setText("O");
                        buttons[i].setForeground(new Color(0,0,255));
                    } 
                }
				if(playerNumber == 1){
					if(ticTacToe.getPlayer1_turn()) {
						textfield.setText("YOUR TURN");
					}else{
							textfield.setText("O turn");
					}
				}else{
					if(ticTacToe.getPlayer1_turn() == false) {
						textfield.setText("YOUR TURN");
					}else{
							textfield.setText("X turn");
					}
				}

				int[] result = ticTacToe.check();
				int winner=result[3];
				

				if(winner != 0) {
					if(winner == 1){
						xWins(result[0],result[1],result[2]);
					}else{
						oWins(result[0],result[1],result[2]);
					}
					for(int i=0;i<9;i++){
						if(buttons[i].getText().equals("")){
							buttons[i].setEnabled(false);
						}
					}
				}

				for(int i=0;i<9;i++){
					if(map[i].equals("")){
						state=true;
					}
				}
				if(state==false && winner==0){
					textfield.setText("NO ONE WON");
				}

				
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    Timer timer = new Timer(delay, listener);
    timer.start();
}

	}

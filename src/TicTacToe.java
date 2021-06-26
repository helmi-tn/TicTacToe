import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    Random FirstTurn = new Random(); //To tell who's turn is the first

    JFrame frame = new JFrame(); //window
    JPanel title_panel = new JPanel(); //a panel for the title
    JPanel button_pannel = new JPanel();//pannels for buttons
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];//9 buttons
    boolean player1Turn;


    public TicTacToe() {
        //setting the main window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//program stops working when the window is closed
        frame.setSize(700, 600);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //setting the title's text field
        textfield.setText("Tic-Tac-Toe");
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.ORANGE);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 40));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 100, 100);


        //setting the buttons
        button_pannel.setLayout(new GridLayout(3, 3));
        button_pannel.setBackground(Color.gray);

        frame.add(title_panel, BorderLayout.NORTH);//adding the title to the main window
        title_panel.add(textfield); //adding the text as a title


        for (int i = 0; i < 9; i++) { //create 9 buttons
            buttons[i] = new JButton();
            button_pannel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 140));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this::actionPerformed); //to print X or O upon clicking,alternate between turns and check who won
        }
        frame.add(button_pannel);//adding the buttons
        firstTurn(); //to check who's turn is first

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("X");
                        player1Turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                        player1Turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn() {

        try {
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        if (FirstTurn.nextInt(2) == 0) {
            player1Turn = true;
            textfield.setText("X turn");
        }
    else{
        player1Turn = false;
        textfield.setText("O turn");
    }
}
    public void check(){ //to check who won
        if((buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")){//if the first row has all matching Xs
            xWins(0,1,2);
        }
      if((buttons[3].getText()=="X") &&
            (buttons[4].getText()=="X")&&
            (buttons[5].getText()=="X")){//if the 2nd row has all matching Xs
        xWins(3,4,5);
    }
        if((buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")){//if the 3rd row has all matching Xs
            xWins(6,7,8);
        }
        if((buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }

        if((buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }

        //same thing for O
        if((buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if((buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O")&&
                (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }

        if((buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O")&&
                (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
    }

    public void xWins(int a,int b,int c){ //a,b and c are the winning combination
    buttons[a].setBackground(Color.green);
    buttons[b].setBackground(Color.green);//to highlight the winning combination
    buttons[c].setBackground(Color.green);


    for(int i=0;i<9;i++){
        buttons[i].setEnabled(false);//Players cannot keep playing after finishing the game
    }
    textfield.setForeground(Color.RED);
    textfield.setText("X wins");
    }

    public void oWins(int a,int b,int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setForeground(Color.RED);
        textfield.setText("O wins");
    }
}

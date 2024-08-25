import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToe{
    int boardWidth = 600;
    int boardHeight = 650;


    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;

    TicTacToe(){
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial",Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("TicTacToe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);


        for(int r= 0;r<3;r++){
            for(int c= 0; c<3;c++){
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                // tile.setText(currentPlayer);

                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if(gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if(tile.getText().equals("")){
                            tile.setText(currentPlayer);
                            checkWinner();
                            if(!gameOver){
                                if(currentPlayer.equals(playerX))
                                    currentPlayer = playerO;
                                else
                                    currentPlayer = playerX;
                                textLabel.setText(currentPlayer + "'s turn");
                            }
                        }

                    }
                });
            }
        }
    }
    void checkWinner(){
        //horizontal

        for(int r = 0; r< 3; r++){
            if(board[r][0].getText().equals("")) continue;
            
            if(board[r][0].getText().equals(board[r][1].getText()) && 
               board[r][1].getText().equals(board[r][2].getText())){
                    for(int i = 0; i<3; i++){
                        setWinner(board[r][i]);
                    }
                    gameOver = true;
                    return;
            }

            if(board[0][r].getText().equals(board[1][r].getText()) && 
               board[1][r].getText().equals(board[2][r].getText())){
                    gameOver = true;
                    return;
            }
        }
    }
    void setWinner(JFrame [][] board){
        
    }
}
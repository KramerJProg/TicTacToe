package com.example.tictactoe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // All private fields used within class
    private final String Player1 = "X";
    private final String Player2 = "O";
    private Button[] btn;
    private String currPlayer;
    private TextView playersTurn;
    private boolean completedGame;
    private String playersTurnStr;
    private int counterForTurns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setDisplayShowHomeEnabled(true);
        bar.setIcon(R.mipmap.tictactoeicon);
        counterForTurns = 0;
        completedGame = false;

        btn = new Button[9];
        btn[0] = findViewById(R.id.btn1);
        btn[1] = findViewById(R.id.btn2);
        btn[2] = findViewById(R.id.btn3);
        btn[3] = findViewById(R.id.btn4);
        btn[4] = findViewById(R.id.btn5);
        btn[5] = findViewById(R.id.btn6);
        btn[6] = findViewById(R.id.btn7);
        btn[7] = findViewById(R.id.btn8);
        btn[8] = findViewById(R.id.btn9);

        currPlayer = Player1;
        playersTurn = findViewById(R.id.txtTurnWins);
        playersTurnStr = "Player " + currPlayer + ", start the game!";
        playersTurn.setText(playersTurnStr);
    }

    /**
     * Players are able to click on tiles to place an X or an O
     * depending on the current player's turn. Logic implemented
     * for game to be played accordingly by calling other methods.
     * Also displays whose turn is currently in play.
     */
    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        if (((Button)view).getText().equals("") && !completedGame) {
            ((Button)view).setText(currPlayer);
            if (currPlayer.equals(Player1)) {
                counterForTurns++;
                if (counterForTurns >= 3 && winnerCheck()) {
                    decideTheWinner();
                    return;
                }
                else if (counterForTurns == 5) {
                    tieGame();
                    return;
                }
                currPlayer = Player2;
            }
            else {
                if (counterForTurns >= 3 && winnerCheck()) {
                    decideTheWinner();
                    return;
                }
                currPlayer = Player1;
            }
            playersTurn.setText("It is now player " + currPlayer + "'s Turn");
        }
    }

    /**
     * Creates a new game for players once current game
     * has come to an end by win or tie.
     */
    @SuppressLint("SetTextI18n")
    public void newGameBtn(View view) {
        int i = 0;
        while (i < btn.length) {
            btn[i].setText("");
            i++;
        }
        currPlayer = Player1;
        playersTurn.setText("Player " + currPlayer + ", start the game!");
        completedGame = false;
        counterForTurns = 0;
    }

    /**
     * Displays message for a tied game.
     */
    @SuppressLint("SetTextI18n")
    public void tieGame() {
        playersTurn.setText("You have tied! Start a new game.");
    }

    /**
     * Displaying the winners text once a winner has been decided.
     */
    public void decideTheWinner() {
        completedGame = true;

        playersTurnStr ="Player " + currPlayer + " won the game!";
        playersTurn.setText(playersTurnStr);
    }

    /**
     * All possible button combinations for three in a row.
     * When a player gets 3 in a row in any direction,
     * this method will be called, triggering a check for
     * the winner of the game. If a tie occurs, this method
     * is never called.
     */
    public boolean winnerCheck() {
        // Checking for vertical wins.
        if (btn[0].getText().equals(currPlayer) &&
            btn[3].getText().equals(currPlayer) &&
            btn[6].getText().equals(currPlayer)) {
            return true;
        }
        else if (btn[1].getText().equals(currPlayer) &&
                 btn[4].getText().equals(currPlayer) &&
                 btn[7].getText().equals(currPlayer)) {
            return true;
        }
        else if (btn[2].getText().equals(currPlayer) &&
                 btn[5].getText().equals(currPlayer) &&
                 btn[8].getText().equals(currPlayer)) {
            return true;
        }
        // Checking for horizontal wins.
        else if (btn[0].getText().equals(currPlayer) &&
                 btn[1].getText().equals(currPlayer) &&
                 btn[2].getText().equals(currPlayer)) {
            return true;
        }
        else if (btn[3].getText().equals(currPlayer) &&
                 btn[4].getText().equals(currPlayer) &&
                 btn[5].getText().equals(currPlayer)) {
            return true;
        }
        else if (btn[6].getText().equals(currPlayer) &&
                 btn[7].getText().equals(currPlayer) &&
                 btn[8].getText().equals(currPlayer)) {
            return true;
        }
        // Checking for diagonal wins.
        else if (btn[0].getText().equals(currPlayer) &&
                 btn[4].getText().equals(currPlayer) &&
                 btn[8].getText().equals(currPlayer)) {
            return true;
        }
        else {
            return btn[2].getText().equals(currPlayer) &&
                   btn[4].getText().equals(currPlayer) &&
                   btn[6].getText().equals(currPlayer);
        }
    }
}
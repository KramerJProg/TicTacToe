package com.example.tictactoe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private final String Player1 = "X";
    private final String Player2 = "O";
    private Button[] btn;
    private String currPlayer;
    private TextView playersTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayShowHomeEnabled(true);
        bar.setIcon(R.mipmap.tictactoeicon);

        btn = new Button[9];
        btn[0] = (Button)findViewById(R.id.btn1);
        btn[1] = (Button)findViewById(R.id.btn2);
        btn[2] = (Button)findViewById(R.id.btn3);
        btn[3] = (Button)findViewById(R.id.btn4);
        btn[4] = (Button)findViewById(R.id.btn5);
        btn[5] = (Button)findViewById(R.id.btn6);
        btn[6] = (Button)findViewById(R.id.btn7);
        btn[7] = (Button)findViewById(R.id.btn8);
        btn[8] = (Button)findViewById(R.id.btn9);

        currPlayer = Player1;
        playersTurn = (TextView)findViewById(R.id.txtTurnWins);
        playersTurn.setText("Player " + currPlayer + ", start the game!");
    }

    public void onClick(View view) {
        if (((Button)view).getText().equals("")) {
            ((Button)view).setText(currPlayer);
            if (currPlayer == Player1) {
                currPlayer = Player2;
                playersTurn.setText("It is now player " + currPlayer + "'s Turn");
            }
            else {
                currPlayer = Player1;
                playersTurn.setText("It is now player " + currPlayer + "'s Turn");
            }
        }
    }

    public void newGameBtn(View view) {
        for (int i = 0; i < btn.length; i++) {
            btn[i].setText("");
        }
        currPlayer = Player1;
        playersTurn.setText("Player " + currPlayer + ", start the game!");
    }
}
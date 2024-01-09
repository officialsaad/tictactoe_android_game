package com.ARID1737.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    int count, xwin = 0, owin = 0, draw = 0;

    int flag = 0;

    String b1, b2, b3, b4, b5, b6, b7, b8, b9, p1name, p2name;
    TextView p1, p2, p1wins, p2wins, draw_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1 = findViewById(R.id.player1name);
        p2 = findViewById(R.id.player2name);
        p1wins = findViewById(R.id.player1wins);
        p2wins = findViewById(R.id.player2wins);
        draw_count = findViewById(R.id.drawcount);

        p1name = getIntent().getStringExtra("p1name");
        p2name = getIntent().getStringExtra("p2name");

        p1.setText(p1name);
        p2.setText(p2name);

        Toast.makeText(this, "Player 1 is X and Player 2 is O", Toast.LENGTH_LONG).show();

        fun();
    }

    protected void fun() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void reset() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;
    }

    public void winscount(String x) {
        if (x.equals("x") || x.equals("X")) {
            xwin++;
            p1wins.setText(String.valueOf(xwin));
        }
        if (x.equals("o") || x.equals("O")) {
            owin++;
            p2wins.setText(String.valueOf(owin));
        }
    }

    public void checks(View v) {
        Button current_button = (Button) v;
        if (current_button.getText().toString().equals("")) {
            count++;

            if (flag == 0) {
                current_button.setText("X");
                flag = 1;
            } else {
                current_button.setText("O");
                flag = 0;
            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                // Conditions
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    Toast.makeText(this, "winner is :" + b1, Toast.LENGTH_LONG).show();
                    winscount(b1);
                    reset();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    Toast.makeText(this, "winner is :" + b4, Toast.LENGTH_LONG).show();
                    winscount(b4);
                    reset();
                } else if (b7.equals(b8) && b7.equals(b9) && !b8.equals("")) {
                    Toast.makeText(this, "winner is :" + b9, Toast.LENGTH_LONG).show();
                    winscount(b7);
                    reset();
                } else if (b1.equals(b4) && b1.equals(b7) && !b1.equals("")) {
                    Toast.makeText(this, "winner is :" + b1, Toast.LENGTH_LONG).show();
                    winscount(b1);
                    reset();

                } else if (b2.equals(b5) && b2.equals(b8) && !b8.equals("")) {
                    Toast.makeText(this, "winner is :" + b2, Toast.LENGTH_LONG).show();
                    winscount(b2);
                    reset();

                } else if (b3.equals(b6) && b3.equals(b9) && !b9.equals("")) {
                    Toast.makeText(this, "winner is :" + b3, Toast.LENGTH_LONG).show();
                    winscount(b3);
                    reset();
                } else if (b1.equals(b5) && b1.equals(b9) && !b1.equals("")) {
                    Toast.makeText(this, "winner is :" + b1, Toast.LENGTH_LONG).show();
                    winscount(b1);
                    reset();

                } else if (b3.equals(b5) && b3.equals(b7) && !b7.equals("")) {
                    Toast.makeText(this, "winner is :" + b7, Toast.LENGTH_LONG).show();
                    winscount(b3);
                    reset();
                } else {
                    if (count == 9) {
                        draw++;
                        draw_count.setText(String.valueOf(draw));
                        Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show();
                        reset();
                    }
                }
            }
        }
    }
}

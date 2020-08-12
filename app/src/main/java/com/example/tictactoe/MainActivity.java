package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean gameOver = false;
    private int turn = 1;
    private TextView tv1;
    private TextView tv2;
    private TextView score1;
    private TextView score2;
    private TextView gameOver_tv;
    private Button newGame;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private int number;
    private String name1;
    private String name2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize values
        setValues();

        Intent intent = getIntent();
        name1 = intent.getStringExtra(home.EXTRA_TEXT1);
        name2 = intent.getStringExtra(home.EXTRA_TEXT2);
        number = intent.getIntExtra(home.EXTRA_NUMBER, 0);

        tv1.setText(name1);
        tv2.setText(name2);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewGame();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAction(btn1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAction(btn2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAction(btn3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAction(btn4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAction(btn5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAction(btn6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAction(btn7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAction(btn8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAction(btn9);
            }
        });

    }

    private void setValues() {
        tv1 = findViewById(R.id.tv1_TV_main);
        tv2 = findViewById(R.id.tv2_TV_main);
        score1 = findViewById(R.id.score1_TV_main);
        score2 = findViewById(R.id.score2_TV_main);
        gameOver_tv = findViewById(R.id.gameOver_TV_main);
        newGame = findViewById(R.id.newGame_BTN_main);
        btn1 = findViewById(R.id.btn1_BTN_main);
        btn2 = findViewById(R.id.btn2_BTN_main);
        btn3 = findViewById(R.id.btn3_BTN_main);
        btn4 = findViewById(R.id.btn4_BTN_main);
        btn5 = findViewById(R.id.btn5_BTN_main);
        btn6 = findViewById(R.id.btn6_BTN_main);
        btn7 = findViewById(R.id.btn7_BTN_main);
        btn8 = findViewById(R.id.btn8_BTN_main);
        btn9 = findViewById(R.id.btn9_BTN_main);
    }

    private void switchTurn() {
        if (turn == 1)
            turn = 2;
        else
            turn = 1;
    }

    private void createNewGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        gameOver_tv.setText("");
        turn = 1;
        gameOver = false;
    }

    private void onClickAction(Button btn) {
        if (btn.getText().toString().equals("") && !gameOver) {
            if (turn == 1)
                btn.setText("X");
            else
                btn.setText("O");
            switchTurn();

            //check if game over
            CheckIfGameOver();
        }
    }

    private void CheckIfGameOver() {
        if (checkLines() || checkColumns() || checkDiagonals()) { // update points
            gameOver = true;
            if(number == Integer.parseInt(score1.getText().toString())) {
                gameOver_tv.setText(name1 + " win!!!\n" + score1.getText().toString() + ":" + score2.getText().toString());
                score1.setText("0");
                score2.setText("0");
            }
            else if(number == Integer.parseInt(score2.getText().toString())) {
                gameOver_tv.setText(name2 + " win!!!\n" + score2.getText().toString() + ":" + score1.getText().toString());
                score1.setText("0");
                score2.setText("0");
            }
            else
                gameOver_tv.setText("Game Over!");
        }
    }

    private boolean checkDiagonals() {
        if (btn1.getText().toString().equals(btn5.getText().toString()) && btn1.getText().toString().equals(btn9.getText().toString())) {
            if (btn1.getText().toString().equals("X")) {
                int tempScore = Integer.parseInt(score1.getText().toString());
                tempScore += 1;
                score1.setText(String.valueOf(tempScore));
                return true;
            } else if(btn1.getText().toString().equals("O")) {
                int tempScore = Integer.parseInt(score2.getText().toString());
                tempScore += 1;
                score2.setText(String.valueOf(tempScore));
                return true;
            }
        }

        if (btn3.getText().toString().equals(btn5.getText().toString()) && btn3.getText().toString().equals(btn7.getText().toString())) {
            if (btn3.getText().toString().equals("X")) {
                int tempScore = Integer.parseInt(score1.getText().toString());
                tempScore += 1;
                score1.setText(String.valueOf(tempScore));
                return true;
            } else if(btn3.getText().toString().equals("O")) {
                int tempScore = Integer.parseInt(score2.getText().toString());
                tempScore += 1;
                score2.setText(String.valueOf(tempScore));
                return true;
            }
        }

        return false;
    }

    private boolean checkColumns() {
        if (btn1.getText().toString().equals(btn4.getText().toString()) && btn1.getText().toString().equals(btn7.getText().toString())) {
            if (btn1.getText().toString().equals("X")) {
                int tempScore = Integer.parseInt(score1.getText().toString());
                tempScore += 1;
                score1.setText(String.valueOf(tempScore));
                return true;
            } else if(btn1.getText().toString().equals("O")) {
                int tempScore = Integer.parseInt(score2.getText().toString());
                tempScore += 1;
                score2.setText(String.valueOf(tempScore));
                return true;
            }
        }

        if (btn2.getText().toString().equals(btn5.getText().toString()) && btn2.getText().toString().equals(btn8.getText().toString())) {
            if (btn2.getText().toString().equals("X")) {
                int tempScore = Integer.parseInt(score1.getText().toString());
                tempScore += 1;
                score1.setText(String.valueOf(tempScore));
                return true;
            } else if(btn2.getText().toString().equals("O")) {
                int tempScore = Integer.parseInt(score2.getText().toString());
                tempScore += 1;
                score2.setText(String.valueOf(tempScore));
                return true;
            }
        }

        if (btn3.getText().toString().equals(btn6.getText().toString()) && btn3.getText().toString().equals(btn9.getText().toString())) {
            if (btn3.getText().toString().equals("X")) {
                int tempScore = Integer.parseInt(score1.getText().toString());
                tempScore += 1;
                score1.setText(String.valueOf(tempScore));
                return true;
            } else if(btn3.getText().toString().equals("O")) {
                int tempScore = Integer.parseInt(score2.getText().toString());
                tempScore += 1;
                score2.setText(String.valueOf(tempScore));
                return true;
            }
        }

        return false;
    }

    private boolean checkLines() {
        if (btn1.getText().toString().equals(btn2.getText().toString()) && btn1.getText().toString().equals(btn3.getText().toString())) {
            if (btn1.getText().toString().equals("X")) {
                int tempScore = Integer.parseInt(score1.getText().toString());
                tempScore += 1;
                score1.setText(String.valueOf(tempScore));
                return true;
            } else if(btn1.getText().toString().equals("O")) {
                int tempScore = Integer.parseInt(score2.getText().toString());
                tempScore += 1;
                score2.setText(String.valueOf(tempScore));
                return true;
            }
        }

        if (btn4.getText().toString().equals(btn5.getText().toString()) && btn4.getText().toString().equals(btn6.getText().toString())) {
            if (btn4.getText().toString().equals("X")) {
                int tempScore = Integer.parseInt(score1.getText().toString());
                tempScore += 1;
                score1.setText(String.valueOf(tempScore));
                return true;
            } else if(btn4.getText().toString().equals("O")) {
                int tempScore = Integer.parseInt(score2.getText().toString());
                tempScore += 1;
                score2.setText(String.valueOf(tempScore));
                return true;
            }
        }

        if (btn7.getText().toString().equals(btn8.getText().toString()) && btn7.getText().toString().equals(btn9.getText().toString())) {
            if (btn7.getText().toString().equals("X")) {
                int tempScore = Integer.parseInt(score1.getText().toString());
                tempScore += 1;
                score1.setText(String.valueOf(tempScore));
                return true;
            } else if(btn7.getText().toString().equals("O")) {
                int tempScore = Integer.parseInt(score2.getText().toString());
                tempScore += 1;
                score2.setText(String.valueOf(tempScore));
                return true;
            }
        }

        return false;
    }
}

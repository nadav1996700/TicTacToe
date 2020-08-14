package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class home extends AppCompatActivity {

    public static final String EXTRA_TEXT1 = "com.example.application.example.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2 = "com.example.application.example.EXTRA_TEXT2";
    public static final String EXTRA_TEXT3 = "com.example.application.example.EXTRA_TEXT3";
    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";

    private ImageView img1_IV_home;
    private EditText player1_name;
    private EditText player2_name;
    private EditText numberOfGames;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initialize values
        setValues();
        //loadGlide(img1_IV_home);

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openActivityHome();
            }
        });
    }

    private void openActivityHome() {

        // extract data
        String name1 = "", name2 = "";
        int number = 1;
        name1 = player1_name.getText().toString();
        name2 = player2_name.getText().toString();
        number = Integer.parseInt(numberOfGames.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_TEXT1, name1);
        intent.putExtra(EXTRA_TEXT2, name2);
        intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }

    private void setValues() {
        img1_IV_home = findViewById(R.id.img1_IV_home);
        player1_name = findViewById(R.id.Name1_EDT_home);
        player2_name = findViewById(R.id.Name2_EDT_home);
        numberOfGames = findViewById(R.id.Number_of_games_EDT_home);
        start = findViewById(R.id.start_BTN_home);
    }

    private void loadGlide(ImageView iv) {
        Glide.with(home.this)
                .load("https://thumbs.gfycat.com/SolidTestyCockatoo-small.gif")
                .placeholder(R.drawable.tic_tac_toe)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(iv);
    }
}
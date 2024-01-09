package com.ARID1737.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class splashscreen extends AppCompatActivity {
    ProgressBar pb;
    Handler handler;

    int counter = 0;
    Intent intent;
    TextView txtlogo;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        imageView = findViewById(R.id.imagelogo);
        imageView.setAlpha(0f);
        imageView.setTranslationY(50);
        imageView.animate().alpha(1f).translationYBy(-50).setDuration(3000);



        pb = (ProgressBar)findViewById(R.id.pb1);
        txtlogo = (TextView) findViewById(R.id.logotext);
        Animation move = AnimationUtils.loadAnimation(this,R.anim.move_animation);
        txtlogo.startAnimation(move); // only one time animate

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                counter += 1;

                if (counter >= 100) {
                    SharedPreferences pref = getSharedPreferences("terms", MODE_PRIVATE);
                    boolean check = pref.getBoolean("rterms", false); // Second is the default value
                    if(check){
                       intent = new Intent(splashscreen.this,userdetails.class);

                    }
                    else {
                        intent = new Intent(splashscreen.this,rules.class);

                    }
                    startActivity(intent);
                    finish(); // Add this if you want to finish the current activity
                } else {
                    pb.setProgress(counter);
                    // Recursive call to update progress until counter reaches 100
                    new Handler().postDelayed(this, 5); // Adjust delay as needed
                }
            }
        }, 1000);




    }

}
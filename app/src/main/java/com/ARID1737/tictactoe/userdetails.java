package com.ARID1737.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userdetails extends AppCompatActivity {
    Button button;
    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);

        button = findViewById(R.id.btn_details);
        e1 = findViewById(R.id.edittext1);
        e2 = findViewById(R.id.edittext2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1 = e1.getText().toString().trim();
                String p2 = e2.getText().toString().trim();
                if(p1.equals("")){
                    Toast.makeText(userdetails.this, "Please Enter player 1 name", Toast.LENGTH_LONG).show();
                }
                else if(p2.equals("")){
                    Toast.makeText(userdetails.this, "Please Enter player 2 name", Toast.LENGTH_LONG).show();
                }
                else{
                    if(p1.equals(p2)){
                        Toast.makeText(userdetails.this, "Please Enter different name for player2", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Intent intent =new Intent(userdetails.this,MainActivity.class);
                        intent.putExtra("p1name",p1);
                        intent.putExtra("p2name",p2);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

    }
}
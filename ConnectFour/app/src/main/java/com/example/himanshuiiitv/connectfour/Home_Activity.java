package com.example.himanshuiiitv.connectfour;

import  com.example.himanshuiiitv.connectfour.MainActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Activity extends AppCompatActivity {

    public static int hv;
    public int challenge(){
        return hv;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);



        ((Button) findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hv=1;
                //challenge();
                startActivity(new Intent(Home_Activity.this,MainActivity.class));
                //k=1;
            }
        });

        ((Button) findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hv=2;
                startActivity(new Intent(Home_Activity.this,MainActivity.class));
                //k=2;
            }
        });


    }
}

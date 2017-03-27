package com.example.himanshuiiitv.connectfour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public int statusg;
    private final int[][] ids =
            {{R.id.imageView11, R.id.imageView12, R.id.imageView13, R.id.imageView14, R.id.imageView15, R.id.imageView16, R.id.imageView17},
                    {R.id.imageView21, R.id.imageView22, R.id.imageView23, R.id.imageView24, R.id.imageView25, R.id.imageView26, R.id.imageView27},
                    {R.id.imageView31, R.id.imageView32, R.id.imageView33, R.id.imageView34, R.id.imageView35, R.id.imageView36, R.id.imageView37},
                    {R.id.imageView41, R.id.imageView42, R.id.imageView43, R.id.imageView44, R.id.imageView45, R.id.imageView46, R.id.imageView47},
                    {R.id.imageView51, R.id.imageView52, R.id.imageView53, R.id.imageView54, R.id.imageView55, R.id.imageView56, R.id.imageView57},
                    {R.id.imageView61, R.id.imageView62, R.id.imageView63, R.id.imageView64, R.id.imageView65, R.id.imageView66, R.id.imageView67}};
    private final int[][] flag = {
            {0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0,}};

    private Random random = new Random();
    Button bReset;
    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    ImageButton b6;
    ImageButton b7;

    TextView statusTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bReset = (Button) findViewById(R.id.button);
        b1 = (ImageButton) findViewById(R.id.click1);
        b2 = (ImageButton) findViewById(R.id.click2);
        b3 = (ImageButton) findViewById(R.id.click3);
        b4 = (ImageButton) findViewById(R.id.click4);
        b5 = (ImageButton) findViewById(R.id.click5);
        b6 = (ImageButton) findViewById(R.id.click6);
        b7 = (ImageButton) findViewById(R.id.click7);
        statusTv = (TextView) findViewById(R.id.Status);
        MediaPlayer tap;


        int r = random.nextInt(2);
        if (r == 0) {
            statusTv.setText("User1 ... Make Your Move!!!!!");
            statusg = 1;
        } else if (r == 1) {
            statusTv.setText("User2 ... Make Your Move!!!!!");
            statusg = 2;

        }
        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetMethod();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(6);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(7);
            }
        });
    }

    private void ResetMethod() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                flag[i][j] = 0;
                ImageView v = (ImageView) findViewById(ids[i][j]);
                v.setImageResource(R.drawable.d3);
            }
        }
    }


    private void click(int rowno) {
        for (int i = 6; i > 0; i--) {
            ImageView v = (ImageView) findViewById(ids[i - 1][rowno - 1]);
            //String imageName=String.valueOf(v.getTag());
            //Log.d(imageName, "click: ");
            //Drawable ico=new Bitmap("red1.png");
            if (flag[i - 1][rowno - 1] == 0) {
                if (statusg == 1) {
                    v.setImageResource(R.drawable.red1);
                    String hello = "hello";
                    Log.e(hello, "we are inside");
                    //statusg = 2;
                    flag[i - 1][rowno - 1] = 1;
                    /*if(thereIsAWinner()){
                        Toast.makeText(MainActivity.this,"Congratulate User "+statusg+" You Win!!!",Toast.LENGTH_SHORT).show();
                        ResetMethod();
                    }*/
                    //statusTv.setText("User1 .... Make Your Move!!!!!");
                    break;
                } else if (statusg == 2) {
                    v.setImageResource(R.drawable.yellow);
                    //statusg=1;
                    flag[i - 1][rowno - 1] = 2;
                    /*if(thereIsAWinner()){
                        Toast.makeText(MainActivity.this,"Congratulate User2 You Win!!!",Toast.LENGTH_SHORT).show();
                        ResetMethod();
                    }*/
                    //statusTv.setText("User2 .... Make Your Move!!!!!");
                    break;
                }
            }
        }
        if (therepossibleIsAWinner()) {
            Toast.makeText(MainActivity.this, "Congratulate User " + statusg + " You Win!!!", Toast.LENGTH_SHORT).show();
            ResetMethod();

        } else {
            if (statusg == 1) {
                statusg = 2;
                statusTv.setText("User2 .... Make Your Move!!!!!");
            } else {
                statusg = 1;
                statusTv.setText("User1 .... Make Your Move!!!!!");
            }
        }
    }

    //pu int row_pos,col_pos;
    int cu_row, cu_col;

    public boolean therepossibleIsAWinner() {
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j <= 6; j++) {

                if (isfour_connect(i, j)) {
                    cu_row = i;
                    cu_col = j;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isfour_connect(int x, int y) {

        if (lineOfFour(x, y, -1, -1))
            return true;
        if (lineOfFour(x, y, -1, 0))
            return true;
        if (lineOfFour(x, y, -1, 1))
            return true;
        if (lineOfFour(x, y, 0, -1))
            return true;
        if (lineOfFour(x, y, 0, 1))
            return true;
        if (lineOfFour(x, y, 1, -1))
            return true;
        if (lineOfFour(x, y, 1, 0))
            return true;
        if (lineOfFour(x, y, 1, 1))
            return true;
        return false;
    }

    public boolean lineOfFour(int row, int col, int dir_x, int dir_y) {
        int m = 0;
        for (int k = 1; k < 4; k++) {
            if (row + dir_x * k < 0 || col + dir_y * k < 0 || row + dir_x * k >= 6 || col + dir_y * k >= 7)
                return false;
            if (flag[row + dir_x * k][col + dir_y * k] != statusg)
                return false;

        }
        return true;
    }

    public int k = 0;

    public void computer_Turn(int x, int y) {
        k++;//chance
        if (x <= 3 && k >= 3) {
            int ch = 0;
            for (int i = x + 1; i < x + 3; i++) {
                if (flag[i][y] == 2) {
                    ch = 1;
                    break;
                }

            }
            if (ch == 0) {
                flag[x + 1][y] = 2;
                ImageView v = (ImageView) findViewById(ids[x + 1][y]);
                v.setImageResource(R.drawable.yellow);
            } else
                play(x, y);

        } else {
            if (y <= 3) {
                if (flag[x][y + 1] == 0) {
                    if (x <= 4 && flag[x + 1][y + 1] == 0)
                        play(x, y);
                    else {
                        flag[x][y + 1] = 2;
                        ImageView v = (ImageView) findViewById(ids[x][y + 1]);
                        v.setImageResource(R.drawable.yellow);
                    }
                } else
                    play(x, y);
            } else {
                if (flag[x][y - 1] == 0) {
                    if (x <= 4 && flag[x + 1][y - 1]== 0)
                        play(x, y);
                    else {
                        flag[x][y - 1] = 2;
                        ImageView v = (ImageView) findViewById(ids[x][y - 1]);
                        v.setImageResource(R.drawable.yellow);
                    }
                } else
                    play(x, y);

            }
        }


    }

    public void play(int m, int n) {
        int ch_done=0;
        if (therepossibleIsAWinner()) {
            if (flag[cu_row][cu_col] == 0 && flag[cu_row + 1][cu_col] != 0) {
                ImageView v = (ImageView) findViewById(ids[cu_row][cu_col]);
                v.setImageResource(R.drawable.yellow);
                ch_done=1;
            }

        }
        else{
             while(ch_done!=1){
                 int a= random.nextInt(6);
                 int b= random.nextInt(7);
                 if(flag[a][b]==0)
                 {
                       if(a<=4){
                           if(flag[a+1][b]==0) {
                                  ImageView v = (ImageView) findViewById(ids[a][b]);
                                  v.setImageResource(R.drawable.yellow);
                                ch_done = 1;
                           }
                       }
                     else{
                           ImageView v = (ImageView) findViewById(ids[a][b]);
                           v.setImageResource(R.drawable.yellow);
                           ch_done = 1;
                       }
                 }

             }
        }

    }

}




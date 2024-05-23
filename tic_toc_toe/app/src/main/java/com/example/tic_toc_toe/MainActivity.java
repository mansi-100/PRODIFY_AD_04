package com.example.tic_toc_toe;

import static java.util.logging.Logger.global;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView2,textView3;
    Button[] button=new Button[9];
Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12;

boolean playeroneActive=true;
boolean playerTwoActive=true;

int[] defaultState={2,2,2,2,2,2,2,2,2};
int[][] positions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };
int moveCount=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView2=findViewById(R.id.textView2);

        button[0]=findViewById(R.id.button1);
        button[1]=findViewById(R.id.button2);
        button[2]=findViewById(R.id.button3);
        button[3]=findViewById(R.id.button4);
        button[4]=findViewById(R.id.button5);
        button[5]=findViewById(R.id.button6);
        button[6]=findViewById(R.id.button7);
        button[7]=findViewById(R.id.button8);
        button[8]=findViewById(R.id.button9);
        textView3=findViewById(R.id.textView3);

        for(int i=0;i<button.length;i++){
            int finalI = i;
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    String buttonid=view.getResources().getResourceEntryName(view.getId());//button5 full store so extract val
                    if (defaultState[finalI] == 2) {
                         moveCount++;
                         Log.e("move count ", String.valueOf(moveCount));
                        if(playeroneActive){
                            button[finalI].setText("0");
                            defaultState[finalI]=0; //0 set kro player 1 e kai press kryu to em
                            playeroneActive=false;
                            playerTwoActive=true;

                        }
                        else{
                            button[finalI].setText("X");
                            defaultState[finalI]=1;
                            playeroneActive=true;
                            playerTwoActive=false;

                        }
                    }
                    boolean winner=false;
                    boolean nowinner=false;

                    for(int[] position:positions){ //position mthi common posi mde to em
                        int pos1=position[0];
                        int pos2=position[1];
                        int pos3=position[2];

                        if (defaultState[pos1] == defaultState[pos2] && defaultState[pos2] == defaultState[pos3] && defaultState[pos1] != 2)  //0 1 2 state set krya eni condition 6
                        {
                           winner=true;
                            break;
                        }
                    }
                    if(winner){
                        String active="";
                        if(playeroneActive){
                           active="Player-2";
                            textView2.setText(active + " wins !");

                        }
                        else if(playerTwoActive){
                            active="Player-1";
                            textView2.setText(active + " wins !");

                        }
                    }
                    else if (moveCount == 9) {
                        textView2.setText("No winner!");
                    }

                }

            });
        }


        button11=findViewById(R.id.button11);//play again btn
        button12=findViewById(R.id.button12);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playeroneActive=true;
                for(int i=0;i<button.length;i++){
                    defaultState[i]=2;
                    button[i].setText("");
                    textView2.setText("");
                    textView3.setText("Play Again Your Game  !");
                    moveCount=0;


                }
            }
        });

        //reset button
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playeroneActive=true;
                for(int i=0;i<button.length;i++){
                    defaultState[i]=2;
                    button[i].setText("");
                    textView2.setText("");
                    textView3.setText("Game Resetted Successfully  !");
                    moveCount=0;


                }
            }
        });

    }
}
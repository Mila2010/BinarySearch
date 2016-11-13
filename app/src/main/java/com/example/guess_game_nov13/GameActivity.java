package com.example.guess_game_nov13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements ViewGroup.OnClickListener{

    Button mHigher;
    Button mLower;
    TextView mGuess;
    Activity mActivity= this;

    static  int mMax=10000;
    static int mMin=0;
    int[] mNumArray=new int[mMax];
   final String TAG ="com.example.guess_game_nov13";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initViews();

        initArray(mNumArray,mMax-1);

        mGuess.setText(Integer.toString(mNumArray[(mMax+mMin)/2]));


    }

    public void initViews(){

        mHigher=(Button) findViewById(R.id.higher);
        mLower=(Button) findViewById(R.id.lower);
        mGuess=(TextView ) findViewById(R.id.guess);
        mHigher.setOnClickListener(this);
        mLower.setOnClickListener(this);

    }


    public void initArray(int[] array, int range){

        for(int i=0;i<range;i++){
            array[i]=i;
        }

    }

    public void handleOutOfRange()
    {
        mMax=10000;
        mMin=0;
        mGuess.setText("Not in the given range");
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent =new Intent(mActivity, MainActivity.class);
                startActivity(intent);

            }
        }, 2000);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.higher:
                if(mMax>mMin){
                mMin=(mMax+mMin)/2+1;
                mGuess.setText(Integer.toString(mNumArray[(mMax+mMin)/2]));}
                else {

                  handleOutOfRange();

                }

                Toast.makeText(this,"It's working",Toast.LENGTH_SHORT).show();
                break;
            case R.id.lower:
                if(mMax>mMin){

                mMax=(mMax+mMin)/2-1;
                mGuess.setText(Integer.toString(mNumArray[(mMax+mMin)/2]));}
                else {
                    handleOutOfRange();

                }
                Toast.makeText(this,"It's working",Toast.LENGTH_SHORT).show();
                break;
        }



    }

}

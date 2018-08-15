package com.example.vedantgote.quizapp;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class Q1 extends AppCompatActivity {
    TextView n,q,a1,a2,a3,a4,t;
    MyCT mct;
    int it=1,r=0,w=0;
    String qs[]={"How many runs did Sir Don Bradman need in his last innings to have a career avg of 100?",
            "Who was the 400th wicket of Harbhajan Singh?",
             "How many runs was Rahul Dravid short of a century on debut?",
               "Which fast bowler has the highest wickets in ODIs? "};
    ArrayList<String []> ans;

          String as1[]={"4","Michael Clarke","10,","Glenn McGrath"},
            as2[]={"102","Darren Bravo","4","Chaminda Vaas"},
            as3[]={"43","Darren Bough","6","Wasim Akram"},
            as4[]={"22","ABD","8","Shaun Pollock"},
            ca[]={"K. Yadav","4","Darren Bough","4","Wasim Akram"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        n=(TextView)findViewById(R.id.nm);
        q=(TextView)findViewById(R.id.qn);
        a1=(TextView)findViewById(R.id.an1);
        a2=(TextView)findViewById(R.id.an2);
        a3=(TextView)findViewById(R.id.an3);
        a4=(TextView)findViewById(R.id.an4);
        t=(TextView)findViewById(R.id.tim);
        ans= new ArrayList<String []>();
        ans.add(as1);
        ans.add(as2);
        ans.add(as3);
        ans.add(as4);

        mct = new MyCT(10000,1000);
        mct.start();
    }
    public void change()
    {
        a1.setEnabled(true);
        a2.setEnabled(true);
        a3.setEnabled(true);
        a4.setEnabled(true);

        a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shp));
        a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shp));
        a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shp));
        a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shp));

        n.setText(Integer.toString(it));
       q.setText(qs[it-2]);
        a1.setText(ans.get(0)[it-2]);
        a2.setText(ans.get(1)[it-2]);
        a3.setText(ans.get(2)[it-2]);
        a4.setText(ans.get(3)[it-2]);
        mct.start();

    }

    public void onClick(View view)
    {
      int i = view.getId();
      if(it<6)
      {
      if(((TextView)findViewById(i)).getText().toString()==ca[it-1])
      {
          ((TextView)findViewById(i)).setBackgroundColor(Color.GREEN);
          new CountDownTimer(2000,1000){
              @Override
              public void onTick(long millisUntilFinished) {
              }

              @Override
              public void onFinish() {
                  mct.cancel();
                  it++;
                  change();
              }
          }.start();
      }
      else
      {
          w++;
          ((TextView)findViewById(i)).setBackgroundColor(Color.RED);
          new CountDownTimer(1000,1000){
              @Override
              public void onTick(long millisUntilFinished) {
              }

              @Override
              public void onFinish() {
                  mct.cancel();
                  it++;
                  change();
              }
      }.start();
    }
          Toast.makeText(this,Integer.toString(r)+" right and " +Integer.toString(w)+ " wrong",Toast.LENGTH_LONG).show();}
    }


    public class MyCT extends CountDownTimer{
        public MyCT(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int tmr =(int)(millisUntilFinished/1000);
            t.setText(Integer.toString(tmr));
        }

        @Override
        public void onFinish() {
            it++;

            if(it<6)
            {
            t.setText("TIME IS UP!!");
            a1.setEnabled(false);
            a2.setEnabled(false);
            a3.setEnabled(false);
            a4.setEnabled(false);
            change();
        }
        else {
        finish();}
        }

    }



}

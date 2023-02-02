package com.example.stop_watch_task_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    ImageButton btnstrart, btnstop;

    private  boolean isresume;
    Handler handler;
    long tmillisec,tstart,tbuff,tupdate = 0L;
    int sec,min,millisec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer=findViewById(R.id.chronometer);
        btnstrart=findViewById(R.id.start);
        btnstop=findViewById(R.id.stop);

        handler=new Handler();

        btnstrart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isresume){
                    tstart=SystemClock.uptimeMillis();
                    handler.postDelayed(runnable,0);
                    chronometer.start();
                    isresume = true;
                    btnstop.setVisibility(View.GONE);
                    btnstrart.setImageDrawable(getResources().getDrawable (
                            R.drawable.ic_baseline_pause_24
                    ));
                }else{
                    tbuff+= tmillisec;
                    handler.removeCallbacks(runnable);
                    chronometer.stop();
                    isresume =false;
                    btnstop.setVisibility(View.VISIBLE);
                    btnstrart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_baseline_play_arrow
                    ));
                }
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isresume){
                    btnstrart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_baseline_play_arrow
                    ));
                    tmillisec = 0L;
                    tstart = 0L;
                    tbuff = 0L;
                    tupdate = 0L;
                    sec= 0;
                    min= 0;
                    millisec = 0;
                    chronometer.setText("00:00:00");

                }
            }
        });
    }
    public  Runnable runnable= new Runnable() {
        @Override
        public void run() {
            tmillisec= SystemClock.uptimeMillis()-tstart;
            tupdate=tbuff+tmillisec;
            sec=(int)(tupdate/1000);
            min=sec/60;
            sec=sec%60;
            millisec=(int)(tupdate % 100);
            chronometer.setText(String.format("%02d",min)+":"
            +String.format("%02d",sec)+":"+String.format("%02d",millisec));
            handler.postDelayed(this, 60);
        }
    };
}
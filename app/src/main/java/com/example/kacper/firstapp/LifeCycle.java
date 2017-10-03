package com.example.kacper.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Timestamp;

public class LifeCycle extends Activity {

    private String log;
    private Button goToFirstViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        goToFirstViewBtn=findViewById(R.id.goToFirstViewBtn);
        goToFirstViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFirstView(view);
            }
        });
        updateLogView("onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();

        updateLogView("onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();

        updateLogView("onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();

        updateLogView("onPause");
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        updateLogView("onRestart");
    }

    @Override
    protected void onStop(){
        super.onStop();

        updateLogView("onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        updateLogView("onDestroy");
    }

    private boolean addLog(String type){
        StringBuilder newLine = new StringBuilder();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        boolean returnValue;

        try{
            if(log!=null)
                newLine.append(log + "\n");

            newLine.append("[" + time.toString() + "] " + "[" +type + "]");
            log = newLine.toString();
            returnValue = true;

        }catch(Exception e){
            returnValue = false;
        }

        return returnValue;
    }

    private void updateLogView(String type){
        TextView cyclesViewResult = findViewById(R.id.cycleList);

        if(addLog(type) && log != null){
            cyclesViewResult.setText(log);
        }
    }

    public void goToFirstView(View view){
        Intent firstView = new Intent(this, MainActivity.class);

        startActivity(firstView);
    }
}

package com.example.kacper.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ResultOfMainActivity extends Activity {

    private Intent mainActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_main);

        mainActivityIntent = getIntent();

        getDataFromMainActivity();
    }

    private void getDataFromMainActivity(){
        String name = mainActivityIntent.getStringExtra(MainActivity.NAME_TEXT);
        TextView nameResult = findViewById(R.id.nameResult);
        if(name!=null && name!=""){
            nameResult.setText("Your name is " + name);
        }else{
            nameResult.setText("You didn't give your name");
        }

        boolean doYouLikeFootball = mainActivityIntent.getBooleanExtra(MainActivity.DO_YOU_LIKE_FOOTBALL, false);
        TextView likeFootballResult = findViewById(R.id.doYouLikeFootballResult);
        if(doYouLikeFootball){
            likeFootballResult.setText("You like football");
        }else{
            likeFootballResult.setText("You don't like football");
        }

        String bestPlayer = mainActivityIntent.getStringExtra(MainActivity.BEST_PLAYER);
        TextView bestPlayerResult = findViewById(R.id.bestPlayerResult);
        if(bestPlayer!=null){
            bestPlayerResult.setText("Your best player is " + bestPlayer);
        }else{
            bestPlayerResult.setText("You don't selected the best player");
        }

        boolean areYouPlayer = mainActivityIntent.getBooleanExtra(MainActivity.DO_YOU_PLAY, false);
        TextView areYouPlayerResult = findViewById(R.id.areYouPlayerResult);
        if(areYouPlayer){
            areYouPlayerResult.setText("You are football player");
        }else{
            areYouPlayerResult.setText("You aren't football player");
        }

        float yourSkills = mainActivityIntent.getFloatExtra(MainActivity.YOUR_SKILLS, 0);
        TextView yourSkillsResult = findViewById(R.id.yourSkillsResult);
        yourSkillsResult.setText("Your skills: " + String.valueOf(yourSkills));

        boolean onOff = mainActivityIntent.getBooleanExtra(MainActivity.ON_OFF,false);
        TextView onOffResult = findViewById(R.id.onOffResult);
        if(onOff){
            onOffResult.setText("You set ON in previous layout");
        }else{
            onOffResult.setText("You set OFF in previous layout");
        }
    }

    public void goToMainActivity(View view){
        Intent mainIntent = new Intent(this, MainActivity.class);

        startActivity(mainIntent);
    }

    public void goToCyclesView(View view){
        Intent cyclesIntent = new Intent(this, LifeCycle.class);

        startActivity(cyclesIntent);
    }

}

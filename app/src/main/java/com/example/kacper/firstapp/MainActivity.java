package com.example.kacper.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    public static final String NAME_TEXT = "com.example.kacper.firstapp.MainActivity.NAME_TEXT";
    public static final String DO_YOU_LIKE_FOOTBALL = "com.example.kacper.firstapp.MainActivity.DO_YOU_LIKE_FOOTBALL";
    public static final String BEST_PLAYER = "com.example.kacper.firstapp.MainActivity.BEST_PLAYER";
    public static final String DO_YOU_PLAY = "";
    public static final String YOUR_SKILLS = "";
    public static final String ON_OFF = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view){
        EditText nameText = findViewById(R.id.nameText);
        String nameString;
        try{
            nameString = nameText.getText().toString();
        }catch(Exception e){
            nameString = "You didn't give your name";
        }


        CheckBox doYouLikeFootballCheckBox = findViewById(R.id.doYouPlay);
        boolean likeFootball;
        try{
            likeFootball = doYouLikeFootballCheckBox.isChecked();
        }catch (Exception e){
            likeFootball = false;
        }


        RadioGroup bestPlayerRadioGroup = findViewById(R.id.bestFootballPlayer);
        int bestPlayer;
        RadioButton bestPlayerRadioButton;
        String nameOfBestPlayer;
        try{
            bestPlayer = bestPlayerRadioGroup.getCheckedRadioButtonId();
            bestPlayerRadioButton = findViewById(bestPlayer);
            nameOfBestPlayer = String.valueOf(bestPlayerRadioButton.getText());
        }catch (Exception e){
            nameOfBestPlayer = "You don't selected the best player";
            nameOfBestPlayer = null;
        }


        Switch doYouPlaySwitch = findViewById(R.id.areYouPlayerQuestion);
        boolean playerSwitchValue = doYouPlaySwitch.isChecked();

        RatingBar yourSkillsRatingBar = findViewById(R.id.yourSkills);
        float yourSkillsValue = yourSkillsRatingBar.getRating();

        ToggleButton onOffButton = findViewById(R.id.onOff);
        boolean onOffButtonValue = onOffButton.isChecked();

        Intent nextActivityIntent = new Intent(this, ResultOfMainActivity.class);

        nextActivityIntent.putExtra(NAME_TEXT, nameString);
        nextActivityIntent.putExtra(DO_YOU_LIKE_FOOTBALL, likeFootball);
        nextActivityIntent.putExtra(BEST_PLAYER, nameOfBestPlayer);
        nextActivityIntent.putExtra(DO_YOU_PLAY, playerSwitchValue);
        nextActivityIntent.putExtra(YOUR_SKILLS, yourSkillsValue);
        nextActivityIntent.putExtra(ON_OFF, onOffButtonValue);

        startActivity(nextActivityIntent);
    }
}
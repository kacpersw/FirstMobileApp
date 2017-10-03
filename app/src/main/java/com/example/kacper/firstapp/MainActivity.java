package com.example.kacper.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    public static final String DO_YOU_PLAY = "com.example.kacper.firstapp.MainActivity.DO_YOU_PLAY";
    public static final String YOUR_SKILLS = "com.example.kacper.firstapp.MainActivity.YOUR_SKILLS";
    public static final String ON_OFF = "com.example.kacper.firstapp.MainActivity.ON_OFF";

    private Button nextViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextViewBtn = findViewById(R.id.sendDataBtn);
        nextViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(view);
            }
        });

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
        }


        Switch doYouPlaySwitch = findViewById(R.id.areYouPlayerQuestion);
        boolean playerSwitchValue;
        try{
            playerSwitchValue = doYouPlaySwitch.isChecked();
        }catch(Exception e){
            playerSwitchValue = false;
        }


        RatingBar yourSkillsRatingBar = findViewById(R.id.yourSkills);
        float yourSkillsValue;
        try{
            yourSkillsValue = yourSkillsRatingBar.getRating();
        }catch(Exception e){
            yourSkillsValue = 0;
        }

        ToggleButton onOffButton = findViewById(R.id.onOff);
        boolean onOffButtonValue;
        try{
            onOffButtonValue = onOffButton.isChecked();
        }catch(Exception e){
            onOffButtonValue = false;
        }

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

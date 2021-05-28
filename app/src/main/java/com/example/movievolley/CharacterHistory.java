package com.example.movievolley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CharacterHistory extends AppCompatActivity {
    TextView name, hight, haircolor, skincolor, eyecolor, gender, mass, birthyear;
    CharecterDetails charecterDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        Intent intent = getIntent();
        charecterDetails = (CharecterDetails) intent.getParcelableExtra("Data");
        name = findViewById(R.id.name);
        hight = findViewById(R.id.hight);
        haircolor = findViewById(R.id.haircolor);
        skincolor = findViewById(R.id.skincolor);
        eyecolor = findViewById(R.id.eyecolor);
        gender = findViewById(R.id.gender);
        mass = findViewById(R.id.mass);
        birthyear = findViewById(R.id.birth_year);
        String username = charecterDetails.getName();
        String hightt = charecterDetails.getHeight();
        String haircolorr = charecterDetails.getHairColor();
        String skincolorr = charecterDetails.getSkinColor();
        String eyecolorr = charecterDetails.getEyeColor();
        String genderr = charecterDetails.getGender();
        String masss = charecterDetails.getMass();
        String birthyearr = charecterDetails.getBirthYear();

        name.setText("Name:  " + username);
        hight.setText("Hight:  " + hightt);
        haircolor.setText("Hair Color:  " + haircolorr);
        skincolor.setText("Skin Color:  " + skincolorr);
        eyecolor.setText("Eye Color:  " + eyecolorr);
        gender.setText("Gender:  " + genderr);
        mass.setText("Mass:  " + masss);
        birthyear.setText("Birth Year:  " + birthyearr);
    }
}
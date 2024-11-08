package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ChoseExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_exercise);

        // Initialize UI components for buttons and exercise layouts
        Button chestButton = findViewById(R.id.chestButton);
        Button backButton = findViewById(R.id.backButton);
        Button handsButton = findViewById(R.id.handsButton);
        Button legsButton = findViewById(R.id.legsButton);
        Button backButtons = findViewById(R.id.backButtons);

        LinearLayout chestExercisesLayout = findViewById(R.id.chestExercisesLayout);
        LinearLayout backExercisesLayout = findViewById(R.id.backExercisesLayout);
        LinearLayout handsExercisesLayout = findViewById(R.id.handsExercisesLayout);
        LinearLayout legsExercisesLayout = findViewById(R.id.legsExercisesLayout);

        // Set up click listeners for buttons to toggle visibility of corresponding exercise layouts
        chestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleVisibility(chestExercisesLayout);
                backExercisesLayout.setVisibility(View.GONE);
                handsExercisesLayout.setVisibility(View.GONE);
                legsExercisesLayout.setVisibility(View.GONE);


            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleVisibility(backExercisesLayout);
                chestExercisesLayout.setVisibility(View.GONE);
                handsExercisesLayout.setVisibility(View.GONE);
                legsExercisesLayout.setVisibility(View.GONE);
            }
        });

        handsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleVisibility(handsExercisesLayout);
                backExercisesLayout.setVisibility(View.GONE);
                chestExercisesLayout.setVisibility(View.GONE);
                legsExercisesLayout.setVisibility(View.GONE);
            }
        });

        legsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleVisibility(legsExercisesLayout);
                backExercisesLayout.setVisibility(View.GONE);
                handsExercisesLayout.setVisibility(View.GONE);
                chestExercisesLayout.setVisibility(View.GONE);
            }
        });
        // Set up click listener for "Back" button to navigate back to UserData activity
        backButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate back to the UserData activity
                Intent intent = new Intent(ChoseExercise.this, UserData.class);
                startActivity(intent);
                finish();  // Optional: This will close the current activity and prevent it from being added to the back stack
            }
        });


    }

    // Utility function to toggle visibility between VISIBLE and GONE
    private void toggleVisibility(LinearLayout layout) {
        if (layout.getVisibility() == View.GONE) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }
}

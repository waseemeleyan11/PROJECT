package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        // Initialize UI components
        EditText ageEditText = findViewById(R.id.age);
        EditText weightEditText = findViewById(R.id.weight);
        EditText lengthEditText = findViewById(R.id.length);
        Spinner activityLevelSpinner = findViewById(R.id.activityLevelSpinner);
        Button calculateButton = findViewById(R.id.calculateButton);
        Button exerciseButton = findViewById(R.id.exercise);  // Find Exercise button
        TextView caloriesResultTextView = findViewById(R.id.caloriesResult);
        TextView proteinResultTextView = findViewById(R.id.proteinResult);

        // Load the activity levels from the resources
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activity_levels, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        activityLevelSpinner.setAdapter(adapter);

        // Set up the button click listener
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input and check for empty fields
                String ageText = ageEditText.getText().toString().trim();
                String weightText = weightEditText.getText().toString().trim();
                String lengthText = lengthEditText.getText().toString().trim();

                // Check if any of the fields are empty
                if (ageText.isEmpty() || weightText.isEmpty() || lengthText.isEmpty()) {
                    // Display an error message if any field is empty
                    Toast.makeText(UserData.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Parse input values
                    int age = Integer.parseInt(ageText);
                    double weight = Double.parseDouble(weightText);
                    double length = Double.parseDouble(lengthText);
                    String activityLevel = activityLevelSpinner.getSelectedItem().toString();

                    // Calculate basic calorie needs (Mifflin-St Jeor formula for males)
                    double bmr = 10 * weight + 6.25 * length - 5 * age + 5;
                    double calories = bmr * getActivityMultiplier(activityLevel);
                    double protein = weight * 2;  // Protein calculation example

                    // Display the results
                    caloriesResultTextView.setText("Calories: " + calories);
                    proteinResultTextView.setText("Protein: " + protein + " grams");
                }
            }

        });
        // Set up the exercise button click listener
        exerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ChoseExercise activity
                Intent intent = new Intent(UserData.this, ChoseExercise.class);
                startActivity(intent);
            }
        });
    }



// Helper function to get the multiplier based on activity level
    private double getActivityMultiplier(String activityLevel) {
        switch (activityLevel) {
            case "No exercise":
                return 1.2;
            case "Exercise from 1-3 times a week":
                return 1.375;
            case "Exercise from 3-5 times a week":
                return 1.55;
            case "Exercise from 5-7 times a week":
                return 1.725;
            default:
                return 1.0;
        }
    }
}

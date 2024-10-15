package com.mobdeve.mc02.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.mc02.R;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    // Variables to store registered credentials
    private String registeredEmail;
    private String registeredPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize the EditTexts
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        // Initialize the Login button
        Button loginButton = findViewById(R.id.loginButton);

        // Initialize the Back button
        Button backButton = findViewById(R.id.backButton);

        // Retrieve registered credentials from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        registeredEmail = sharedPreferences.getString("REGISTERED_EMAIL", null);
        registeredPassword = sharedPreferences.getString("REGISTERED_PASSWORD", null);

        // Set onClickListener for login button
        loginButton.setOnClickListener(this::loginUser);

        // Set onClickListener for back button
        backButton.setOnClickListener(this::goBackToIntro);
    }

    // This method handles user login
    public void loginUser(View view) {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Validate the inputs
        if (isValidCredentials(username, password)) {
            // Navigate to MainActivity after successful login
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Optionally finish LoginActivity
        } else {
            // Show error message for login failure
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    // This method handles going back to the IntroActivity
    public void goBackToIntro(View view) {
        Intent intent = new Intent(LoginActivity.this, IntroActivity.class);
        startActivity(intent);
        finish(); // Finish LoginActivity to prevent going back to it
    }

    // Validation logic using the registered credentials
    private boolean isValidCredentials(String username, String password) {
        // Check if registeredEmail and registeredPassword exist and match the input
        return registeredEmail != null && registeredPassword != null
                && username.equals(registeredEmail) && password.equals(registeredPassword);
    }
}

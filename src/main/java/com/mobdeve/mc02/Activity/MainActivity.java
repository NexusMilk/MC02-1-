package com.mobdeve.mc02.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.mobdeve.mc02.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ConstraintLayout btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TaskListActivity.class)));
        
        ConstraintLayout plannerButton = findViewById(R.id.btn2);  // Assuming 'btn2' is the Planner button's ID
        plannerButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PlannerActivity.class)));
    }
}

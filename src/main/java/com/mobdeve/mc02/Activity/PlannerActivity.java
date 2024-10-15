package com.mobdeve.mc02.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import com.mobdeve.mc02.R;

public class PlannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        // Set up floating action button click listener
        FloatingActionButton fabAddTask = findViewById(R.id.fab_add_task);
        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to AddTaskActivity or show task creation dialog
                Intent intent = new Intent(PlannerActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}

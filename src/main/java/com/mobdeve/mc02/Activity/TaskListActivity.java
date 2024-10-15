package com.mobdeve.mc02.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mobdeve.mc02.Adapter.TaskAdapter;
import com.mobdeve.mc02.Domain.TaskDomain;
import com.mobdeve.mc02.R;


import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTaskList;
    private RecyclerView recyclerViewCourse;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        backButton = findViewById(R.id.imageViewBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<TaskDomain> items = new ArrayList<>();
        items.add(new TaskDomain("Make the project", "ic_1"));
        items.add(new TaskDomain("Check the deadlines", "ic_2"));
        items.add(new TaskDomain("Study @ 9am", "ic_3"));
        items.add(new TaskDomain("CCPROG2 Assignment", "ic_4"));
        items.add(new TaskDomain("Read Chapter 119 of Discrete Mathematics", "ic_5"));
        items.add(new TaskDomain("Eat something ", "ic_1"));
        items.add(new TaskDomain("Meeting @ 5pm ", "ic_2"));

        recyclerViewCourse = findViewById(R.id.recyclerViewCourse);
        recyclerViewCourse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterTaskList = new TaskAdapter(items);
        recyclerViewCourse.setAdapter(adapterTaskList);
    }
}

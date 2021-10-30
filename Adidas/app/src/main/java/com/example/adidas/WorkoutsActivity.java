package com.example.adidas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutsActivity extends AppCompatActivity {

    ListView listView;
    private WorkoutsAdapter workoutsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.workoutsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GUIDED WORKOUTS");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        listView = findViewById(R.id.listView_Workouts);
        workoutsAdapter = new WorkoutsAdapter(getWorkouts());
        listView.setAdapter(workoutsAdapter);


    }

    private List<Model> getWorkouts() {
        List<Model> lista = new ArrayList<>();
        lista.add(new Model(25, "Advanced", "Upper Body HIIT", R.drawable.workout3_img, new String[]{"Abs & Core", "Upper Body"}));
        lista.add(new Model(8, "Beginner", "Stretch & Mobility", R.drawable.workout2_img, new String[]{"Abs & Core", "Full Body"}));
        lista.add(new Model(12, "Intermediate", "Progressive Workout", R.drawable.workout1_img, new String[]{"Abs & Core", "Arms"}));
        lista.add(new Model(15, "Advanced", "Full Body with Weights", R.drawable.workout4_img, new String[]{"Abs & Core", "Arms"}));
        return lista;
    }
}
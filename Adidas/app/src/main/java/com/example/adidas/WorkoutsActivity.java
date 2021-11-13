package com.example.adidas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

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
        List<Model> workoutList = getWorkouts();
        workoutsAdapter = new WorkoutsAdapter(workoutList);
        listView.setAdapter(workoutsAdapter);

        JSONReader reader = new JSONReader();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reader.read("https://jsonkeeper.com/b/3YUL", new IResponse() {
                    @Override
                    public void onSucces(List<Model> workouts) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                Toast.makeText(WorkoutsActivity.this, workouts.toString(), Toast.LENGTH_LONG).show();
                                List<Model> newList = new ArrayList<>();
                                newList.addAll(workoutList);
                                newList.addAll(workouts);
                                workoutsAdapter.updateList(newList);
                            }
                        });
                    }

                    @Override
                    public void onError(String mesaj) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(WorkoutsActivity.this, mesaj, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
            }
        });
        thread.start();
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
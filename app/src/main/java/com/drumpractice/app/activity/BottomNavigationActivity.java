package com.drumpractice.app.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.drumpractice.app.exercise.ExerciseFragment;
import com.drumpractice.app.exercise_list.ExerciseListFragment;
import com.piotrklis.drumpractice.R;

public class BottomNavigationActivity extends AppCompatActivity {

    private TextView textMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_exercise:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, new ExerciseFragment())
                            .commit();

                    Toast.makeText(getApplicationContext(), "Exercise Screen", Toast.LENGTH_SHORT).show();
                    ExerciseFragment.newInstance();
                    return true;
                case R.id.navigation_list_of_exercises:
                    Toast.makeText(getApplicationContext(), "List Screen", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, new ExerciseListFragment())
                            .commit();
                    return true;
                case R.id.navigation_settings:
                    Toast.makeText(getApplicationContext(), "Settings Screen", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        int firstScreenId = R.id.navigation_exercise;
        navigation.setOnNavigationItemSelectedListener(navigationListener);


    }
}

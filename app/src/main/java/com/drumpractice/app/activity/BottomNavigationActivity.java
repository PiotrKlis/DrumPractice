package com.drumpractice.app.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.drumpractice.app.exercise.ExerciseFragment;
import com.drumpractice.app.exercise_list.ExerciseListFragment;
import com.piotrklis.drumpractice.R;

public class BottomNavigationActivity extends AppCompatActivity {

    public static final int INITIAL_FRAGMENT = R.id.navigation_exercise;

    private boolean changeFragment(int id) {
        switch (id) {
            case R.id.navigation_exercise:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new ExerciseFragment())
                        .commit();
                return true;
            case R.id.navigation_list_of_exercises:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new ExerciseListFragment())
                        .commit();
                return true;
            case R.id.navigation_settings:
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(item -> changeFragment(item.getItemId()));

        renderInitialFragment();
    }

    private void renderInitialFragment() {
        changeFragment(INITIAL_FRAGMENT);
    }
}

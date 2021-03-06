package com.drumpractice.app.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.drumpractice.app.exercise.ExerciseFragment;
import com.drumpractice.app.exercise_list.ExerciseListFragment;
import com.piotrklis.drumpractice.R;

public class BottomNavigationActivity extends AppCompatActivity {

    public static final int INITIAL_FRAGMENT = R.id.navigation_exercise;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, BottomNavigationActivity.class);
        context.startActivity(intent);
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

    private boolean changeFragment(int id) {
        switch (id) {
            case R.id.navigation_exercise:
                navigateToFragment(new ExerciseFragment());
                return true;
            case R.id.navigation_list_of_exercises:
                navigateToFragment(new ExerciseListFragment());
                return true;
            case R.id.navigation_settings:
                return true;
            default:
                return false;
        }
    }

    private void navigateToFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}

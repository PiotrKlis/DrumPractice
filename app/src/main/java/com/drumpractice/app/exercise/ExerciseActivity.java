package com.drumpractice.app.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.piotrklis.drumpractice.R;

public class ExerciseActivity extends AppCompatActivity {

    private static final String TAG = "ExerciseFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        ExcerciseFragment exerciseFragment;

        if (savedInstanceState == null) {
            exerciseFragment = new ExcerciseFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, exerciseFragment, TAG)
                    .commit();
        }
    }
}

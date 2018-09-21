package com.drumpractice.app.exercise;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.piotrklis.drumpractice.R;

public class ExerciseActivity extends AppCompatActivity {

    private static final String TAG = "ExerciseFragment";

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ExerciseActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new ExerciseFragment(), TAG)
                    .commit();
        }
    }
}

package com.drumpractice.app.exercise_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.piotrklis.drumpractice.R;

public class ExerciseListActivity extends AppCompatActivity {

    private static final String TAG = "ExerciseListFragment";

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ExerciseListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new ExerciseListFragment(), TAG)
                    .commit();
        }
    }
}

package com.piotrklis.drumpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExerciseActivity extends AppCompatActivity {

    private View view;

    @BindView(R.id.editText_main_overallTime)
    protected EditText overallTime;
    @BindView(R.id.textView_main_exercisesDone)
    protected TextView exercisesDone;
    @BindView(R.id.textView_main_nextExerciseName)
    protected TextView nextExerciseName;
    @BindView(R.id.textView_main_currentExerciseName)
    protected TextView currentExerciseName;
    @BindView(R.id.editText_main_timeLeft)
    protected EditText timeLeft;
    @BindView(R.id.imageView_main_exercise)
    protected ImageView image;
    @BindView(R.id.imageButton_main_power)
    protected ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        view = new ExcerciseView(this);
        setContentView(view);

        ExerciseSet exerciseSet = loadExercise();
        showExercise(exerciseSet);
    }

    private ExerciseSet loadExercise() {
        List<ExerciseSet> exercisesLocalSources = new ExercisesLocalSource().getListOfExercises();
        ExerciseSet currentExerciseSet = exercisesLocalSources.get(0);
        showExercise(currentExerciseSet);
        return null;
    }

    private void showExercise(ExerciseSet exerciseSet) {
        ExerciseSet set = exerciseSet;

        //overallTime.setText(set.get);
    }


}

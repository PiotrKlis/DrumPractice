package com.piotrklis.drumpractice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

//import com.mobileapps.pk.external.data.ExercisesLocalSource;
import com.piotrklis.drumpractice.R;
import com.piotrklis.drumpractice.model.Exercise;
import com.piotrklis.drumpractice.model.ExerciseSet;
import com.piotrklis.drumpractice.view.ExcerciseView;

import java.util.List;

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
//        ButterKnife.bind(this);
        view = new ExcerciseView(this);
        setContentView(view);

//        ExerciseSet exerciseSet = loadExerciseSet();
//        showExercise(exerciseSet);
    }

//    private ExerciseSet loadExerciseSet() {
////        List<ExerciseSet> exercisesLocalSources = new ExercisesLocalSource().getListOfExercises();
////        return exercisesLocalSources.get(0);
//
//    }

    private void showExercise(ExerciseSet exerciseSet) {
        ExerciseSet set = exerciseSet;
        String nameOfTheSet = set.getName();
        List<Exercise> exercises = set.getExercise();

        currentExerciseName.setText(nameOfTheSet);


        //overallTime.setText(set.get);
    }


}

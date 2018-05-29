package com.piotrklis.drumpractice;

import android.content.Context;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExcerciseView extends LinearLayout {

    @BindView(R.id.editText_main_overallTime)
    EditText overallTimeTimer;
    @BindView(R.id.textView_main_exercisesDone)
    TextView exercisesDoneCount;
    @BindView(R.id.textView_main_nextExerciseName)
    TextView nextExerciseName;
    @BindView(R.id.textView_main_currentExerciseName)
    TextView currentExerciseName;
    @BindView(R.id.editText_main_timeLeft)
    EditText timeLeftTimer;
    @BindView(R.id.imageView_main_exercise)
    ImageView exerciseImage;
    @BindView(R.id.imageButton_main_power)
    ImageButton powerButton;

    public ExcerciseView(Context context) {
        super(context);
        inflate(context, R.layout.linear_excercise_view, this);
        ButterKnife.bind(this);

    }


}

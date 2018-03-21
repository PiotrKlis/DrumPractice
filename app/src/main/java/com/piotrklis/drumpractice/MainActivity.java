package com.piotrklis.drumpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}

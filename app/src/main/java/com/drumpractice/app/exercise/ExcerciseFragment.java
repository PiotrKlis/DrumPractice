package com.drumpractice.app.exercise;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.piotrklis.drumpractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ExcerciseFragment extends Fragment {

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

    private Unbinder unbinder;
    private ExerciseComponent exerciseComponent;

    public static ExcerciseFragment newInstance() {
        return new ExcerciseFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createViewModel();
    }

    private ExerciseViewModel createViewModel() {
        return null;
    }
}

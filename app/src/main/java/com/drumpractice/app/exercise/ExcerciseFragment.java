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

import com.drumpractice.app.exercise_list.ExerciseSet;
import com.piotrklis.drumpractice.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

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

    private CompositeDisposable subscriptions = new CompositeDisposable();
    private Unbinder unbinder;
    private ExerciseComponent exerciseComponent;
    private ExerciseViewModel viewModel;

    public static ExcerciseFragment newInstance() {
        return new ExcerciseFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.linear_excercise_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createViewModel();
        bindViewModel();
    }

    private void bindViewModel() {
        subscriptions.dispose();
        subscriptions = new CompositeDisposable();
        subscriptions.add(viewModel.getExerciseSet().subscribe(this::renderExercise));
    }

    private ExerciseViewModel createViewModel() {
        return viewModel = DaggerExerciseComponent
                .builder()
                .build()
                .exerciseViewModel();
    }

    private void renderExercise(ExerciseSet exerciseSet) {
        ExerciseSet set = exerciseSet;
        String nameOfTheSet = set.getName();
        List<Exercise> exercises = set.getExercise();

    }
}

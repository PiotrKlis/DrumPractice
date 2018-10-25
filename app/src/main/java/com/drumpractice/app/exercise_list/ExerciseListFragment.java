package com.drumpractice.app.exercise_list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drumpractice.domain.model.ExerciseSet;
import com.piotrklis.drumpractice.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

public class ExerciseListFragment extends Fragment {

    private CompositeDisposable subscriptions = new CompositeDisposable();
    private ExerciseListViewModel viewModel;
    private Unbinder unbinder;

    public static ExerciseListFragment newInstance() {
        return new ExerciseListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exercise_list_view, container, false);
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
        subscriptions.add(viewModel
                .getExerciseSets()
                .subscribe(this::renderExerciseList));
    }

    private void renderExerciseList(List<ExerciseSet> exerciseSets) {
        List<ExerciseSet> exerciseSetList = exerciseSets;
        int i = 0;
    }

    private ExerciseListViewModel createViewModel() {
        return viewModel = DaggerExerciseListComponent
                .builder()
                .build()
                .exerciseListViewModel();
    }


}

package com.drumpractice.app.exercise;

import com.drumpractice.app.di.DrumPracticeAppComponent;

import dagger.Component;

@Component(dependencies = {DrumPracticeAppComponent.class})
public interface ExerciseComponent {

    ExerciseViewModel exerciseViewModel();
}

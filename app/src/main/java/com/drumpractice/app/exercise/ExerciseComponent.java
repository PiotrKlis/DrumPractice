package com.drumpractice.app.exercise;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.usecase.FetchExerciseSetUseCase;

import dagger.Component;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

@Component(modules = {ExerciseComponent.ExerciseModule.class})
public interface ExerciseComponent {

    ExerciseViewModel exerciseViewModel();

    @dagger.Module
    class ExerciseModule {

        @Provides
        FetchExerciseSetUseCase fetchExerciseSetUseCase(@NonNull final ExerciseSetRepository exerciseSetRepository) {
            return new FetchExerciseSetUseCase(exerciseSetRepository);
        }


    }
}

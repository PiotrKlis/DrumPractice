package com.drumpractice.app.exercise;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.usecase.FetchExerciseSetUseCase;
import com.drumpractice.external.repository.ExerciseSetLocalDataSource;
import com.drumpractice.external.repository.ExerciseSetRepositoryImpl;

import dagger.Component;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

@Component(modules = {ExerciseComponent.ExerciseModule.class})
public interface ExerciseComponent {

    ExerciseViewModel exerciseViewModel();

    @dagger.Module
    class ExerciseModule {

        @Provides
        ExerciseSetRepository exerciseSetRepository(ExerciseSetLocalDataSource exerciseSetLocalDataSource) {
            return new ExerciseSetRepositoryImpl(exerciseSetLocalDataSource);
        }

        @Provides
        FetchExerciseSetUseCase fetchExerciseSetUseCase(@NonNull final ExerciseSetRepository exerciseSetRepository) {
            return new FetchExerciseSetUseCase(exerciseSetRepository);
        }
    }
}

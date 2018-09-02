package com.drumpractice.app.exercise_list;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.usecase.FetchExerciseSetListUseCase;
import com.drumpractice.external.repository.ExerciseSetLocalDataSource;
import com.drumpractice.external.repository.ExerciseSetRepositoryImpl;

import dagger.Component;
import dagger.Provides;

@Component (modules = {ExerciseListComponent.ExerciseListModule.class})
public interface ExerciseListComponent {

    ExerciseListViewModel exerciseListViewModel();

    @dagger.Module
    class ExerciseListModule {

        @Provides
        FetchExerciseSetListUseCase fetchExerciseSetListUseCase(ExerciseSetRepository exerciseSetRepository) {
            return new FetchExerciseSetListUseCase(exerciseSetRepository);
        }

        @Provides
        ExerciseSetRepository exerciseSetRepository(ExerciseSetLocalDataSource exerciseSetLocalDataSource) {
            return new ExerciseSetRepositoryImpl(exerciseSetLocalDataSource);
        }

    }
}

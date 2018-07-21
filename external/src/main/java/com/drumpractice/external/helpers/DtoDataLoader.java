package com.drumpractice.external.helpers;

import com.drumpractice.external.dto.ExerciseSetDto;

import java.util.List;

import io.reactivex.Maybe;

public interface DtoDataLoader {
    Maybe<List<ExerciseSetDto>> loadExerciseSetsFromBundle();
}

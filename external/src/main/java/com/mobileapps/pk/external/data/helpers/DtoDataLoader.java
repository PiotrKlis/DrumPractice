package com.mobileapps.pk.external.data.helpers;

import com.mobileapps.pk.external.data.dto.ExerciseSetDto;

import java.util.List;

import io.reactivex.Maybe;

public interface DtoDataLoader {
    Maybe<List<ExerciseSetDto>> loadExerciseSetsFromBundle();
}

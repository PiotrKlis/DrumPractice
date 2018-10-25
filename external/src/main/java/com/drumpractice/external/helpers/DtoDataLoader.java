package com.drumpractice.external.helpers;

import com.drumpractice.external.dto.ExerciseSetDto;

import java.io.IOException;
import java.util.List;

import io.reactivex.Maybe;

public interface DtoDataLoader {
    List<ExerciseSetDto> loadExerciseSetsFromBundle() throws IOException;
}

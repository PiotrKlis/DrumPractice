package com.piotrklis.drumpractice;


import java.util.ArrayList;
import java.util.List;

public class ExercisesLocalSource {

    public List<ExerciseSet> getListOfExercises() {
        ExerciseSet exerciseSet = new ExerciseSet(set1(), "set1");
        ExerciseSet exerciseSet2 = new ExerciseSet(set2(), "set2");

        ArrayList<ExerciseSet> exerciseSets = new ArrayList<>();
        exerciseSets.add(exerciseSet);
        exerciseSets.add(exerciseSet2);
        return exerciseSets;
    }

    private Exercise set1() {
        long overallTime = 60000; // 30 min
        String name = "30 minute technique warmup";
        long timeLeft = 60000;
        List<Integer> imagse = getListOfImages(1);

        return new Exercise(overallTime, name, timeLeft, imagse);
    }

    private Exercise set2() {
        long overallTime = 30000; // 15 min
        String name = "something comepletely different";
        long timeLeft = 30000;
        List<Integer> imagse = getListOfImages(2);

        return new Exercise(overallTime, name, timeLeft, imagse);
    }

    private List<Integer> getListOfImages(int i) {
        ArrayList<Integer> list = new ArrayList<>();
        switch (i) {
            case 1:
                list.add(R.drawable.ic_dashboard_black_24dp);
                list.add(R.drawable.ic_home_black_24dp);
                list.add(R.drawable.ic_launcher_background);
                list.add(R.drawable.ic_notifications_black_24dp);
            case 2:
                list.add(R.drawable.ic_music);
                list.add(R.drawable.ic_neach);
                list.add(R.drawable.ic_something);
                list.add(R.drawable.ic_train);
                list.add(R.drawable.ic_injector);
        }
        return list;
    }

}

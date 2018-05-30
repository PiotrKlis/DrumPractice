package com.piotrklis.drumpractice;


import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class ExercisesLocalSource {

    ExerciseList getListOfExercises() {

        Exercise exercise = set1();

    }

    Exercise set1() {
        long overallTime = 60000; // 30 min
        int exercisesDone = 0;
        String name = "30 minute technique warmup";
        String nextExerciseName = "";
        long timeLeft = 60000;
        List<Integer> imagse = getListOfImages(1);
    }

    private List<Integer> getListOfImages(int i) {
        ArrayList<Integer> list = new ArrayList<>();
        switch (i) {
            case 1:
                    list.add(R.drawable.ic_dashboard_black_24dp);
                    list.add(R.drawable.ic_home_black_24dp);
                    list.add(R.drawable.ic_launcher_background);
                    list.add(R.drawable.ic_launcher_foreground);
                    list.add(R.drawable.ic_notifications_black_24dp);
            case 2:
                list.add()
        }
        return list;
    }

}

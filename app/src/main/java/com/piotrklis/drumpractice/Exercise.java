package com.piotrklis.drumpractice;


import java.util.List;

public class Exercise {

    private long overallTime;
    private int exercisesDone = 0;
    private String name;
    private String nextExerciseName = "";
    private long timeLeft;
    private List<Integer> images;

    public long getOverallTime() {
        return overallTime;
    }

    public void setOverallTime(long overallTime) {
        this.overallTime = overallTime;
    }

    public int getExercisesDone() {
        return exercisesDone;
    }

    public void setExercisesDone(int exercisesDone) {
        this.exercisesDone = exercisesDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNextExerciseName() {
        return nextExerciseName;
    }

    public void setNextExerciseName(String nextExerciseName) {
        this.nextExerciseName = nextExerciseName;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public Exercise(long overallTime, String name, long timeLeft, List<Integer> images) {
        this.overallTime = overallTime;
        this.name = name;
        this.timeLeft = timeLeft;
        this.images = images;

    }
}

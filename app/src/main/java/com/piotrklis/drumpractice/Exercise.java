package com.piotrklis.drumpractice;


import android.graphics.drawable.Drawable;

public class Exercise {

    private long overallTime;
    private int exercisesDone;
    private String name;
    private String nextExerciseName;
    private long timeLeft;
    private int images;

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

    public Drawable getImages() {
        return images;
    }

    public void setImages(Drawable images) {
        this.images = images;
    }

    public Exercise(long overallTime, int exercisesDone, String name, String nextExerciseName, long timeLeft, Drawable images) {
        this.overallTime = overallTime;
        this.exercisesDone = exercisesDone;
        this.name = name;
        this.nextExerciseName = nextExerciseName;
        this.timeLeft = timeLeft;
        this.images = images;

    }
}

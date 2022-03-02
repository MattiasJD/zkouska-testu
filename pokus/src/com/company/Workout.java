package com.company;

import java.util.HashMap;
import java.util.Map;

public class Workout{
    String workout;
    int kcal;
    Time time;


    public Workout(String workout, int kcal,  Time time) {
        this.workout = workout;
        this.kcal = kcal;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "workout='" + workout + '\'' +
                ", kcal=" + kcal +
                ", time='" + time + '\'' +
                '}';
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public Time getTime() {
        return time;
    }

    public Time setTime(Time time) {
        this.time = time;
    }
}

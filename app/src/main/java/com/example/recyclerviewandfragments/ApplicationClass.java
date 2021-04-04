package com.example.recyclerviewandfragments;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars = new ArrayList<Car>();
        cars.add(new Car("Volkswagen", "Polo", "Chuck Norris", "2359645612"));
        cars.add(new Car("Mercedes", "E200","Peter Pollock", "5964237841"));
        cars.add(new Car("Nissan", "Almera", "Chris James", "463259715"));
        cars.add(new Car("Mercedes", "E188", "John Rambo", "8563145629"));
        cars.add(new Car("Volkswagen", "Kombi","Nelson Mandela", "3654895236"));

    }
}

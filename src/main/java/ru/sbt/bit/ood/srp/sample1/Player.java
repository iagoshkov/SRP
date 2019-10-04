package ru.sbt.bit.ood.srp.sample1;

public class Player {
    private final String name;
    private final String surname;
    private final double speed;
    private final double accuracy;

    public Player(String name, String surname, double speed, double accuracy) {
        this.speed = speed;
        this.accuracy = accuracy;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAccuracy() {
        return accuracy;
    }
}

package ru.sbt.bit.ood.srp.sample1;

public class Player {
    private final String name;
    private final String surname;
    private final double speed;
    private final double accuracy;

    public Player(String name, String surname, double speed, double accuracy) {
        this.name = name;
        this.surname = surname;
        this.speed = speed;
        this.accuracy = accuracy;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

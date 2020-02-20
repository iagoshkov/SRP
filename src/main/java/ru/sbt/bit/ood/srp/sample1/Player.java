package ru.sbt.bit.ood.srp.sample1;

public class Player {
    private final String firstName;
    private final String lastName;
    private final double speed;
    private final double accuracy;

    public Player(String firstName, String lastName, double speed, double accuracy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speed = speed;
        this.accuracy = accuracy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAccuracy() {
        return accuracy;
    }
}

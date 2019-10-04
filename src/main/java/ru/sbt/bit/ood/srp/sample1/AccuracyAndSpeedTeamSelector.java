package ru.sbt.bit.ood.srp.sample1;

import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccuracyAndSpeedTeamSelector implements TeamSelector {

    private static void sortPlayers(List<Player> players) {
        Collections.sort(players, (p1, p2) -> {
            // compare speed with weight 0.5 and accuracy with weight 0.5
            return (int) -(p1.getSpeed() * 0.5 + p1.getAccuracy() * 0.5 -
                    p2.getSpeed()*0.5 + p2.getAccuracy() * 0.5);
        });
    }

    public  List<Player> selectTeam(List<Player> players, int teamSize) {
        List<Player> team = new ArrayList<>();
        sortPlayers(players);
        for (int i = 0; i < teamSize;i++) {
            team.add(players.get(i));
        }
        return team;
    }
}

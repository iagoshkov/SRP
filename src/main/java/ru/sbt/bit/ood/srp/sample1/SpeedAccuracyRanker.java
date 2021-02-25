package ru.sbt.bit.ood.srp.sample1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SpeedAccuracyRanker {
    public static List<Player> rankPlayers(List<Player> players, long teamSize) {
        Comparator<Player> myComparator = new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                // compare speed with weight 0.5 and accuracy with weight 0.5
                return (int) -(p1.getSpeed() * 0.5 + p1.getAccuracy() * 0.5 -
                        (p2.getSpeed() * 0.5 + p2.getAccuracy() * 0.5));
            }
        };
        List<Player> result = players.stream().sorted(myComparator).limit(teamSize).collect(Collectors.toList());
        return result;
    }

}

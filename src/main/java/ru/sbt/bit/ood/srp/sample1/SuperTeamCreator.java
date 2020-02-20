package ru.sbt.bit.ood.srp.sample1;

import java.util.List;
import java.util.stream.Collectors;

public class SuperTeamCreator implements TeamCreator {

    private static final double SPEED_WEIGHT = 0.5;
    private static final double ACCURACY_WEIGHT = 0.5;

    @Override
    public List<Player> choosePlayers(List<Player> players, int teamSize) {
        return players.stream().sorted((p1, p2) ->
                (getPlayerRank(p2)-(getPlayerRank(p1)))).
                limit(teamSize).collect(Collectors.toList());
    }

    private static int getPlayerRank(Player p1) {
        return (int) (p1.getSpeed() * SPEED_WEIGHT + p1.getAccuracy() * ACCURACY_WEIGHT);
    }

}

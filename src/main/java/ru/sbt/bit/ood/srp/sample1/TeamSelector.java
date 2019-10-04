package ru.sbt.bit.ood.srp.sample1;

import java.util.List;

public interface TeamSelector {
    List<Player> selectTeam(List<Player> players, int teamSize);
}

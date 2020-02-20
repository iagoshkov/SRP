package ru.sbt.bit.ood.srp.sample1;

import java.util.List;

public interface TeamCreator {
    List<Player> choosePlayers(List<Player> players, int teamSize);
}

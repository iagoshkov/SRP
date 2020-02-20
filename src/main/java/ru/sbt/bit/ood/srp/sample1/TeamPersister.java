package ru.sbt.bit.ood.srp.sample1;

import java.util.Collection;
import java.util.List;

public interface TeamPersister {

    List<Player> readPlayers(String filename);
    void savePlayers(Collection<Player> players);

}

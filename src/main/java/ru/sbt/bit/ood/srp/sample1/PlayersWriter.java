package ru.sbt.bit.ood.srp.sample1;

import java.io.IOException;
import java.util.List;

public interface PlayersWriter {
    void writePlayers(List<Player> players) throws IOException;
}

package ru.sbt.bit.ood.srp.sample1;

import java.io.*;
import java.util.List;

public class TeamChooser {

    private PlayersProvider playersProvider;
    private TeamSelector teamSelector;
    private PlayersWriter playersWriter;

    public TeamChooser(PlayersProvider playersReader, TeamSelector teamSelector, PlayersWriter playersWriter) {
        this.playersProvider = playersReader;
        this.teamSelector = teamSelector;
        this.playersWriter = playersWriter;
    }

    public void formTeam(int teamSize) {
        try {
            List<Player> players = playersProvider.providePlayers();
            List<Player> team = teamSelector.selectTeam(players, teamSize);
            playersWriter.writePlayers(team);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

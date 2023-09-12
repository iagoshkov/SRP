package ru.sbt.bit.ood.srp.sample1;

import java.util.*;

public class TeamChooser {

    public static void main(String[] args) {
        new TeamChooser(new CSVPlayersReader("team-candidates.csv"),
                new CSVPlayersWriter("team.json")).formTeam(5);
    }

    private final PlayerReader playersReader;
    private final PlayersWriter playersWriter;

    public TeamChooser(PlayerReader playersReader, PlayersWriter playersWriter) {
        this.playersReader = playersReader;
        this.playersWriter = playersWriter;
    }

    public void formTeam(int teamSize) {
        List<Player> players = playersReader.readPlayers();
        Collections.sort(players, new PlayerComparator());
        List<Player> selectedPlayers = players.stream().limit(teamSize).toList();
        playersWriter.savePlayers(selectedPlayers);
    }

}

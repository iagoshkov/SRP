package ru.sbt.bit.ood.srp.sample1;

import java.util.List;

public class TeamChooser {

    private final TeamPersister teamPersister;
    private final TeamCreator teamCreator;

    public TeamChooser(TeamPersister teamCSVPersister, TeamCreator teamCreator) {
        this.teamPersister = teamCSVPersister;
        this.teamCreator = teamCreator;
    }

    public static void main(String[] args) {
        new TeamChooser(
                new TeamCSVPersister(),
                new SuperTeamCreator()
        ).formTeam("team-candidates.csv", 5);
    }

    public void formTeam(String filename, int teamSize) {
        List<Player> players = teamPersister.readPlayers(filename);
        List<Player> chosenPlayers = teamCreator.choosePlayers(players, teamSize);
        teamPersister.savePlayers(chosenPlayers);
    }

}

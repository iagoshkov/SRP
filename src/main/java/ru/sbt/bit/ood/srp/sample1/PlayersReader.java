package ru.sbt.bit.ood.srp.sample1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class PlayersReader {

    private static double getAccuracy(CSVRecord p1) {
        return Double.parseDouble(p1.get(3));
    }

    private static double getSpeed(CSVRecord p1) {
        return Double.parseDouble(p1.get(2));
    }

    private static String getLastName(CSVRecord p1) {
        return p1.get(1);
    }

    private static String getFirstName(CSVRecord p1) {
        return p1.get(0);
    }

    public List<Player> readPlayers(String filename) throws IOException {
        Reader in = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filename));
        ArrayList<Player> players = new ArrayList<>();
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        for (CSVRecord record : records) {
            Player player = convertToPlayer(record);
            players.add(player);
        }
        return players;
    }

    private Player convertToPlayer(CSVRecord record) {
        Player player = new Player();
        player.setSpeed(getSpeed(record));
        player.setAccuracy(getAccuracy(record));
        player.setFirstName(getFirstName(record));
        player.setLastName(getLastName(record));
        return player;
    }
}

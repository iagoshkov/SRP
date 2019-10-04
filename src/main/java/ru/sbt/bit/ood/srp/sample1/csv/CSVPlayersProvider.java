package ru.sbt.bit.ood.srp.sample1.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.sbt.bit.ood.srp.sample1.Player;
import ru.sbt.bit.ood.srp.sample1.PlayersProvider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVPlayersProvider implements PlayersProvider {
    private final String filename;

    public CSVPlayersProvider(String filename) {
        this.filename = filename;
    }

    public List<Player> providePlayers() {
        Reader in = new InputStreamReader(CSVPlayersProvider.class.getClassLoader().getResourceAsStream(filename));
        ArrayList<Player> players = new ArrayList<>();
        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.DEFAULT.parse(in);
        } catch (IOException e) {
            return new ArrayList<Player>();
        }
        for (CSVRecord record : records) {
            Player player = parsePlayer(record);
            players.add(player);
        }
        return players;
    }

    private static Player parsePlayer(CSVRecord record) {
        String name = record.get(0);
        String surname = record.get(1);
        double speed = Double.parseDouble(record.get(2));
        double accuracy = Double.parseDouble(record.get(3));
        return new Player(name, surname, speed, accuracy);
    }
}

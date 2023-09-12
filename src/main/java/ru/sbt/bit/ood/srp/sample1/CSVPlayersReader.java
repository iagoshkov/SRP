package ru.sbt.bit.ood.srp.sample1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVPlayersReader implements PlayerReader {
    private final String filename;

    public CSVPlayersReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Player> readPlayers() {
        try {
            Reader in = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filename));
            ArrayList<Player> players = new ArrayList<>();
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
            for (CSVRecord record : records) {
                players.add(new Player(record.get(0), record.get(1),
                        Double.parseDouble(record.get(2)), Double.parseDouble(record.get(3))));
            }
            return players;
        } catch (IOException exception) {
            throw new RuntimeException("Error while reading players from " + filename + ". Check that file exists.");
        }
    }

}

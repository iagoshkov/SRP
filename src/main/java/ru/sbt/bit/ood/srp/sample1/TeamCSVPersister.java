package ru.sbt.bit.ood.srp.sample1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TeamCSVPersister implements TeamPersister {

    @Override
    public void savePlayers(Collection<Player> players) {
        String filename = "team.csv";
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        ) {
            for (Player player : players) {
                csvPrinter.printRecord(player.getFirstName(), player.getLastName());
            }
            csvPrinter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Problemas while writing team to a file: " + filename, e);
        }
    }

    @Override
    public List<Player> readPlayers(String filename) {
        Reader in = new InputStreamReader(TeamCSVPersister.class.getClassLoader().getResourceAsStream(filename));
        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.DEFAULT.parse(in);
        } catch (IOException e) {
            throw new RuntimeException("Problemas while reading " + filename, e);
        }
        ArrayList<Player> players = new ArrayList<>();
        for (CSVRecord record : records) {
            Player player = parsePlayer(record);
            players.add(player);
        }
        return players;
    }

    private static Player parsePlayer(CSVRecord record) {
        String firstName = record.get(0);
        String lastName = record.get(1);
        double speed = Double.parseDouble(record.get(2));
        double accuracy = Double.parseDouble(record.get(3));
        return new Player(firstName, lastName, speed, accuracy);
    }
}

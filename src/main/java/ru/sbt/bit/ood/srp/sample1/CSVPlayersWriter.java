package ru.sbt.bit.ood.srp.sample1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVPlayersWriter implements PlayersWriter {

    private final String filename;

    public CSVPlayersWriter(String filename) {
        this.filename = filename;
    }

    public void savePlayers(List<Player> selectedPlayers) {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)
        ) {
            for (Player player : selectedPlayers) {
                csvPrinter.printRecord(player.getName(), player.getSurname());
            }
            csvPrinter.flush();
        } catch (IOException exception) {
            throw new RuntimeException("Error while saving players to file " + filename);
        }
    }

}

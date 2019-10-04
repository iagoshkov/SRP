package ru.sbt.bit.ood.srp.sample1.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import ru.sbt.bit.ood.srp.sample1.Player;
import ru.sbt.bit.ood.srp.sample1.PlayersWriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVPlayersWriter implements PlayersWriter {

    public void writePlayers(List<Player> players) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("team.csv"));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        ) {
            for (int i = 0; i < players.size();i++) {
                csvPrinter.printRecord(players.get(i).getName(), players.get(i).getSurname());
            }
            csvPrinter.flush();
        }
    }
}

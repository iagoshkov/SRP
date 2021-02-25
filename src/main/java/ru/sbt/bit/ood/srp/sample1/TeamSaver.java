package ru.sbt.bit.ood.srp.sample1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TeamSaver {
    public static void saveTeam(List<Player> players) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("team.csv"));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        ) {
            for (Player player : players) {
                csvPrinter.printRecord(player.getFirstName(), player.getLastName());
            }
            csvPrinter.flush();
        }
    }

}

package ru.sbt.bit.ood.srp.sample1;

import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Single Responsibility Principle
//   у класса должна быть одна причина для изменений
//     1. Читать файлы другого формата
//     2. Логика выбора команды (другие веса, другой алгоритм)
//     3. Новые параметры игроков
//     4. Вывод команды в другом формате
//     5. Получать данные не из файлов
//
//   (things that change together should live together)

public class TeamChooser {

    public static void main(String[] args) {
        new TeamChooser().formTeam("team-candidates.csv", 5);
    }

    public static void formTeam(String filename, int teamSize) {
        try {
            List<Player> players = new PlayersReader().readPlayers(filename);
            List<Player> team = SpeedAccuracyRanker.rankPlayers(players, teamSize);
            TeamSaver.saveTeam(team);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

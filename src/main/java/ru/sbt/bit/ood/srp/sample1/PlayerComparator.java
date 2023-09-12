package ru.sbt.bit.ood.srp.sample1;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            // compare speed with weight 0.5 and accuracy with weight 0.5
            return (int) -(p1.getSpeed() * 0.5 + p2.getSpeed() * 0.5 -
                    p1.getAccuracy()*0.5 + p2.getAccuracy()*0.5);
        }
    }

package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Tuple;

/**
 * Created by weznon on 11/22/16.
 * Simple class, to make the comparisions in the if statements more clear
 */

public class Comparator {
    private long compareTo;

    public Comparator(long i) {
        this.compareTo = i;
    }

    public boolean c (Tuple<Long, Long> i) {
        return (System.currentTimeMillis() < i.getLeft() && i.getRight() < System.currentTimeMillis());

        }
}

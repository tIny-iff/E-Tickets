package com.e_tickets.e_ticketingsystem;

/**
 * Created by Kerrs Unit on 27/04/2018.
 */

public class Offense {
    private int points;
    private int fine;

    public void Offense()
    {
        this.points = 0;
        this.fine=0;

    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getPoints() {
        return points;
    }

    public int getFine() {
        return fine;
    }
}

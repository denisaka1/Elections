package core;

public class Elections {
    private Party[] parties; // reshimat miflagot
    private int month;
    private int year;

    /************ Constructor ************/
    public Elections(Party[] parties, int month, int year) {
        this.parties = parties;
        this.month = month;
        this.year = year;
    }

    public Elections() {
        this (new Party[2], 1, 2020); // Default
    }

    /************ Get Functions ************/
    public Party[] getParties() {
        return parties;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /************ Set Functions ************/
    public boolean setYear(int year) {
        if (year >= 2020) {
            this.year = year;
            return true;
        } else {
            this.year = 2020;
            return false;
        }
    }

    public boolean setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
            return true;
        } else {
            this.month = 1;
            return false;
        }
    }

    /************** Functions **************/
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.toString();
    }
}
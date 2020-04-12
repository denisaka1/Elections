package core;

import java.util.Arrays;
import java.util.Objects;

public abstract class BallotBox {
    private static int numGen; // auto generated
    private String address;
    private int legalCitizens; // total of legal citizens that can vote to a specific ballot box
    private Citizen[] citizens;
    private int[] parties;
    private int numberOfParties;

    /************ Constructor ************/
    public BallotBox(String address, int legalCitizens, Citizen[] citizens, int[] parties, int numberOfParties) {
        this.address = address;
        this.legalCitizens = legalCitizens;
        this.citizens = citizens;
        this.parties = parties;
        this.numberOfParties = numberOfParties;
        numGen++;
    }

    public BallotBox(String address) {
        this(address, 0, null, null,0);
    }

    /************ Get Functions ************/
    public static int getNumGen() {
        return numGen;
    }

    public String getAddress() {
        return address;
    }

    public int getLegalCitizens() {
        return legalCitizens;
    }

    public Citizen[] getCitizens() {
        return citizens;
    }

    public int[] getParties() {
        return parties;
    }

    public int getNumberOfParties() {
        return numberOfParties;
    }

    /************** Functions **************/
    abstract public void vote(Citizen citizen, Party party);
    abstract public boolean canVote(Citizen citizen, int year);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallotBox ballotBox = (BallotBox) o;
        return getLegalCitizens() == ballotBox.getLegalCitizens() &&
                getNumberOfParties() == ballotBox.getNumberOfParties() &&
                getAddress().equals(ballotBox.getAddress()) &&
                Arrays.equals(getCitizens(), ballotBox.getCitizens()) &&
                Arrays.equals(getParties(), ballotBox.getParties());

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BallotBox #" + numGen + "\n");
        sb.append("Address : " + address + "\n");
        return sb.toString();
    }
}
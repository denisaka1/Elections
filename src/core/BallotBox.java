package core;

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
    }

    public BallotBox(String address, int legalCitizens) {
        this (address, legalCitizens, new Citizen[2], new int[2], 2);
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
}
package model;

import model.citizens.Citizen;

public class ModelGUI {

    private VoterRegister vr;
    private Elections election;

    public ModelGUI() {
//        election = new Elections();
        vr = new VoterRegister();
    }

    public Elections getElection() {
        return election;
    }

    public VoterRegister getVoterRegister() {
        return vr;
    }

    public boolean addBallotBox(String address, String type) {
        boolean isAdded = election.addBallotBox(address, type);
        return isAdded;
    }

    public void setElection(int month, int year) {
        election = new Elections(month, year);
    }

    public int getElectionYear() {
        return election.getYear();
    }

    public int getElectionMonth() {
        return election.getMonth();
    }

    public int getNumberOfCitizens() {
        return vr.getCitizens().size();
    }

    public int getNumberOfParties() {
        return election.getParties().size();
    }

    public boolean addParty(String name, String section, int year, int month, int day) {
        return election.addParty(name, section, year, month, day);
    }

    public boolean addCitizen(Citizen citizen) {
        if (vr.addCitizen(citizen)) {
            election.addCitizenToBallotBox(citizen, citizen.getBallotBox());
            return true;
        }
        return false;
    }

    //    public Party(String name, String section, int year, int month, int day) {
}

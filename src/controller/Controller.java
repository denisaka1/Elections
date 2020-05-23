package controller;

import model.*;
import model.citizens.*;

public class Controller {
    public static Elections election;
    public static VoterRegister vr;

    public Controller() {
        election = new Elections();
        vr = new VoterRegister();
    }

    public String getCLIMenu() {
        String sb = "1 - Add Ballot Box \n" +
                "2 - Add Citizen \n" +
                "3 - Add Party \n" +
                "4 - Add Candidate \n" +
                "5 - Show All Ballot Box \n" +
                "6 - Show All Citizens \n" +
                "7 - Show All Parties \n" +
                "8 - Begin Elections \n" +
                "9 - Show Results \n" +
                "10 - Exit \n";
        return sb;
    }

    public boolean addBallotBox(BallotBox<? extends Citizen> ballotBox) {
        if (ballotBox.getAddress().length() != 0 && !election.existBallotBox((BallotBox<Citizen>) ballotBox)) {
            election.addBallotBox(ballotBox);
            return true;
        } else {
            System.out.println("This BallotBox has already been created!!!\n");
            return false;
        }
    }

    public boolean addParty(Party party) {
        if (party.getName().length() != 0 && !election.existParty(party)) {
            election.addParty(party);
            return true;
        } else {
            System.out.println("You are not allowed to add this party");
            return false;
        }
    }

    public String getAllCitizens() {
        return vr.toString();
    }

    public String getAllBallotBox() {
        return election.getAllBallotBoxes();
    }

    public String getAllParties() {
        return election.getAllParties();
    }

    public boolean addCitizen(Citizen citizen) {
        if (election.getYear() - citizen.getBirthYear() >= 18 && citizen.getID().length() == 9) { // Second check
            if (vr.addCitizen(citizen)) {
                election.addCitizenToBallotBox(citizen, citizen.getBallotBox());
                return true;
            }
        }
        return false;
    }

//    private boolean validBallotBox(Citizen citizen) {
//        int age = election.getYear() - citizen.getBirthYear();
//        if (age >= 18 && age <= 21) {
////            if (citizen.getType().equals("SoldierCorona"))
//
//        } else {
//
//        }
//    }

    // Add Candidate
    // Start Election
    // Get Election Results
}

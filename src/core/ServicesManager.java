package core;

import java.util.Scanner;

public class ServicesManager {
    public static Elections election = new Elections();
    public static VoterRegister vr = new VoterRegister();

    public static void showMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("1 - Add Ballot Box \n");
        sb.append("2 - Add Citizen \n");
        sb.append("3 - Add Party \n");
        sb.append("4 - Add Candidate \n");
        sb.append("5 - Show All Ballot Box \n");
        sb.append("6 - Show All Citizens \n");
        sb.append("7 - Show All Parties \n");
        sb.append("8 - Begin Elections \n");
        sb.append("9 - Show Results \n");
        sb.append("10 - Exit \n");
        System.out.println(sb.toString());
    }

    public static void swithMenu(int choose) {
        switch (choose) {
//            case 1:
//                addBallotBox();
//            case 2:
//                addCitizen();
//            case 3:
//                addParty();
//            case 4:
//                addCandidate();
//            case 5:
//                showAllBallotBox();
//            case 6:
//                showAllCitizens();
//            case 7:
//                showAllParties();
//            case 8:
//                beginElections();
//            case 9:
//                showResults();
            default:
                break;
        }
    }

    private static void addBallotBox() {

    }

    private static void addCitizen(Citizen citizen) {
        vr.addCitizen(citizen);
    }

    private static void addParty(Party party) {
//        election
    }

    private static void addCandidate(Party party, Citizen citizen) {
//        party.addCandidate(citizen,);
    }

    private static void showAllCitizens() {
    }

    private static void showAllBallotBox() {
    }

    private static void showAllParties() {
    }

    private static void beginElections() {
    }

    private static void showResults() {
    }
}

package core;

import java.util.Scanner;

public class ServicesManager {
    public static Elections election = new Elections();
    public static VoterRegister vr = new VoterRegister();

    public static void hardCodeToTest() {
        // Ballot Boxes
        BallotBox[] ballotBoxes = new BallotBox[3];
        ballotBoxes[0] = new Regular("Balfour");
        ballotBoxes[1] = new Army("Jenin");
        ballotBoxes[2] = new Corona("Tel Aviv");

        // Parties
        Party p1 = new Party("Likud", "right", 1973, 1, 1);
        Party p2 = new Party("Kahol_Lavan", "center", 2019, 1, 1);
        Party p3 = new Party("Meretz", "left", 1992, 1, 1);

        // Citizens
        Citizen c1 = new Citizen("Barak", "000000001", 2002, false, null, null, false); // Regular
        Citizen c2 = new Citizen("Denis", "000000002", 1990, false, null, null, false); // Regular
        Citizen c3 = new Citizen("Dana", "000000003", 2002, false, null, null, false); // Army
        Citizen c4 = new Citizen("Alon", "000000004", 2001, false, null, null, false); // Army
        Citizen c5 = new Citizen("Tal", "000000005", 1986, true, null, null, false); // Corona
        Citizen c6 = new Citizen("Bar", "000000006", 1994, true, null, null, false); // Corona

        // Add ballot boxes to elections
//        election.addBallotBox(ballotBoxes[0]);
//        election.addBallotBox(ballotBoxes[1]);
//        election.addBallotBox(ballotBoxes[2]);
        election.addBallotBoxes(ballotBoxes[0], ballotBoxes[1], ballotBoxes[2]);

        // Add citizen to VoterRegister
//        vr.addCitizen(c1);
//        vr.addCitizen(c2);
//        vr.addCitizen(c3);
//        vr.addCitizen(c4);
//        vr.addCitizen(c5);
//        vr.addCitizen(c6);
        vr.addCitizens(c1, c2, c3, c4, c5, c6);

        Citizen[] citizens = vr.getCitizens();

        // Add citizens to ballot boxes
        ballotBoxes[0].addCitizens(citizens[0], citizens[1]);
        ballotBoxes[1].addCitizens(citizens[2], citizens[3]);
        ballotBoxes[2].addCitizens(citizens[4], citizens[5]);

        // Add parties to ballot boxes
//        ballotBoxes[0].addParties(p1, p2, p3);
//        ballotBoxes[1].addParties(p1, p2, p3);
//        ballotBoxes[2].addParties(p1, p2, p3);

        // Add candidates to parties
        p1.addCandidate(c1, 1);
        p1.addCandidate(c2, 2);
        p2.addCandidate(c3, 2);
        p2.addCandidate(c4, 2);
        p3.addCandidate(c5, 2);
        p3.addCandidate(c6, 1);

        // Add parties to elections
//        election.addParty(p1);
//        election.addParty(p2);
//        election.addParty(p3);
        election.addParties(p1, p2, p3);
    }

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

    public static void addBallotBox(BallotBox ballotBox) {
        election.addBallotBox(ballotBox);
    }

    public static void addCitizen(Citizen citizen) {
        vr.addCitizen(citizen);
        Citizen refToCitizen = vr.getCitizenById(citizen.getID());
        election.addCitizenToBallotBoxes(refToCitizen);

    }

    public static BallotBox getPartyByNumber(int number) {
        return election.getBallotBoxByNumber(number);
    }

    public static void addParty(Party party) {
        election.addParty(party);
    }

    public static void addCandidate(String citizenID, String partyName, int place) {
        Citizen citizen = vr.getCitizenById(citizenID);
        Party party = election.getPartiesByName(partyName);

        if (citizen != null && party != null) {
            party.addCandidate(citizen, place);
        }
    }

    public static String showAllCitizens() {
        return vr.toString();
    }

    public static String showAllBallotBox() {
        return election.getAllBallotBoxes();
    }

    public static String showAllParties() {
        return election.getAllParties();
    }

    public static void beginElections(Scanner s) {
        Citizen[] citizens = vr.getCitizens(); // Reference
        Party partyVote = null;
        for (int i = 0; i < citizens.length; i++) {
            if (citizens[i] != null) {
                if (!citizens[i].getVoted()) {
                    partyVote = election.getPartiesByName(Program.getVoteParty(s, citizens[i].getName()));
                    if (partyVote != null) {
                        citizens[i].getBallotBox().vote(citizens[i], partyVote);
                        partyVote = null;
                    }
                }
            }
        }
    }

    public static void showResults() {
        int[] results = new int[election.getAllParties().length()];
        BallotBox[] ballotBoxes = election.getBallotBoxes();
        int[] voteForParty;
        Party[] parties;

        for (int i = 0; i < ballotBoxes.length; i++) {
            if (ballotBoxes[i] != null) {
                System.out.print(ballotBoxes[i].toString());
                voteForParty = ballotBoxes[i].getVotesForParty();
                parties = ballotBoxes[i].getParties();
                for (int j = 0; j < parties.length; j++) {
                    if (parties[j] != null) {
                        results[j] += voteForParty[j];
                        System.out.println(parties[j].getName() + " : " + voteForParty[j]);
                    }
                }

                System.out.println("");
            }
        }

        parties = election.getParties();
        System.out.println("Final Results : ");
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != null) {
                System.out.println(parties[i].getName() + " : " + results[i]);
            }
        }
    }
}

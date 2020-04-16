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
        Party p2 = new Party("Kaḥol Lavan", "center", 2019, 1, 1);
        Party p3 = new Party("Meretz", "left", 1992, 1, 1);

        // Citizens
        Citizen c1 = new Citizen("Barak", "000000001", 2002, false, null , null, false); // Army
        Citizen c2 = new Citizen("Denis", "000000002", 1990, false, null , null, false);
        Citizen c3 = new Citizen("Dana", "000000003", 1980, true, null , null, false); // Corona
        Citizen c4 = new Citizen("Alon", "000000004", 1986, true, null , null, false); // Corona
        Citizen c5 = new Citizen("Tal", "000000005", 1996, false, null , null, false);
        Citizen c6 = new Citizen("Bar", "000000006", 1994, false, null , null, false);

        // Add ballot boxes to elections
        election.addBallotBox(ballotBoxes[0]);
        election.addBallotBox(ballotBoxes[1]);
        election.addBallotBox(ballotBoxes[2]);

        // Add citizen to VoterRegister
        vr.addCitizen(c1);
        vr.addCitizen(c2);
        vr.addCitizen(c3);
        vr.addCitizen(c4);
        vr.addCitizen(c5);
        vr.addCitizen(c6);

        // Add citizens to ballot boxes
        ballotBoxes[0].addCitizen(c1);
        ballotBoxes[0].addCitizen(c2);
        ballotBoxes[1].addCitizen(c3);
        ballotBoxes[1].addCitizen(c4);
        ballotBoxes[2].addCitizen(c5);
        ballotBoxes[2].addCitizen(c6);

        // Add parties to ballot boxes
        ballotBoxes[0].addParty(p1);
        ballotBoxes[0].addParty(p2);
        ballotBoxes[0].addParty(p3);

        ballotBoxes[1].addParty(p1);
        ballotBoxes[1].addParty(p2);
        ballotBoxes[1].addParty(p3);

        ballotBoxes[2].addParty(p1);
        ballotBoxes[2].addParty(p2);
        ballotBoxes[2].addParty(p3);

        // Add candidates to parties
        p1.addCandidate(c1, 1);
        p1.addCandidate(c2, 4);
        p2.addCandidate(c3, 2);
        p2.addCandidate(c4, 2);
        p3.addCandidate(c5, 2);
        p3.addCandidate(c6, 1);

        // Add parties to elections
        election.addParty(p1);
        election.addParty(p2);
        election.addParty(p3);

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
/*        int[] results = new int[election.getAllParties().length()];
        BallotBox[] ballotBoxes = election.getBallotBoxes();
        int[] voteForParty;
        int[] partiesVotes = new int[election.getParties().length];
        for (int i = 0; i < election.getBallotBoxes().length; i++) {
            for (int j = 0; j < ballotBoxes.length; j++) {
                voteForParty = ballotBoxes[i].getVotesForParty();
                for (int x = 0; x < voteForParty.length; x++) {
                    results[x] += voteForParty[x];
                }
            }
        }

        System.out.println("Results : ");
        for (int i = 0; i < results.length; i++) {

        }*/
        // arr for parties votes
        // show all ballot boxes votes
    }
}

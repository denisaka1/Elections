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
        BallotBox.numGen = 0;

        // Parties
        Party[] parties = new Party[3];
        parties[0] = new Party("Likud", "right", 1973, 1, 1);
        parties[1] = new Party("Kahol_Lavan", "center", 2019, 1, 1);
        parties[2] = new Party("Meretz", "left", 1992, 1, 1);

        addBallotBox(ballotBoxes[0]);
        addBallotBox(ballotBoxes[1]);
        addBallotBox(ballotBoxes[2]);

        BallotBox[] refBallotBoxes = election.getBallotBoxes();

        // Citizens
        Citizen[] citizens = new Citizen[6];
        citizens[0] = new Citizen("Barak", "000000001", 2002, false, refBallotBoxes[0], null, false); // Regular
        citizens[1] = new Citizen("Denis", "000000002", 1990, false, refBallotBoxes[0], null, false); // Regular
        citizens[2] = new Citizen("Dana", "000000003", 2002, false, refBallotBoxes[1], null, false); // Army
        citizens[3] = new Citizen("Alon", "000000004", 2001, false, refBallotBoxes[1], null, false); // Army
        citizens[4] = new Citizen("Tal", "000000005", 1986, true, refBallotBoxes[2], null, false); // Corona
        citizens[5] = new Citizen("Bar", "000000006", 1994, true, refBallotBoxes[2], null, false); // Corona

        addCitizen(citizens[0]);
        addCitizen(citizens[1]);
        addCitizen(citizens[2]);
        addCitizen(citizens[3]);
        addCitizen(citizens[4]);
        addCitizen(citizens[5]);

        Citizen[] refCitizen = vr.getCitizens();

        addParty(parties[0]);
        addParty(parties[1]);
        addParty(parties[2]);

        addCandidate(refCitizen[0].getID(), parties[0].getName(), 1);
        addCandidate(refCitizen[1].getID(), parties[0].getName(), 2);
        addCandidate(refCitizen[2].getID(), parties[1].getName(), 2);
        addCandidate(refCitizen[3].getID(), parties[1].getName(), 1);
        addCandidate(refCitizen[4].getID(), parties[2].getName(), 5); // check
        addCandidate(refCitizen[5].getID(), parties[2].getName(), 1);


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
        election.addBallotBoxes(ballotBox);
    }

    public static void addCitizen(Citizen citizen) {
        vr.addCitizen(citizen);
        Citizen refToCitizen = vr.getCitizenById(citizen.getID());
        election.addCitizenToBallotBoxes(refToCitizen);

    }

    public static BallotBox getBallotBoxByNumber(int number) {
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

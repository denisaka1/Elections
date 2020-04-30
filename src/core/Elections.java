package core;

import java.util.ArrayList;

public class Elections {
    /* Defaults:
       partiesList.length: 0
       ballotBoxesList.length: 0
       month: 1
       year: 2020
   */
    private ArrayList<Party> partiesList;
    private ArrayList<BallotBox> ballotBoxesList;
    private int month;
    private int year;

    /************ Constructor ************/
    public Elections(ArrayList<Party> parties, ArrayList<BallotBox> ballotBoxes, int month, int year) {
        setParties(parties);
        setBallotBoxes(ballotBoxes);
        setMonth(month);
        setYear(year);
    }

    public Elections(int month, int year) {
        this (null,null,month, year);
    }

    public Elections() {
        this (null, null,1, 2020); // Default
    }

    /************ Get Functions ************/
    public ArrayList<Party> getParties() {
        return partiesList;
    }

    public ArrayList<BallotBox> getBallotBoxes() {
        return ballotBoxesList;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Party getPartiesByName(String name) {
        // TODO: return by value or by ref?
        for(Party party: partiesList){
            if(party.getName().toUpperCase().equals(name.toUpperCase()))
                return party;
        }
        return null;
    }

    public BallotBox getBallotBoxByNumber(int number) {
        // TODO: return by value or by ref?
        for(BallotBox ballotBox: ballotBoxesList)
            if(ballotBox.getId() == number)
                return ballotBox;
        return null;
    }

    public String getAllParties() { // TODO: last section
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != null) {
                sb.append("----------------\n");
                sb.append(parties[i].toString() + "\n");
                sb.append("----------------\n");
            }
        }
        return sb.toString();
    }

    public String getAllPartiesLine() { // TODO: last section
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != null) {
                sb.append(parties[i].getName() + "(" + parties[i].getSection() + ") ");
            }
        }
        return sb.toString();
    }

    public String getAllBallotBoxes() { // TODO: last section
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ballotBoxes.length; i++) {
            if (ballotBoxes[i] != null) {
                sb.append("----------------\n");
                sb.append(ballotBoxes[i].toString() + "\n");
                sb.append("----------------\n");
            }
        }
        return sb.toString();
    }

    /************ Set Functions ************/
    private boolean setParties(ArrayList<Party> parties) {
        if(parties != null) {
            for(Party party: parties){
                addParty(party);
            }
            return true;
        }
        partiesList = new ArrayList<Party>(0);
        return false;
    }

    private boolean setBallotBoxes(ArrayList<BallotBox> ballotBoxes) {
        if (ballotBoxes != null){
            for(BallotBox ballotBox: ballotBoxes)
                addBallotBox(ballotBox);
            return true;
        }
        ballotBoxesList = new ArrayList<BallotBox>(0);
        return false;
    }

    private boolean setYear(int year) {
        if (year >= 2020) {
            this.year = year;
            return true;
        } else {
            this.year = 2020;
            return false;
        }
    }

    private boolean setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
            return true;
        } else {
            this.month = 1;
            return false;
        }
    }

    /************** Functions **************/
    private void addBallotBox(BallotBox ballotBox) {
        if (ballotBox != null && !ballotBoxesList.contains(ballotBox)) {
            ballotBoxesList.add(returnBallotBox(ballotBox));
        }
    }

    public void addCitizenToBallotBoxes(Citizen citizen) {
        for(BallotBox ballotBox: ballotBoxesList){
            if (ballotBox != null && ballotBox.equals(citizen.getBallotBox())) {
                ballotBox.addCitizen(citizen);
            }
        }
    }

    public boolean addParty(Party party) {
        if(party != null && !partiesList.contains(party)) {
            partiesList.add(new Party(party));
            updateBallotBoxes(party);
            return true;
        }
        return false;
    }

    private void updateBallotBoxes(Party party) {
        for(BallotBox ballotBox: ballotBoxesList)
            ballotBox.addParty(party);
    }

    private BallotBox returnBallotBox(BallotBox ballotBox){
        if(ballotBox instanceof Army)
            return new Army((Army)ballotBox);
        else if(ballotBox instanceof Corona)
            return new Corona((Corona)ballotBox);
        else if(ballotBox instanceof Regular)
            return new Regular((Regular)ballotBox);
        else
            return null;
    }

    public boolean equals(Elections elections) {
        if (this == null && elections == null)
            return true;
        else if (this == null || elections == null)
            return false;
        return month == elections.month && year == elections.year; // enough to check only date
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("\nThere are " + partiesCounter +" Parties:\n");

        for(int i = 0; i < partiesCounter; i++){
            sb.append(parties[i].toString() + "----------------\n");
        }
        sb.append("\n");

        sb.append("There are " + ballotBoxesCounter + " Ballot Boxes:\n");

        for(int i = 0; i < ballotBoxesCounter; i++){
            sb.append(ballotBoxes[i].toString() + "----------------\n");
        }

        sb.append("\n");

        if(year >= 2020 && month > 4)
            sb.append("\nThe Election will be held at" + month + "/" + year + "\n");
        else
            sb.append("\nThe Election had been held at " + month + "/" + year +"\n");

        return sb.toString();
    }
}
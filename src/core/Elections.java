package core;

import java.util.Arrays;

public class Elections {
    /* Defaults:
       parties.length: 0
       ballotBoxes.length: 0
       month: 1
       year: 2020
   */
    private Party[] parties;
    private BallotBox[] ballotBoxes;
    private int partiesCounter;
    private int ballotBoxesCounter;
    private int month;
    private int year;

    /************ Constructor ************/
    public Elections(Party[] parties, BallotBox[] ballotBoxes, int month, int year) {
        setParties(parties);
        setBallotBoxes(ballotBoxes);
        setMonth(month);
        setYear(year);
    }

    public Elections(int month, int year) {
        this (new Party[0], new BallotBox[0],month, year);
    }

    public Elections() {
        this (new Party[0], new BallotBox[0],1, 2020); // Default
        this.partiesCounter = 0;
        this.ballotBoxesCounter = 0;
    }

    /************ Get Functions ************/
    public Party[] getParties() {
        return parties;
    }

    public BallotBox[] getBallotBoxes() {
        return ballotBoxes;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Party getPartiesByName(String name) {
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != null && name != null) {
                if (parties[i].getName().toUpperCase().equals(name.toUpperCase()))
                    return parties[i];
            }
        }
        return null;
    }

    public BallotBox getBallotBoxByNumber(int number) {
        if (number < ballotBoxes.length)
            return ballotBoxes[number];
        else
            return ballotBoxes[0];
    }

    public String getAllParties() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != null) {
                sb.append(parties[i].toString() + "\n");
            }
        }
        return sb.toString();
    }

    /************ Set Functions ************/
    private boolean setParties(Party[] parties){
        if(parties != null && parties.length != 0){
            for(int i = 0; i < parties.length; i++){
                this.parties[i] = new Party(parties[i]);
            }
            partiesCounter = parties.length;
            return true;
        }
        this.parties = new Party[0];
        partiesCounter = 0;
        return false;
    }

    private boolean setBallotBoxes(BallotBox[] ballotBoxes){
        if(ballotBoxes != null && ballotBoxes.length != 0){
            ballotBoxes = new BallotBox[ballotBoxes.length];
            for(int i = 0; i < ballotBoxes.length; i++){
//                this.ballotBoxes[i] = assignBallotBox(ballotBoxes[i]);
                this.ballotBoxes[i] = returnBallotBox(ballotBoxes[i]);
            }
            ballotBoxesCounter = ballotBoxes.length;
            return true;
        }
        this.ballotBoxes = new BallotBox[0];
        ballotBoxesCounter = 0;
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
    public void addCitizenToBallotBoxes(Citizen citizen) {
        for (int i = 0; i < ballotBoxes.length; i++) {
            if (ballotBoxes[i] != null) {
                if (ballotBoxes[i].equals(citizen.getBallotBox())) {
                    ballotBoxes[i].addCitizens(citizen);
                }
            }
        }
    }

    private void expandParties() {
        Party[] temp = new Party[parties.length * 2];
        for (int i = 0; i < parties.length; i++) {
            temp[i] = parties[i];
        }
        this.parties = temp;
    }

    public boolean addParty(Party party) { // TODO : change to addParties
        if (parties.length == 0) {
            this.parties = new Party[1];
        }

        if (partiesCounter >= parties.length) {
            expandParties();
            addParty(party);
        } else if (existParty(party)) {
            return false;
        } else {
            parties[partiesCounter] = new Party(party);
            updateBallotBoxes(parties[partiesCounter]);
            partiesCounter++;
            return true;
        }
        return false;
    }


    private boolean existParty(Party party) {
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != null && party != null) {
                if (parties[i].equals(party)) {
                    return true;
                } else if (parties[i].getName().equals(party.getName()))
                    return true;
            }
        }
        return false;
    }

/*    private BallotBox assignBallotBox (BallotBox ballotBox){
        if (ballotBox instanceof Army || ballotBox instanceof Corona || ballotBox instanceof Regular)
            return ballotBox;

        return null;
    }*/

    private void updateBallotBoxes(Party party) {
        for(int i = 0; i < ballotBoxesCounter; i++) {
            if (ballotBoxes[i] != null) {
                ballotBoxes[i].addParties(party);
            }
        }
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

    public void addBallotBoxes(BallotBox... newBallotBoxes) {
        int k = newBallotBoxes.length + this.ballotBoxes.length;
        BallotBox[] tempBallotBoxes = new BallotBox[k * 2];

        int newBallotBoxesCounter = 0;
        for (int i = 0; i < k; i++) {
            if (this.ballotBoxes.length > i) {
                if (this.ballotBoxes[i] != null) {
                    tempBallotBoxes[i] = this.ballotBoxes[i];
                } else {
                    if (newBallotBoxesCounter < newBallotBoxes.length) {
                        tempBallotBoxes[i] = returnBallotBox( newBallotBoxes[newBallotBoxesCounter] );
                        ballotBoxesCounter++;
                        newBallotBoxesCounter++;
                    }
                }
            } else {
                if (newBallotBoxesCounter < newBallotBoxes.length) {
                    tempBallotBoxes[i] = returnBallotBox( newBallotBoxes[newBallotBoxesCounter] );
                    ballotBoxesCounter++;
                    newBallotBoxesCounter++;
                }
            }
        }

        this.ballotBoxes = tempBallotBoxes;
    }


/*    public boolean addBallotBox(BallotBox ballotBox) { // TODO : Maybe del ?
        if (this.ballotBoxes == null || ballotBoxes.length == 0 ){
            this.ballotBoxes = new BallotBox[1];
            this.ballotBoxes[0] = assignBallotBox(ballotBox);
        } else {
            if (ballotBoxesCounter >= ballotBoxes.length) {
                expandBallotBoxes();
                addBallotBox(ballotBox);
            } else if (existBallotBox(ballotBox)) {
                return false;
            } else {
                ballotBoxes[ballotBoxesCounter] = assignBallotBox(ballotBox);
                ballotBoxesCounter++;
                return true;
            }
        }
        return false;
    }

    private void expandBallotBoxes() {
        BallotBox[] temp = new BallotBox[ballotBoxes.length * 2];
        for (int i = 0; i < ballotBoxes.length; i++) {
            temp[i] = ballotBoxes[i];
        }
        this.ballotBoxes = temp;
    }
 */

    public void addParties(Party... newParties){
        int k = newParties.length + this.parties.length;
        Party[] temp = new Party[k * 2];

        for(int i = 0; i < k; i++){
            if(this.parties.length > i)
                temp[i] = this.parties[i];
            else{
                if(newParties[i - this.parties.length] != null && !existParty(newParties[i - this.parties.length])){
                    temp[i] = new Party(newParties[i - this.parties.length]);
                    updateBallotBoxes(temp[i]);
                    partiesCounter++;
                }
            }
        }
        this.parties = temp;
    }

    public boolean existBallotBox(BallotBox ballotBox) {
        for (int i = 0; i < ballotBoxes.length; i++) {
            if (ballotBoxes[i] != null && ballotBox != null) {
                if (ballotBoxes[i].equals(ballotBox)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getAllPartiesLine() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != null) {
                sb.append(parties[i].getName() + "(" + parties[i].getSection() + ") ");
            }
        }
        return sb.toString();
    }

    public String getAllBallotBoxes() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ballotBoxes.length; i++) {
            if (ballotBoxes[i] != null)
                sb.append(ballotBoxes[i].toString() + "\n");
        }
        return sb.toString();
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
        return sb.toString();
    }
}
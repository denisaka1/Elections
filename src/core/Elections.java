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
                if (parties[i].getName().equals(name))
                    return parties[i];
            }
        }
        return null;
    }

    public BallotBox getBallotBoxByNumber(int number) {
        // Exception
        if (ballotBoxes.length < number)
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
                this.ballotBoxes[i] = assignBallotBox(ballotBoxes[i]);
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
                ballotBoxes[i].addCitizens(citizen);
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

    public boolean addParty(Party party) {
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

    private void updateBallotBoxes(Party party){
        for(int i = 0; i < ballotBoxesCounter; i++){
            ballotBoxes[i].addParties(party);
        }
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

    private void expandBallotBoxes() {
        BallotBox[] temp = new BallotBox[ballotBoxes.length * 2];
        for (int i = 0; i < ballotBoxes.length; i++) {
            temp[i] = ballotBoxes[i];
        }
        this.ballotBoxes = temp;
    }

    private BallotBox assignBallotBox (BallotBox ballotBox){
        if (ballotBox instanceof Army || ballotBox instanceof Corona || ballotBox instanceof Regular)
            return ballotBox;

        return null;
    }

    private void updateParties(Party party){
        for(int i = 0; i < this.ballotBoxes.length; i++){
            if(ballotBoxes[i] != null)
                ballotBoxes[i].addParties(party);
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

    public void addBallotBoxes(BallotBox... newBallotBoxes){
        int k = newBallotBoxes.length + this.ballotBoxes.length;
        BallotBox[] temp = new BallotBox[k * 2];

        for(int i = 0; i < k; i++){
            if(this.ballotBoxes.length > i)
                temp[i] = this.ballotBoxes[i];
            else{
                if(newBallotBoxes[i - this.ballotBoxes.length] != null && !existBallotBox(newBallotBoxes[i - this.ballotBoxes.length])){
                    temp[i] = returnBallotBox(newBallotBoxes[i - this.ballotBoxes.length]);
//                    temp[i] = assignBallotBox(newBallotBoxes[i - this.ballotBoxes.length]);
                    ballotBoxesCounter++;
                }
            }
        }
        this.ballotBoxes = temp;
    }

        public boolean addBallotBox(BallotBox ballotBox) {
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

    public void addParties(Party... newParties){
        int k = newParties.length + this.parties.length;
        Party[] temp = new Party[k * 2];

        for(int i = 0; i < k; i++){
            if(this.parties.length > i)
                temp[i] = this.parties[i];
            else{
                if(newParties[i - this.parties.length] != null && !existParty(newParties[i - this.parties.length])){
                    temp[i] = new Party(newParties[i - this.parties.length]);
                    updateParties(temp[i]);
                    partiesCounter++;
                }
            }
        }
        this.parties = temp;
    }

    private boolean existBallotBox(BallotBox ballotBox) {
        for (int i = 0; i < ballotBoxes.length; i++) {
            if (ballotBoxes[i] != null && ballotBox != null) {
                if (ballotBoxes[i].equals(ballotBox)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getAllBallotBoxes() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ballotBoxes.length; i++) {
            if (ballotBoxes[i] != null)
                sb.append(ballotBoxes[i].toString() + "\n");
                sb.append(ballotBoxes[i].toString() + "\n");
        }
        return sb.toString();
    }

    /*
    @Override
    public boolean equals(Object obj) {
        Elections elections = (Elections) obj;
        if (!elections.getParties().equals(elections) || elections.getMonth() != month
                || elections.getYear() != year)
            return true;
        return false;
    }
     */

    public boolean equals(Elections other){
        if( other == null) return false;

        return  partiesCounter == other.partiesCounter &&
                ballotBoxesCounter == other.ballotBoxesCounter &&
                Arrays.equals(parties, other.parties) &&
                Arrays.equals(ballotBoxes, other.ballotBoxes) &&
                month == other.month &&
                year == other.year;
    }

/*
    private boolean isSameParties(Party[] other){
        boolean isSame = true;
        for(int i = 0; i < partiesCounter; i++){
            if(isSame && ( parties[i] != null || other[i] != null ) && parties[i].equals(other[i]))
                isSame = false;
        }
        return isSame;
    }

    private boolean isSameBallotBoxes(BallotBox[] other){
        boolean isSame = true;
        for(int i = 0; i < ballotBoxesCounter; i++){
            if(isSame && ( ballotBoxes[i] != null || other[i] != null ) && ballotBoxes[i].equals(other[i]))
                isSame = false;
        }
        return isSame;
    }


    public boolean equals(Elections other){
        if(other != null){
            boolean isSameParties = false;
            boolean isSameBallotBoxes = false;
            boolean isSameDate = year == other.year && month == other.month;

            if(partiesCounter == other.partiesCounter)
                isSameParties = isSameParties(other.parties);
            if(ballotBoxesCounter == other.ballotBoxesCounter)
                isSameBallotBoxes = isSameBallotBoxes(other.ballotBoxes);

            if(isSameParties && isSameBallotBoxes && isSameDate)
                return true;

        }
        return false;
    }
 */

    // Party[] parties, BallotBox[] ballotBoxes, int month, int year
    //    private int partiesCounter;
    //    private int ballotBoxesCounter;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.toString();
    }
}
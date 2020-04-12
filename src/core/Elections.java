package core;

public class Elections {
    private Party[] parties;
    private BallotBox[] ballotBoxes;
    int partiesCounter;
    private int ballotBoxsCounter;
    private int month;
    private int year;

    /************ Constructor ************/
    public Elections(Party[] parties, BallotBox[] ballotBoxs, int month, int year) {
        this.parties = parties;
        this.month = month;
        this.year = year;
        this.partiesCounter = 0;
        this.ballotBoxsCounter = 0;
    }

    public Elections(int month, int year) {
        this (new Party[2], new BallotBox[2],month, year);
    }

    public Elections() {
        this (new Party[2], new BallotBox[2],1, 2020); // Default
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
            if (parties[i] != null) {
                if (parties[i].getName().equals(name))
                    return parties[i];
            }
        }
        return null;
    }

    /************ Set Functions ************/
    public boolean setYear(int year) {
        if (year >= 2020) {
            this.year = year;
            return true;
        } else {
            this.year = 2020;
            return false;
        }
    }

    public boolean setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
            return true;
        } else {
            this.month = 1;
            return false;
        }
    }

    /************** Functions **************/
    private void expandParties() {
        Party[] temp = new Party[parties.length * 2];
        for (int i = 0; i < parties.length; i++) {
            temp[i] = parties[i];
        }
        this.parties = temp;
    }

    public boolean addParty(Party party) {
        if (existParty(party)) {
            return false;
        } else if (partiesCounter >= parties.length) {
            expandParties();
            addParty(party);
        } else {
            parties[partiesCounter] = party;
            partiesCounter++;
            return true;
        }
        return false;
    }

    private boolean existParty(Party party) {
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != null) {
                if (parties[i].equals(party)) {
                    return true;
                } else if (parties[i].getName().equals(party.getName()))
                    return true;
            }
        }
        return false;
    }

    private void expandBallotBoxs() {
        BallotBox[] temp = new BallotBox[ballotBoxes.length * 2];
        for (int i = 0; i < ballotBoxes.length; i++) {
            temp[i] = ballotBoxes[i];
        }
        this.ballotBoxes = temp;
    }

    public boolean addBallotBox(BallotBox ballotBox) {
        if (addBallotBox(ballotBox)) {
            return false;
        } else if (ballotBoxsCounter >= ballotBoxes.length) {
            expandBallotBoxs();
            addBallotBox(ballotBox);
        } else {
            ballotBoxes[ballotBoxsCounter] = ballotBox;
            ballotBoxsCounter++;
            return true;
        }
        return false;
    }

    private boolean existBallotBox(BallotBox ballotBox) {
        for (int i = 0; i < ballotBoxes.length; i++) {
            if (ballotBoxes[i] != null) {
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
            sb.append(ballotBoxes[i].toString() + "\n");
        }
        return sb.toString();
    }

    public String getAllParties() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < parties.length; i++) {
            sb.append(parties[i].toString() + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Elections elections = (Elections) obj;
        if (!elections.getParties().equals(elections) || elections.getMonth() != month
                || elections.getYear() != year)
            return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.toString();
    }
}
package model.citizens;

import model.*;

public class SoldierCorona extends Citizen{
    private boolean isolation;
    private int daysInIsolation;

    /************ Constructor *************/
    public SoldierCorona(String name, String id, int birthYear, boolean isolation, BallotBox ballotBox, Party party, boolean voted, int daysInIsolation) {
        super(name, id, birthYear, ballotBox, party, voted);
        setIsolation(isolation);
        setDaysInIsolation(daysInIsolation);
    }

    public SoldierCorona(SoldierCorona soldierCorona) {
        this(soldierCorona.name, soldierCorona.id, soldierCorona.birthYear,
                soldierCorona.isolation, soldierCorona.ballotBox, soldierCorona.party,
                soldierCorona.voted, soldierCorona.daysInIsolation);
    }

    public SoldierCorona(String name, String id, int birthYear, boolean isolation, BallotBox ballotBox) {
        super(name, id, birthYear, ballotBox);
        this.isolation = isolation;
        this.daysInIsolation = 0;
    }

    public SoldierCorona(String name, String id, int birthYear) {
        super(name, id, birthYear);
        isolation = false;
        daysInIsolation = 0;
    }

    /************ Get Functions ***********/
    public int getDaysInIsolation() {
        return daysInIsolation;
    }

    public boolean isIsolation() {
        return isolation;
    }

    /************ Set Functions ***********/
    private boolean setIsolation(boolean isolation) {
        this.isolation = isolation;
        return isolation;
    }

    private boolean setDaysInIsolation(int days){
        if (days >= 0){
            this.daysInIsolation = days;
            return true;
        }
        return false;
    }

    /************** Functions *************/
    public void carryWeapon() {
        System.out.println("Achievement unlocked: Rifleman");
    }

    @Override
    public boolean canVote() {
        if(super.canVote() && isolation)
            return true;
        return false;
    }

    public boolean equals(SoldierCorona soldierCorona) {
        return super.equals(soldierCorona);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());

        if (isolation)
            sb.append("In isolation for " + daysInIsolation + "days\n");
        else
            sb.append("Not in isolation\n");

        sb.append("----------------\n");

        return sb.toString();
    }
}
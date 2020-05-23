package model.citizens;

import model.*;

public class Soldier extends Citizen implements Soldierable {
    /************ Constructor *************/
    public Soldier(String name, String id, int birthYear, BallotBox ballotBox, Party party, boolean voted) {
        super(name, id, birthYear, ballotBox, party, voted);
    }

    public Soldier(Soldier citizen) {
        this(citizen.name, citizen.id, citizen.birthYear, citizen.ballotBox, citizen.party, citizen.voted);
    }

    public Soldier(String name, String id, int birthYear, BallotBox ballotBox) {
        super(name, id, birthYear, ballotBox);
    }

    public Soldier(String name, String id, int birthYear) {
        super(name, id, birthYear);
    }

    /************** Functions *************/
    @Override
    public void carryWeapon() {
        System.out.println("Achievement unlocked: Rifleman");
    }

    public boolean equals(Soldier soldier) {
        return super.equals(soldier);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());

        sb.append("----------------\n");

        return sb.toString();
    }
}
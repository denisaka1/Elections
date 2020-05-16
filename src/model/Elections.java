package model;

import model.citizens.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Elections {
    /* Defaults:
   partiesList.length: 0
   ballotBoxesList.length: 0
   month: 1
   year: 2021
*/
    private ArrayList<BallotBox<Regular>> regular;
    private ArrayList<BallotBox<Soldier>> soldier;
    private ArrayList<BallotBox<SoldierCorona>> soldierCorona;
    private ArrayList<BallotBox<Corona>> corona;

    private HashMap<Party, Integer> parties;

    private int month;
    private int year;

    /************* Constructor *************/
    public Elections(ArrayList<BallotBox<Regular>> regular, ArrayList<BallotBox<Soldier>> soldier, ArrayList<BallotBox<SoldierCorona>> soldierCorona,
                     ArrayList<BallotBox<Corona>> corona, HashMap<Party, Integer> parties, int month, int year) {
        this.regular = regular;
        this.soldier = soldier;
        this.soldierCorona = soldierCorona;
        this.corona = corona;
        setParties(parties);
        setMonth(month);
        setYear(year);
    }

    public Elections(int month, int year) {
        this (null, null, null, null, null, month, year);
    }

    public Elections() {
        this (null, null, null, null, null, 1, 2021); // Default
    }

    /************ Set Functions ************/
    private boolean setParties(HashMap<Party, Integer> parties){
        if (parties != null && !parties.isEmpty()) {
            this.parties = parties;
            return true;
        }
        this.parties = new HashMap<Party, Integer>(0);
        return false;
    }

    private boolean setBallotBoxes(ArrayList<BallotBox<Citizen>> ballotBoxes, Citizen type) {
        // one for everyone and everyone for one !!
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

    /************ Get Functions ************/
    public ArrayList<BallotBox<Regular>> getRegular() {
        return regular;
    }

    public ArrayList<BallotBox<Soldier>> getSoldier() {
        return soldier;
    }

    public ArrayList<BallotBox<SoldierCorona>> getSoldierCorona() {
        return soldierCorona;
    }

    public ArrayList<BallotBox<Corona>> getCorona() {
        return corona;
    }

    public HashMap<Party, Integer> getParties() {
        return parties;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getAllPartiesLine() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < parties.size(); i++) {
            if (parties.get(i) != null) {
//                sb.append(parties.get(i).getName() + "(" + parties.get(i).getSection() + ") ");
            }
        }
        return sb.toString();
    }

//    public String getAllBallotBoxes() {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < ballotBoxes.size(); i++) {
//            if (ballotBoxes[i] != null) {
//                sb.append("----------------\n");
//                sb.append(ballotBoxes[i].toString() + "\n");
//                sb.append("----------------\n");
//            }
//        }
//        return sb.toString();
//    }

    /************** Functions **************/
    // addBallotBox
    // addCitizenToBallotBoxes

    public boolean addParty(Party party) {
        if (party != null && !parties.containsKey(party)) {
            this.parties.put(party, 0);
            return true;
        }
        return false;
    }

    // updateBallotBoxes - update parties
    // equals
    // toString

}
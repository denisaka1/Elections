package model;

import model.citizens.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Elections {
    /* Defaults:

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
        setRegular(regular);
        setSoldier(soldier);
        setSoldierCorona(soldierCorona);
        setCorona(corona);
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

    private boolean setRegular(ArrayList<BallotBox<Regular>> ballotBoxes) {
        try {
            if (ballotBoxes != null)
                this.regular = new ArrayList<>(ballotBoxes);
            else
                this.regular = new ArrayList<>();
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
    }

    private boolean setCorona(ArrayList<BallotBox<Corona>> ballotBoxes) {
        try {
            if (ballotBoxes != null)
                this.corona = new ArrayList<>(ballotBoxes);
            else
                this.corona = new ArrayList<>();
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
    }

    private boolean setSoldier(ArrayList<BallotBox<Soldier>> ballotBoxes) {
        try {
            if (ballotBoxes != null)
                this.soldier = new ArrayList<>(ballotBoxes);
            else
                this.soldier = new ArrayList<>();
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
    }

    private boolean setSoldierCorona(ArrayList<BallotBox<SoldierCorona>> ballotBoxes) {
        try {
            if (ballotBoxes != null)
                this.soldierCorona = new ArrayList<>(ballotBoxes);
            else
                this.soldierCorona = new ArrayList<>();
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
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
        for (Map.Entry<Party, Integer> party: parties.entrySet()) {
            sb.append(party.getKey().getName() + "(" + party.getKey().getSection() + ") ");
        }
        return sb.toString();
    }

    /************** Functions **************/
    public boolean addBallotBoxes(ArrayList<BallotBox<Citizen>> ballotBoxes, String type) {
        try {
            if (type.equals("Regular"))
                for (BallotBox<Citizen> ballotBox : ballotBoxes)
                    regular.add(new BallotBox<Regular>(ballotBox));
            else if (type.equals("Corona"))
                for (BallotBox<Citizen> ballotBox : ballotBoxes)
                    corona.add(new BallotBox<Corona>(ballotBox));
            else if (type.equals("Soldier"))
                for (BallotBox<Citizen> ballotBox : ballotBoxes)
                    soldier.add(new BallotBox<Soldier>(ballotBox));
            else if (type.equals("SoldierCorona"))
                for (BallotBox<Citizen> ballotBox : ballotBoxes)
                    soldierCorona.add(new BallotBox<SoldierCorona>(ballotBox));
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        } //catch(TypeMissMatch )
    }

    public void addBallotBox(BallotBox<Citizen> ballotBox, String type) {
        try {
            if (type.equals("Regular"))
                regular.add(new BallotBox<Regular>(ballotBox));
            else if (type.equals("Corona"))
                corona.add(new BallotBox<Corona>(ballotBox));
            else if (type.equals("Soldier"))
                soldier.add(new BallotBox<Soldier>(ballotBox));
            else if (type.equals("SoldierCorona"))
                soldierCorona.add(new BallotBox<SoldierCorona>(ballotBox));
        } catch (Exception e) {
            System.out.println("Something went wrong");
        } //catch(TypeMissMatch )
    }

    public void addCitizenToBallotBoxes(Citizen citizen, BallotBox<Citizen> ballotBox) {
        try {
            if (citizen instanceof Corona) {
                if (corona.contains(ballotBox))
                    corona.get(corona.indexOf(ballotBox)).addCitizen(citizen);
            } else if (citizen instanceof Regular) {
                if (corona.contains(ballotBox))
                    corona.get(corona.indexOf(ballotBox)).addCitizen(citizen);
            } else if (citizen instanceof Soldier) {
                if (corona.contains(ballotBox))
                    corona.get(corona.indexOf(ballotBox)).addCitizen(citizen);
            } else if (citizen instanceof SoldierCorona) {
                if (corona.contains(ballotBox))
                    corona.get(corona.indexOf(ballotBox)).addCitizen(citizen);
            }
        } catch (Exception e){
            System.out.println();
        }

    }

/*    private void returnCitizen(Citizen citizen) {
        // finish
//        if (citizen instanceof Regular)
//            regular.
//        else if (citizen instanceof Corona)
//            return new Corona((Corona)citizen);
//        else if (citizen instanceof Soldier)
//            return new Soldier((Soldier)citizen);
//        else if (citizen instanceof SoldierCorona)
//            return new SoldierCorona((SoldierCorona)citizen);
//        else
//            return null;
    }*/

    public boolean addParty(Party party) {
        if (party != null && !parties.containsKey(party)) {
            this.parties.put(party, 0);
            return true;
        }
        return false;
    }

    public void updateBallotBoxes(Party party) {
        for (BallotBox<Corona> ballotBox : corona)
            ballotBox.addParty(party);
        for (BallotBox<Corona> ballotBox : corona)
            ballotBox.addParty(party);
        for (BallotBox<Soldier> ballotBox : soldier)
            ballotBox.addParty(party);
        for (BallotBox<SoldierCorona> ballotBox : soldierCorona)
            ballotBox.addParty(party);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elections elections = (Elections) o;
        return month == elections.month &&
                year == elections.year &&
                Objects.equals(regular, elections.regular) &&
                Objects.equals(soldier, elections.soldier) &&
                Objects.equals(soldierCorona, elections.soldierCorona) &&
                Objects.equals(corona, elections.corona) &&
                Objects.equals(parties, elections.parties);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (BallotBox<Corona> ballotBox : corona)
            sb.append(ballotBox.toString() + "\n");
        for (BallotBox<Corona> ballotBox : corona)
            sb.append(ballotBox.toString() + "\n");
        for (BallotBox<Soldier> ballotBox : soldier)
            sb.append(ballotBox.toString() + "\n");
        for (BallotBox<SoldierCorona> ballotBox : soldierCorona)
            sb.append(ballotBox.toString() + "\n");
        return sb.toString();
    }
}
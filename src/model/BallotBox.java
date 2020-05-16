package model;

import model.citizens.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BallotBox<T extends Citizen> {
    /* Defaults:
       address: Afeka
       votePercentage: 0
       citizens.length: 0
       parties.length: 0
   */

    private static int numGen; // Auto generated
    private int id;
    private String address;
    private double votePercentage; // need ? Yes - Doesn't need to be showed up :D
    private HashMap<Party, Integer> parties;
    protected List<Citizen> citizens;

    private T t;

    /************* Constructor *************/
    public BallotBox(String address, List<Citizen> citizens, HashMap<Party, Integer> parties){
        setAddress(address);
        setCitizens(citizens);
        setParties(parties);
        this.votePercentage = 0;
        this.id = numGen;
        numGen++;
    }

    public BallotBox(String address) {
        this(address, null, null);
        this.votePercentage = 0;
    }

    public BallotBox(BallotBox ballotBox) {
        this(ballotBox.address, ballotBox.citizens, ballotBox.parties);
        this.votePercentage = ballotBox.votePercentage;
        this.id = ballotBox.id;
    }

    /************ Set Functions ************/
    private boolean setAddress(String address) {
        boolean isSet = false;
        if(address != null){
            this.address = address;
            isSet = true;
        }
        else
            this.address = "Afeka";
        return isSet;
    }

    private boolean setCitizens(List<Citizen> citizens){
        if (citizens != null && !citizens.isEmpty()){
            this.citizens = citizens;

            return true;
        }
        this.citizens = new ArrayList<Citizen>(0);
        return false;
    }

    private boolean setParties(HashMap<Party, Integer> parties){
        if (parties != null && !parties.isEmpty()) {
            this.parties = parties;
            return true;
        }
        this.parties = new HashMap<Party, Integer>(0);
        return false;
    }

    /************ Get Functions ************/
    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getVotePercentage() {
        double newPercentage = calculateVotePercentage();
        if (votePercentage != newPercentage)
            votePercentage = newPercentage;
        return votePercentage;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public HashMap<Party, Integer> getParties() {
        return parties;
    }

    public int getNumberOfCitizens() {
        return citizens.size();
    }

    public int getNumberOfParties() {
        return parties.size();
    }

    public T getCitizenType() {
         return t;
    }

    /************** Functions *************/
    public void vote(Citizen citizen, Party party) {
        // todo: try/catch 1 - null
        //                 2 - contains
        //                 3 - getVote
        if (party != null && citizen != null && parties.containsKey(party) &&
                citizens.contains(citizen) && !citizen.getVoted()) {
            citizen.vote();
            parties.put(party, parties.get(party) + 1);
            System.out.println(citizen.getName() + " ID " + citizen.getID() + " voted for" + party.getName());
        } else {
            System.out.println("Vote failed");
        }
    }

    private double calculateVotePercentage(){
        int voteSum = 0;
        if (!parties.isEmpty()){
            for (int value: parties.values())
                voteSum += value;
            voteSum = (voteSum / parties.size()) * 100;
        }
        return voteSum;
    }

    public void addCitizen(Citizen citizen) {
        if (citizen != null && !citizens.contains(citizen))
            citizens.add(citizen);
    }

    public void addParty(Party party) {
        if (party != null && !parties.containsKey(party))
            this.parties.put(party, 0);
    }

    public boolean equals(BallotBox ballotBox) {
        if (ballotBox == null && this == null)
            return true;
        else if (ballotBox == null || this == null)
            return false;
        return address.equals(ballotBox.address); // enough to check only address
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BallotBox #" + id + "\n");
        sb.append("Address : " + address + "\n");
        return sb.toString();
    }
}
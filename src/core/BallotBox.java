package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class BallotBox {
    /* Defaults:
       address: Afeka
       votePercentage: 0
       citizens.length: 0
       parties.length: 0
   */

//    TODO: do we really need to check for null in subclasses ???

    private static int numGen; // auto generated
    private int id;
    private String address;
    private double votePercentage;
    private HashMap<Party, Integer> parties;
    protected List<Citizen> citizens;

    /************ Constructor ************/
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

    /************** Functions **************/
//    public abstract boolean canVote(Citizen citizen);

    protected boolean canVote(Citizen citizen){
        if(citizen != null && citizens.contains(citizen) && !citizen.getVoted())
            return true;
        return false;
    }

    public void vote(Citizen citizen, Party party) {  // TODO: add try catch to avoid null checks?
        if (party != null && citizen != null && parties.containsKey(party) &&
                            citizens.contains(citizen) && !citizen.getVoted()) {
            citizen.vote();
            parties.put(party, parties.get(party) + 1);
            System.out.println(citizen.getName() + " ID " + citizen.getID() + " voted for" + party.getName());
        }
        System.out.println("Vote failed");
    }

    private double calculateVotePercentage(){
        int voteSum = 0;
        for (int value: parties.values())
            voteSum += value;
        if (!parties.isEmpty())
            voteSum = (voteSum / parties.size()) * 100;
        return voteSum;
    }

    public void addCitizen(Citizen citizen){
        if (citizen != null && !citizens.contains(citizen))
            citizens.add(citizen);

        /*try{
            citizens.add(citizen);
        }catch(NullPointerException npe){
            System.out.println("Well done, you added nothing to an existing list.");
        }*/
    }

    public void addCitizens(Citizen... citizens){
        if(citizens != null && citizens.length != 0){
            for (Citizen citizen: citizens){
                addCitizen(citizen);
            }
        }
    }

    public void addParty(Party party){
        if (party != null && !parties.containsKey(party))
            this.parties.put(party, 0);
    }

    public void addParties(Party... parties){
        if (parties != null && parties.length != 0){
            for (Party party: parties)
                addParty(party);
        }
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
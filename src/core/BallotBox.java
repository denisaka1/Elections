package core;

import java.util.Arrays;
import java.util.Objects;

public abstract class BallotBox {
    /* Defaults:
       address: Afeka
       votePercentage: 0
       citizens.length: 0
       parties.length: 0
       votesForParty.length: 0
   */
    protected static int numGen; // auto generated
    private String address;
    private int votePercentage; // total of legal citizens that can vote to a specific ballot box
    private Citizen[] citizens; // list of all citizens that can vote to this specific ballotBox
    private Party[] parties;
    private int[] votesForParty;
    private int citizenCounter;
    private int partiesCounter;

    /************ Constructor ************/
    public BallotBox(String address, int votePercentage, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        setAddress(address);
        setVotePercentage(votePercentage);
        setCitizens(citizens);
        setParties(parties);
        setVotesForParty(votesForParty);
        numGen++;
    }

    public BallotBox(String address) {
        this(address, 0, new Citizen[0], new Party[0],new int[0]);
    }

    public BallotBox(BallotBox ballotBox){
        this(ballotBox.address, ballotBox.votePercentage, ballotBox.citizens, ballotBox.parties, ballotBox.votesForParty);
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

    private boolean setVotePercentage(int votePercentage) {
        boolean isSet = false;
        if(votePercentage >= 0) {
            this.votePercentage = votePercentage;
            isSet = true;
        }else
            this.votePercentage = -1;
        return isSet;
    }

    private boolean setCitizens(Citizen[] citizens) {
        if (citizens != null) {
            this.citizens = citizens;
            citizenCounter = this.citizens.length;
            return true;
        }
        this.citizens = new Citizen[0];
        return false;
    }

    private boolean setParties(Party[] parties) {
        if (parties != null) {
            this.parties = parties;
            partiesCounter = this.parties.length;
            return true;
        }
        this.parties = new Party[0];
        return false;
    }

    private boolean setVotesForParty(int[] votesForParty) {
        boolean isSet = true;
        if(votesForParty == null || parties.length == 0 || votesForParty.length == 0) {
            this.votesForParty = new int[0];
            isSet = false;
        }else{
            this.votesForParty = new int[parties.length];
            for (int i = 0; i < parties.length; i++) {
                this.votesForParty[i] = votesForParty[i];
            }
        }
        return isSet;
    }

    /************ Get Functions ************/
    public static int getNumGen() {
        return numGen;
    }

    public int getVotePercentage() {
        return votePercentage;
    }

    public String getAddress() {
        return address;
    }

    public int getTotalVotePercentage() {
        calculateTotalVotePercentage();
        return votePercentage;
    }

    public Citizen[] getCitizens() {
        return citizens;
    }

    public Party[] getParties() {
        return parties;
    }

    public int[] getVotesForParty() {
        return votesForParty;
    }

    /************** Functions **************/
    public void vote(Citizen citizen, Party party) {
        if(party != null && isPartyExists(party) && canVote(citizen)) {
            citizen.vote();
            addVote(party);
        }
    }

    private void calculateTotalVotePercentage() {
        int votesSum = 0;
        for(int i = 0; i < votesForParty.length; i++) {
            votesSum += votesForParty[i];
        }
        if (citizens.length > 0)
            votePercentage = (votesSum / citizens.length) * 100;
    }

    // Citizen
//    private void expandCitizens() {
//        Citizen[] temp = new Citizen[citizens.length * 2];
//        for (int i = 0; i < citizens.length; i++) {
//            temp[i] = citizens[i];
//        }
//        this.citizens = temp;
//    }
//
//    public boolean addCitizen(Citizen citizen) {
//        if (citizens.length == 0) {
//            this.citizens = new Citizen[1];
//        }
//
//        if (citizenCounter >= citizens.length) {
//            expandCitizens();
//            addCitizen(citizen);
//        } else if (isCitizenExists(citizen)) {
//            return false;
//        } else {
//            citizens[citizenCounter] = citizen;
//            citizens[citizenCounter].setBallotBox(this);
//            citizenCounter++;
//            return true;
//        }
//        return false;
//    }

//    protected boolean isCitizenExists(Citizen citizen) {
//        for (int i = 0; i < citizens.length; i++) {
//            if (citizens[i] != null) {
//                if (citizens[i].equals(citizen))
//                    return true;
//            }
//        }
//        return false;
//    }

    // Party
//    private void expandParties() {
//        Party[] temp = new Party[parties.length * 2];
//        int[] votesTemp = new int[parties.length * 2];
//
//        for (int i = 0; i < parties.length; i++) {
//            temp[i] = parties[i];
//            votesTemp[i] = votesForParty[i];
//        }
//        this.parties = temp;
//        this.votesForParty = votesTemp;
//    }
//
//    public boolean addParty(Party party) {
//        if (parties.length == 0) {
//            this.parties = new Party[1];
//            this.votesForParty = new int[1];
//        }
//
//        if (partiesCounter >= parties.length) {
//            expandParties();
//            addParty(party);
//        } else if (existParty(party)) {
//            return false;
//        } else {
//            parties[partiesCounter] = party;
//            partiesCounter++;
//            return true;
//        }
//        return false;
//    }

//    private boolean existParty(Party party) {
//        for (int i = 0; i < parties.length; i++) {
//            if (parties[i] != null) {
//                if (parties[i].equals(party))
//                    return true;
//            }
//        }
//        return false;
//    }

    public void addCitizens(Citizen... newCitizens){
        // assign temp Citizen array -> first comes base array
        //                           -> second comes the new array
        int k = newCitizens.length + this.citizens.length;
        Citizen[] temp = new Citizen[k * 2];
        for(int i = 0; i < k; i++){
            if (this.citizens.length > i)
                temp[i] = this.citizens[i];
            else {
                if (newCitizens[i - this.citizens.length] != null) {
                    temp[i] = newCitizens[i - this.citizens.length];
                    citizenCounter++;
                    temp[i].setBallotBox(this);
                }
            }
        }

        this.citizens = temp;
    }

    public void addParties(Party... newParties) {

        int k = newParties.length + this.parties.length;
        Party[] tempParty = new Party[k * 2];
        int[] tempVoteForParty = new int[k * 2];

        for (int i = 0; i < k; i++) {
            if (this.parties.length > i) {
                tempParty[i] = this.parties[i];
                tempVoteForParty[i] = this.votesForParty[i];
            } else {
                if (newParties[i - this.parties.length] != null) {
                    tempParty[i] = newParties[i - this.parties.length];
                    partiesCounter++;
                }
            }
        }

        this.parties = tempParty;
        this.votesForParty = tempVoteForParty;
    }

    protected boolean isCitizenExists(Citizen newCitizen){
        boolean exists = false;
        for(Citizen citizen: citizens){
            if(citizen != null && newCitizen != null)
                if(citizen.equals(newCitizen))
                    exists = true;
        }
        return exists;
    }

    private boolean isPartyExists(Party newParty){
        for(Party party: parties){
            if(party != null && newParty != null)
                if(party.equals(newParty))
                    return true;
        }
        return false;
    }

    protected void addVote(Party party){
        for(int i = 0; i < parties.length; i++){
            if(party.equals(parties[i])){
                votesForParty[i]++;
                System.out.println("Vote has been added!\n#added to party number:" + i + "\n#added to votesForParty number" + i);
            }
        }
    }

    abstract public boolean canVote(Citizen citizen);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallotBox ballotBox = (BallotBox) o;
        return votePercentage == ballotBox.votePercentage &&
                Objects.equals(address, ballotBox.address) &&
                Arrays.equals(citizens, ballotBox.citizens) &&
                Arrays.equals(parties, ballotBox.parties) &&
                Arrays.equals(votesForParty, ballotBox.votesForParty);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BallotBox #" + numGen + "\n");
        sb.append("Address : " + address + "\n");
        return sb.toString();
    }

}
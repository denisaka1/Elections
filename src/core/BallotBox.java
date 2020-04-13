package core;

import java.util.Arrays;
import java.util.Objects;

public abstract class BallotBox {
    /* Defaults:
       address: Afeka
       votePercentage: 0
       citizens: null
       parties: null
       votesForParty: null
   */
    private static int numGen; // auto generated
    private String address;
    private int votePercentage; // total of legal citizens that can vote to a specific ballot box
    private Citizen[] citizens; // list of all citizens that can vote to this specific ballotBox
    private Party[] parties;
    private int[] votesForParty;

    /************ Constructor ************/
    public BallotBox(String address, int votePercentage, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        setAddress(address);
        setLegalCitizens(votePercentage);
        setCitizens(citizens);
        setParties(parties);
        setVotesForParty(votesForParty);
        numGen++;
    }

    public BallotBox(String address) {
        this(address, 0, null, null,null);
    }

    private boolean setAddress(String address){
        boolean isSet = false;
        if(address != null){
            this.address = address;
            isSet = true;
        }
        else
            this.address = "Afeka";
        return isSet;
    }

    private boolean setLegalCitizens(int legalCitizens){
        boolean isSet = false;
        if(legalCitizens >= 0){
            this.votePercentage = legalCitizens;
            isSet = true;
        }else
            this.votePercentage = -1;
        return isSet;
    }

    private boolean setCitizens(Citizen[] citizens){
        boolean isSet = true;
        if(citizens == null || citizens.length == 0){
            isSet = false;
        }else{
            this.citizens = new Citizen[citizens.length];
            for (int i = 0; i < citizens.length; i++) {
                this.citizens[i] = new Citizen(citizens[i]);
            }
        }
        return isSet;
    }

    private boolean setParties(Party[] parties){
        boolean isSet = true;
        if(parties == null || parties.length == 0){
            isSet = false;
        }else{
            this.parties = new Party[parties.length];
            for (int i = 0; i < parties.length; i++) {
                this.parties[i] = new Party(parties[i]);
            }
        }
        return isSet;
    }

    private boolean setVotesForParty(int[] votesForParty){
        boolean isSet = true;
        if(votesForParty == null || votesForParty.length != parties.length || votesForParty.length == 0){
            isSet = false;
        }else{
            this.votesForParty = new int[votesForParty.length];
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

    public String getAddress() {
        return address;
    }

    public int getLegalCitizens() {
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
    abstract public void vote(Citizen citizen, Party party, int currentYear);
    abstract public boolean canVote(Citizen citizen, int year);

    public void updateVotePercentage(){
        int votesSum = 0;
        for(int i = 0; i < votesForParty.length; i++){
            votesSum += votesForParty[i];
        }
        votePercentage = (votesSum / citizens.length) * 100;
    }

    public void addCitizensToBallotBox(Citizen... citizens){
        setCitizens(citizens);
    }

    protected void addVote(Party party){
        for(int i = 0; i < parties.length; i++){
            if(party.equals(parties[i])){
                votesForParty[i]++;
                System.out.println("Vote has been added!");
            }
        }
    }

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
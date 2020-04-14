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
    private static int numGen; // auto generated
    private String address;
    private int votePercentage; // total of legal citizens that can vote to a specific ballot box
    private Citizen[] citizens; // list of all citizens that can vote to this specific ballotBox
    protected Party[] parties;
    private int[] votesForParty;

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

    private boolean setVotePercentage(int votePercentage){
        boolean isSet = false;
        if(votePercentage >= 0){
            this.votePercentage = votePercentage;
            isSet = true;
        }else
            this.votePercentage = -1;
        return isSet;
    }

    private boolean setCitizens(Citizen[] citizens){
        boolean isSet = true;
        if(citizens == null || citizens.length == 0){
            this.citizens = new Citizen[0];
            isSet = false;
        }else{
            this.citizens = new Citizen[citizens.length * 2];
            for (int i = 0; i < citizens.length; i++) {
                this.citizens[i] = new Citizen(citizens[i]);
            }
        }
        return isSet;
    }

    private boolean setParties(Party[] parties){
        boolean isSet = true;
        if(parties == null || parties.length == 0){
            this.parties = new Party[0];
            isSet = false;
        }else{
            this.parties = new Party[parties.length * 2];
            for (int i = 0; i < parties.length; i++) {
                this.parties[i] = new Party(parties[i]);
            }
        }
        return isSet;
    }

    private boolean setVotesForParty(int[] votesForParty){
        boolean isSet = true;
        if(votesForParty == null || parties.length == 0 || votesForParty.length == 0){
            this.votesForParty = new int[0];
            isSet = false;
        }else{
            this.votesForParty = new int[parties.length * 2];
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

    public int getTotalVotePerecentage() {
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
    public void vote(Citizen citizen, Party party, int year){
        boolean isInArmy = citizen.getBallotBox() instanceof Army;
        if(party != null && isPartyExists(party)){
            if(isInArmy){
                if(canVote(citizen, year)){
                    citizen.vote();
                    addVote(party);
                }
            }else{
                if(canVote(citizen, 0)){
                    citizen.vote();
                    addVote(party);
                }
            }
        }
    }

    abstract public boolean canVote(Citizen citizen, int year);

    private void calculateTotalVotePercentage(){
        int votesSum = 0;
        for(int i = 0; i < votesForParty.length; i++){
            votesSum += votesForParty[i];
        }
        votePercentage = (votesSum / citizens.length) * 100;
    }

    public void addCitizens(Citizen... newCitizens){
        // assign temp Citizen array -> first comes base array
        //                           -> second comes the new array

        Citizen[] temp = new Citizen[(newCitizens.length + this.citizens.length) * 2];

        int k = temp.length - this.citizens.length;
        for(int i = 0; i < temp.length; i++){
            if(k > i)
                temp[i] = new Citizen(this.citizens[i]);
            else
                temp[i] = new Citizen(newCitizens[i-k]);
        }

//        for(int i = 0; i < this.citizens.length; i++){
//            temp[i] = new Citizen(this.citizens[i]);
//        }
//
//
//        for(int i = 0; i < newCitizens.length; i++){
//            k += i;
//            temp[k] = new Citizen(newCitizens[i]);
//        }

        this.citizens = new Citizen[temp.length];
        for(int i = 0; i < temp.length; i++){
            this.citizens[i] = temp[i];
        }

    }

    public void addParties(Party... newParties){
        // assign tempParty array -> first comes base array
        //                        -> second comes the new array
        // assign tempVoteForParty -> first comes the base array
        //

        Party[] tempParty = new Party[(newParties.length + this.parties.length) * 2];
        int[] tempVoteForParty = new int[tempParty.length];

        int k = tempParty.length - this.parties.length;
//        for(int i = 0; i < this.parties.length; i++){
//            tempParty[i] = new Party(this.parties[i]);
//            tempVoteForParty[i] = votesForParty[i];
//        }


//        for(int i = 0; i < newParties.length; i++){
//            k += i;
//            tempParty[k] = new Party(newParties[i]);
//        }

        for(int i = 0; i < tempParty.length; i++){
            if(k > i){
                tempParty[i] = new Party(this.parties[i]);
                tempVoteForParty[i] = votesForParty[i];
            }else
                tempParty[i] = new Party(newParties[i - k]);
        }

        this.parties = new Party[tempParty.length];
        this.votesForParty = new int[parties.length];
        for(int i = 0; i < parties.length; i++){
            parties[i] = tempParty[i];
            votesForParty[i] = tempVoteForParty[i];
        }
    }

    protected boolean isCitizenExists(Citizen newCitizen){
        boolean exists = false;
        for(Citizen citizen: citizens){
            if(citizen.equals(newCitizen))
                exists = true;
        }
        return exists;
    }

    private boolean isPartyExists(Party newParty){
        boolean exists = false;
        for(Party party: parties){
            if(party.equals(newParty))
                exists = true;
        }
        return exists;
    }

    protected void addVote(Party party){
        for(int i = 0; i < parties.length; i++){
            if(party.equals(parties[i])){
                votesForParty[i]++;
//                System.out.println("Vote has been added!\n#added to party number:" + i + "\n#added to votesForParty number" + i);
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
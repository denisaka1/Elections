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
    private int id;
    private String address;
    private int votePercentage; // total of legal citizens that can vote to a specific ballot box
    private Citizen[] citizens; // list of all citizens that can vote to this specific ballotBox
    private Party[] parties;
    private int[] votesForParty;
    protected int citizenCounter;
    protected int partiesCounter;

    /************ Constructor ************/
    public BallotBox(String address, int votePercentage, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        setAddress(address);
        setVotePercentage(votePercentage);
        setCitizens(citizens);
        setParties(parties);
        setVotesForParty(votesForParty);
        this.id = numGen;
        numGen++;
    }

    public BallotBox(String address) {
        this(address, 0, new Citizen[0], new Party[0],new int[0]);
    }

    public BallotBox(BallotBox ballotBox){
        this(ballotBox.address, ballotBox.votePercentage, ballotBox.citizens, ballotBox.parties, ballotBox.votesForParty);
        this.citizenCounter = ballotBox.citizenCounter;
        this.partiesCounter = ballotBox.partiesCounter;
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

    public int getNumberOfCitizens(){
        return citizenCounter;
    }

    public int getNumberOfParties(){
        return partiesCounter;
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
                if (newCitizens[i - this.citizens.length] != null && !isCitizenExists(newCitizens[i - this.citizens.length])) {
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

        int newPartiesCounter = 0;
        for (int i = 0; i < k; i++) {
            if (this.parties.length > i) {
                if (this.parties[i] != null) {
                    tempParty[i] = this.parties[i];
                    tempVoteForParty[i] = this.votesForParty[i];
                } else {
                    if (newPartiesCounter < newParties.length) {
                        tempParty[i] = newParties[newPartiesCounter];
                        partiesCounter++;
                        newPartiesCounter++;
                    }
                }
            } else {
                if (newPartiesCounter < newParties.length) {
                    tempParty[i] = newParties[newPartiesCounter];
                    partiesCounter++;
                    newPartiesCounter++;
                }
            }
        }

/*        for (int i = 0; i < k; i++) {
            if (this.parties.length > i) {
                tempParty[i] = this.parties[i];
                tempVoteForParty[i] = this.votesForParty[i];
            } else {
                if (newParties[i - this.parties.length] != null && !isPartyExists(newParties[i - this.parties.length])) {
                    tempParty[i] = newParties[i - this.parties.length];
                    partiesCounter++;
                }
            }
        }*/

        this.parties = tempParty;
        this.votesForParty = tempVoteForParty;
    }

    private void sortParties() {
        for (int i = 0; i < this.parties.length; i++) {

        }
    }

    protected boolean isCitizenExists(Citizen newCitizen) {
        boolean exists = false;
        for (Citizen citizen: citizens) {
            if (citizen != null && newCitizen != null)
                if (citizen.equals(newCitizen))
                    exists = true;
        }
        return exists;
    }

    private boolean isPartyExists(Party newParty) {
        for (Party party: parties) {
            if (party != null && newParty != null)
                if (party.equals(newParty))
                    return true;
        }
        return false;
    }

    protected void addVote(Party party) {
        for (int i = 0; i < parties.length; i++) {
            if (party.equals(parties[i])) {
                votesForParty[i]++;
                System.out.println("Vote has been added!\n#added to party number:" + i + "\n#added to votesForParty number " + i );
            }
        }
    }

    abstract public boolean canVote(Citizen citizen);

    public boolean equals(BallotBox other) {
        if (other == null && this == null) return true;
        else
            return votePercentage == other.votePercentage &&
                    address.equals(other.address) &&
                    Arrays.equals(citizens, other.citizens) &&
                    Arrays.equals(parties, other.parties) &&
                    Arrays.equals(votesForParty, other.votesForParty);
    }


/*    private boolean isSameCitizens(Citizen[] other){
        boolean isSame = true;
        for(int i = 0; i < citizenCounter; i++){
            if(isSame && ( citizens[i] == null || other[i] == null ) && !citizens[i].equals(other[i]) )
                isSame = false;
        }
        return isSame;
    }

    private boolean isSamePartiesAndVoteForParty(Party[] otherParties, int[] otherVotes){
        boolean isSame = true;
        for(int i = 0; i < partiesCounter; i++){
            if(isSame && ( parties[i] == null || otherParties[i] == null ) && !parties[i].equals(otherParties[i]) &&
                votesForParty[i] != otherVotes[i])
                isSame = false;
        }
        return isSame;
    }

    /*
    // use only if the function isSamePartiesAndVoteForParty doesn't work for votes
    private boolean isSameVoteForParties(int[] other){
        boolean isSame = true;
        for(int i = 0; i < partiesCounter; i++){
            if(isSame && votesForParty[i] != other[i])
                isSame = false;
        }
        return isSame;
    }


    public boolean equals(BallotBox other){
        if(other != null){
            boolean isSameAddress = address.equals(other.address);
            boolean isSameVotePercentage = votePercentage == other.votePercentage;

            boolean isSameCitizenCounter = citizenCounter == other.citizenCounter;
            boolean isSameCitizens = false;
            if(isSameCitizenCounter)
                isSameCitizens = isSameCitizens(other.citizens);

            boolean isSamePartyCounter = partiesCounter == other.partiesCounter;
            boolean isSamePartiesAndVotes = false;
            if(isSamePartyCounter)
                isSamePartiesAndVotes = isSamePartiesAndVoteForParty(other.parties, other.votesForParty);

            if(isSameAddress && isSameVotePercentage && isSameCitizens && isSamePartiesAndVotes)
                return true;
        }

        return false;

    }*/

    // String address, int votePercentage, Citizen[] citizens, Party[] parties, int[] votesForParty

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BallotBox #" + id + "\n");
        sb.append("Address : " + address + "\n");
        return sb.toString();
    }

}
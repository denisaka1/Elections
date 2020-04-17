package core;

public class Regular extends BallotBox {
    /* Defaults:
       extends from BallotBox
     */

    public Regular(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Regular(String address) {
        this(address, 0, new Citizen[0], new Party[0],new int[0]);
    }

    public Regular(Regular regular){
        this(regular.getAddress(), regular.getVotePercentage(), regular.getCitizens(), regular.getParties(), regular.getVotesForParty());
        this.citizenCounter = regular.citizenCounter;
        this.partiesCounter = regular.partiesCounter;
    }

    @Override
    public boolean canVote(Citizen citizen) {
        boolean canVote = false;

        if(!citizen.getVoted() && !citizen.isIsolation())
            canVote = true;

        return canVote;
    }

    public boolean equals(Regular other){
        return super.equals(other);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Type : Regular\n");
        return sb.toString();
    }
}
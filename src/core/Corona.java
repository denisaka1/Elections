package core;

public class Corona extends BallotBox {
    /* Defaults:
       extends from BallotBox
     */

    public Corona(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Corona(String address) {
        this(address, 0, new Citizen[0], new Party[0],new int[0]);
    }

    public Corona(Corona corona){
        this(corona.getAddress(), corona.getVotePercentage(), corona.getCitizens(), corona.getParties(), corona.getVotesForParty());
    }

    @Override
    public boolean canVote(Citizen citizen) {
        boolean canVote = false;
        boolean isCitizenExists = isCitizenExists(citizen);
        if(citizen.isIsolation() && !citizen.getVoted() && isCitizenExists)
            canVote = true;

        return canVote;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Type : Corona\n");
        return sb.toString();
    }
}
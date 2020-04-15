package core;

public class Regular extends BallotBox {
    /* Defaults:
       extends from BallotBox
     */

    public Regular(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Regular(String address) {
        super(address);
    }

    public Regular(Regular regular){
        super(regular);
    }

    @Override
    public boolean canVote(Citizen citizen) {
        boolean canVote = false;

        if(!citizen.getVoted() && !citizen.isIsolation())
            canVote = true;

        return canVote;
    }
}
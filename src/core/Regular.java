package core;

public class Regular extends BallotBox {
    public Regular(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Regular(String address) {
        super(address);
    }

    @Override
    public boolean canVote(Citizen citizen, int year) {
        boolean canVote = false;

        if(!citizen.getVoted() && !citizen.isIsolation())
            canVote = true;

        return canVote;

    }

}
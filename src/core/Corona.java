package core;

public class Corona extends BallotBox {
    public Corona(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Corona(String address) {
        super(address);
    }

    @Override
    public void vote(Citizen citizen, Party party, int currentYear) {
        // TODO: Corona vote
    }

    @Override
    public boolean canVote(Citizen citizen, int year) {
        // TODO: Corona canVote
        return false;
    }

    @Override
    public boolean equals(Object obj){
        return true;
    } // TODO: Corona equals
}

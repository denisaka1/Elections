package core;

public class Corona extends BallotBox {
    public Corona(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Corona(String address) {
        super(address);
    }

    @Override
    public boolean canVote(Citizen citizen, int year) {
        boolean canVote = false;
        boolean isCitizenExists = isCitizenExists(citizen);
        if(citizen.isIsolation() && !citizen.getVoted() && isCitizenExists)
            canVote = true;

        return canVote;
    }
}




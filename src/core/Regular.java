package core;

public class Regular extends BallotBox {
    public Regular(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Regular(String address) {
        super(address);
    }

    @Override
    public void vote(Citizen citizen, Party party, int currentYear) {
        


    }

    @Override
    public boolean canVote(Citizen citizen, int year) {
        int citizenAge = year - citizen.getBirthYear();
        boolean canVote;

        if(!citizen.getVoted() && citizenAge >= 18)
            canVote = true;
        else
            canVote = false;

        return canVote;
    }

    public boolean equals(Object obj){
        return true;
    }
}
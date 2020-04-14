package core;

public class Army extends BallotBox {
    public Army(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Army(String address) {
        super(address);
    }

    @Override
    public boolean canVote(Citizen citizen, int year) {
        boolean isCitizenExists = isCitizenExists(citizen);
        boolean canVote = false;
        boolean isLegalAge = year - citizen.getBirthYear() >= 18 && year - citizen.getBirthYear() <= 21;

        if(isCitizenExists && !citizen.getVoted() && !citizen.isIsolation() && isLegalAge)
            canVote = true;
        return canVote;
    }

}
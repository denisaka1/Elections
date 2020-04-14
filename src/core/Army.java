package core;

public class Army extends BallotBox {
    public Army(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Army(String address) {
        super(address);
    }

    @Override
    public void vote(Citizen citizen, Party party, int currentYear) {
        boolean voted;
        boolean isLegalAge = currentYear - citizen.getBirthYear() >= 18 && currentYear - citizen.getBirthYear() <= 21;
        if(!citizen.getVoted() && !citizen.isIsolation() && isLegalAge){
            voted = true;
            citizen.setVoted(voted);
            addVote(party);
        }else{
            voted = false;
            System.out.println("Couldn't vote because of reasons..."); // add it normally
        }


    }

    @Override
    public boolean equals(Object obj){
        return true;
    } // TODO: Army equals

    @Override
    public boolean canVote(Citizen citizen, int year) {
        boolean canVote;
        boolean isLegalAge = year - citizen.getBirthYear() >= 18 && year - citizen.getBirthYear() <= 21;
        if(!citizen.getVoted() && !citizen.isIsolation() && isLegalAge){
            canVote = true;
        }else{
            canVote = false;
        }
        return canVote;
    }

}
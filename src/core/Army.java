package core;

public class Army extends BallotBox {
    public Army(String address, int legalCitizens, Citizen[] citizens, int[] parties, int numberOfParties) {
        super(address, legalCitizens, citizens, parties, numberOfParties);
    }

    public Army(String address) {
        super(address);
    }

    @Override
    public void vote(Citizen citizen, Party party) {

    }

    @Override
    public boolean canVote(Citizen citizen) {
        return false;
    }
}
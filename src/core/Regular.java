package core;

public class Regular extends BallotBox {
    public Regular(String address, int legalCitizens, Citizen[] citizens, int[] parties, int numberOfParties) {
        super(address, legalCitizens, citizens, parties, numberOfParties);
    }

    public Regular(String address, int legalCitizens) {
        super(address, legalCitizens);
    }

    @Override
    public void vote(Citizen citizen, Party party) {

    }
}
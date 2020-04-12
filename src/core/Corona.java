package core;

public class Corona extends BallotBox {
    public Corona(String address, int legalCitizens, Citizen[] citizens, int[] parties, int numberOfParties) {
        super(address, legalCitizens, citizens, parties, numberOfParties);
    }

    public Corona(String address, int legalCitizens) {
        super(address, legalCitizens);
    }

    @Override
    public void vote(Citizen citizen, Party party) {

    }
}
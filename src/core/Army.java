package core;

public class Army extends BallotBox {
    public Army(String address, int legalCitizens, Citizen[] citizens, int[] parties, int numberOfParties) {
        super(address, legalCitizens, citizens, parties, numberOfParties);
    }

    public Army(String address, int legalCitizens) {
        super(address, legalCitizens);
    }
}
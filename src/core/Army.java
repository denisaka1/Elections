package core;

public class Army extends BallotBox {
    /* Defaults:
       same as for BallotBox
       year: 2020
     */
    private int year;

    /************ Constructor ************/
    public Army(String address, int votePercentage, Citizen[] citizens, Party[] parties, int[] votesForParty, int year) {
        super(address, votePercentage, citizens, parties, votesForParty);
        setYear(year);
    }

    public Army(String address) {
        this(address, 0, new Citizen[0], new Party[0], new int[0], 2020);
    }

    public Army(Army army){
        this(army.getAddress(), army.getTotalVotePerecentage(), army.getCitizens(), army.getParties(), army.getVotesForParty(), army.year);
    }

    /************ Set Functions ************/
    private boolean setYear(int year){
        boolean done = false;

        if(year >= 0){
            this.year = year;
            done = true;
        }else
            this.year = 2020;

        return done;
    }

    /************** Functions **************/
    @Override
    public boolean canVote(Citizen citizen) {
        boolean isCitizenExists = isCitizenExists(citizen);
        boolean canVote = false;
        boolean isLegalAge = year - citizen.getBirthYear() >= 18 && year - citizen.getBirthYear() <= 21;

        if(isCitizenExists && !citizen.getVoted() && !citizen.isIsolation() && isLegalAge)
            canVote = true;

        return canVote;
    }

}
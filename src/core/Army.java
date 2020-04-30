package core;

import java.util.HashMap;
import java.util.List;

public class Army extends BallotBox {
    /* Defaults:
       same as for BallotBox
       year: 2020
     */
    private int year;

    /************ Constructor ************/
    public Army(String address, List<Citizen> citizens, HashMap<Party, Integer> parties, int year) {
        super(address, citizens, parties);
        setYear(year);
    }

    public Army(String address) {
        this(address, null, null, 2020);
    }

    public Army(Army army){
        super(army);
        year = army.year;
    }

    /************ Set Functions ************/
    private boolean setYear(int year){
        if(year >= 0){
            this.year = year;
            return true;
        }else
            this.year = 2020;

        return false;
    }

    /************** Functions **************/
    @Override
    public boolean canVote(Citizen citizen) {
        boolean isLegalAge = year - citizen.getBirthYear() >= 18 && year - citizen.getBirthYear() <= 21;
        return super.canVote(citizen) && isLegalAge;
    }

    public boolean equals(Army army){
        return super.equals(army) && this.year == army.year;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Type : Army\n");
        return sb.toString();
    }
}
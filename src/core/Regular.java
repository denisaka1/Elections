package core;

import java.util.HashMap;
import java.util.List;

public class Regular extends BallotBox {
    /* Defaults:
       extends from BallotBox
     */

    public Regular(String address, List<Citizen> citizens, HashMap<Party, Integer> parties) {
        super(address, citizens, parties);
    }

    public Regular(String address) {
        this(address, null, null);
    }

    public Regular(Regular regular){
        super(regular);
    }

    @Override
    public boolean canVote(Citizen citizen) {
        return super.canVote(citizen);
    }

    public boolean equals(Regular regular){
        return super.equals(regular);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Type : Regular\n");
        return sb.toString();
    }
}
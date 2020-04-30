package core;

import java.util.HashMap;
import java.util.List;

public class Corona extends BallotBox {
    /* Defaults:
       extends from BallotBox
     */

    public Corona(String address, List<Citizen> citizens, HashMap<Party, Integer> parties) {
        super(address, citizens, parties);
    }

    public Corona(String address) {
        this(address, null, null);
    }

    public Corona(Corona corona){
        super(corona);
    }

    @Override
    public boolean canVote(Citizen citizen) {
        return super.canVote(citizen) && citizen.isIsolation();
    }

    public boolean equals(Corona corona){
        return super.equals(corona);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Type : Corona\n");
        return sb.toString();
    }
}
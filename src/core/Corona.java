package core;

public class Corona extends BallotBox {
    /* Defaults:
       extends from BallotBox
     */

    public Corona(String address, int legalCitizens, Citizen[] citizens, Party[] parties, int[] votesForParty) {
        super(address, legalCitizens, citizens, parties, votesForParty);
    }

    public Corona(String address) {
        super(address);
    }

    public Corona(Corona corona){
        super(corona);
    }

    @Override
    public boolean canVote(Citizen citizen) {
        boolean canVote = false;
        boolean isCitizenExists = isCitizenExists(citizen);
        if(citizen.isIsolation() && !citizen.getVoted() && isCitizenExists)
            canVote = true;

        return canVote;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BallotBox #" + numGen + "\n");
        sb.append("Address : " + address + "\n");
        sb.append("Type : Corona\n");
        return sb.toString();
    }
}
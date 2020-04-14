package core;

public class Citizen {
    private String name;
    private String id;
    private int birthYear;
    private boolean isolation; // bidud
    private BallotBox ballotBox; // kalpi eleha hu meshuyah
    private Party party;
    private boolean voted;

    /************ Constructor ************/
    public Citizen(String name, String id, int birthYear, boolean isolation, BallotBox ballotBox, Party party, boolean voted) {
        this.name = name;
        this.id = id;
        this.birthYear = birthYear;
        this.isolation = isolation;
        this.ballotBox = ballotBox;
        this.party = party;
        this.voted = voted;
    }

    public Citizen(Citizen citizen) {
        this(citizen.getName(), citizen.getID(), citizen.getBirthYear(), citizen.isIsolation(), citizen.getBallotBox(), citizen.getParty(), citizen.getVoted());
    }

    public Citizen(String name, String id, int birthYear, boolean isolation, Party party) {
        this (name, id, birthYear, isolation, null, party, false);
    }

    public Citizen(String name, String id, int birthYear) {
        this(name, id, birthYear, false, null, null, false);
    }

    /************ Get Functions ************/
    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public boolean isIsolation() {
        return isolation;
    }

    public BallotBox getBallotBox() {
        return ballotBox;
    }

    public Party getParty() {
        return party;
    }

    public boolean getVoted() {
        return voted;
    }

    /************ Set Functions ************/
    private void setIsolation(boolean isolation) {
        this.isolation = isolation;
    }

    private void setBallotBox(BallotBox ballotBox) { // TODO: Do Something
        this.ballotBox = ballotBox;
    }

    public void setInParty(Party party) {
        this.party = party;
    }

    private void setVoted(boolean voted) {
        this.voted = voted;
    }

    /************** Functions **************/
    public void vote() {
        this.voted = true;
    }


    @Override
    public boolean equals(Object obj) {
        Citizen citizen = (Citizen) obj;
        if ( !name.equals(citizen.getName()) || id != citizen.getID()
                || birthYear != citizen.birthYear || isolation != citizen.isolation
                || !ballotBox.equals(citizen.getBallotBox()) || party.equals(citizen.getParty())
                || voted != citizen.getVoted() )
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name : " + name + ", ID : " + id + ", Birth Year :" + birthYear + "\n");
        if (isolation)
            sb.append("In isolation \n");

        if (voted)
            sb.append("Voted in " + ballotBox + "\n");
        else
            sb.append("Vote in " + ballotBox + "\n");

        if (party != null)
            sb.append("Party : " + party.getName() + "\n");

        return sb.toString();
    }
}

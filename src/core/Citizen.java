package core;

public class Citizen {
    private String name;
    private int ID;
    private int birthYear;
    private boolean isolation; // bidud
    private BallotBox ballotBox; // kalpi eleha hu meshuyah
    private String inParty; // change name later?
    private boolean voted;

    /************ Constructor ************/
    public Citizen(String name, int ID, int birthYear, boolean isolation, BallotBox ballotBox, String inParty, boolean voted) {
        this.name = name;
        this.ID = ID;
        this.birthYear = birthYear;
        this.isolation = isolation;
        this.ballotBox = ballotBox;
        this.inParty = inParty;
        this.voted = voted;
    }

    public Citizen(String name, int ID, int birthYear) {
        this(name, ID, birthYear, false, null, "", false);
    }

    /************ Get Functions ************/
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
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

    public String getInParty() {
        return inParty;
    }

    public boolean getIsVoted() {
        return voted;
    }

    /************ Set Functions ************/
    public void setIsolation(boolean isolation) {
        this.isolation = isolation;
    }

    public void setBallotBox(BallotBox ballotBox) {
        this.ballotBox = ballotBox;
    }

    public void setInParty(String inParty) {
        this.inParty = inParty;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    /************** Functions **************/
    @Override
    public boolean equals(Object obj) {
        Citizen citizen = (Citizen) obj;
        if ( !name.equals(citizen.getName()) || ID != citizen.getID()
                || birthYear != citizen.birthYear || isolation != citizen.isolation
                || !ballotBox.equals(citizen.getBallotBox()) || inParty.equals(citizen.getInParty())
                || voted != citizen.getIsVoted() )
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name : " + name + ", ID : " + ID + ", Birth Year :" + birthYear + "\n");
        if (isolation)
            sb.append("In isolation \n");

        if (voted)
            sb.append("Voted in " + ballotBox + "\n");
        else
            sb.append("Vote in " + ballotBox + "\n");

        if (!inParty.isEmpty())
            sb.append("Party : " + inParty + "\n");

        return sb.toString();
    }
}

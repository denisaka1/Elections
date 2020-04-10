package core;

public class Citizen {
    private String name;
    private int ID;
    private int birthYear;
    private boolean isolation; // bidud
    private BallotBox kalpi; // kalpi eleha hu meshuyah
    private String inParty; // change name later?
    private boolean voted;

    /************ Constructor ************/
    public Citizen(String name, int ID, int birthYear, boolean isolation, BallotBox kalpi, String inParty, boolean voted) {
        this.name = name;
        this.ID = ID;
        this.birthYear = birthYear;
        this.isolation = isolation;
        this.kalpi = kalpi;
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

    public BallotBox getKalpi() {
        return kalpi;
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

    public void setKalpi(BallotBox kalpi) {
        this.kalpi = kalpi;
    }

    public void setInParty(String inParty) {
        this.inParty = inParty;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    /************** Functions **************/
    public boolean equals(Citizen citizen) {
        if ( !name.equals(citizen.getName()) || ID != citizen.getID()
                || birthYear != citizen.birthYear || isolation != citizen.isolation
                || !kalpi.equals(citizen.getKalpi()) || inParty.equals(citizen.getInParty())
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
            sb.append("Voted in " + kalpi + "\n");
        else
            sb.append("Vote in " + kalpi + "\n");

        if (!inParty.isEmpty())
            sb.append("Party : " + inParty + "\n");

        return sb.toString();
    }
}

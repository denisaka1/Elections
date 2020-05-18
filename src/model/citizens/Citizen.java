package model.citizens;

import model.BallotBox;
import model.Party;

public abstract class Citizen {
    /* Defaults:
      name: citizen
      id: 123456789
      birthYear: 1990
      isolation: false
      ballotBox: null       maybe empty object of ballotBox? you hate to deal with nulls huh?
      party: null           maybe empty object of party?     you hate to deal with nulls huh?
      voted: false
  */
    protected String name;
    protected String id;
    protected int birthYear;
    protected BallotBox ballotBox;
    protected Party party;
    protected boolean voted;
    protected boolean isInParty;
    protected boolean isInBallotBox;

    /************ Constructor *************/
    public Citizen(String name, String id, int birthYear, BallotBox ballotBox, Party party, boolean voted) {
        setName(name);
        setId(id);
        setBirthYear(birthYear);
        setBallotBox(ballotBox);
        setInParty(party);
        setVoted(voted);
    }

    public Citizen(Citizen citizen) {
        this(citizen.name, citizen.id, citizen.birthYear, citizen.ballotBox, citizen.party, citizen.voted);
        this.isInParty = citizen.isInParty;
        this.isInBallotBox = citizen.isInBallotBox;
    }

    public Citizen(String name, String id, int birthYear, BallotBox ballotBox) {
        this (name, id, birthYear, ballotBox, null, false);
    }

    public Citizen(String name, String id, int birthYear) {
        this(name, id, birthYear, null, null, false);
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

    public BallotBox getBallotBox() {
        return ballotBox;
    }

    public Party getParty() {
        return party;
    }

    public boolean getVoted() {
        return voted;
    }

    public boolean isInParty(){
        return isInParty;
    }

    public String getType () {
        if (this instanceof Corona)
            return "Corona";
        else if (this instanceof Regular)
            return "Regular";
        else if (this instanceof Soldier)
            return "Soldier";
        else if (this instanceof SoldierCorona)
            return "SoldierCorona";
        else
            return "Citizen";
    }

    /************ Set Functions ************/
    private boolean setName(String name){
        // todo: try/catch
        // checks if the citizen got multiple names
        // checks if there is a character that is not alphabetic in his name

        boolean done = false;
        String result = "";

        if (name != null) {
            String[] temp = name.split(" ");
            for (int i = 0; i < temp.length && !done; i++) {
                if (!temp[i].matches("^[a-zA-Z]*$")) {
                    done = true;
                } else {
                    result += temp[i] +" ";
                }
            }
        }

        if (done)
            this.name = "citizen";
        else
            this.name = result.substring(0, result.length() - 1);

        return done;
    }

    private boolean setId(String id) {
        // todo: try/catch
        boolean legalIdLength = id.length() >= 8 && id.length() <= 9;

        if (id != null && legalIdLength) {
            this.id = id;
            return true;
        } else
            this.id = "-1";

        return false;
    }

    private boolean setBirthYear(int birthYear) {
        // todo: try/catch
        if (birthYear >= 0){
            this.birthYear = birthYear;
            return true;
        } else
            this.birthYear = 1990;

        return false;
    }

    private boolean setBallotBox(BallotBox ballotBox) {
        // todo: try/catch
        if (ballotBox != null) {
            this.ballotBox = ballotBox;
            isInBallotBox = true;
        } else {
            this.ballotBox = null;
            return false;
        }
        return true;
    }

    private boolean setInParty(Party party) {
        // todo: try/catch
        if (party != null) {
            this.party = party;
            isInParty = true;
            return true;
        } else
            this.party = null;
        return false;
    }

    private boolean setVoted(boolean voted) {
        this.voted = voted;
        return voted;
    }

    /************** Functions **************/
    public boolean canVote() {
        if (voted == false)
            return true;
        return false;
    }

    public void assignToParty(Party party) {
        if (!isInParty) {
            setInParty(party);
            isInParty = true;
        }
    }

    public void assignToBallotBox(BallotBox ballotBox) {
        if (!isInBallotBox) {
            setBallotBox(ballotBox);
            isInBallotBox = true;
        }
    }

    public void vote(){
        if(canVote())
            setVoted(true);
    }

    public boolean equals(Citizen citizen) {
        if(citizen == null && this == null)
            return true;
        else if (citizen == null || this == null)
            return false;
        return id.equals(citizen.id); // enough to check only id
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("----------------\n");
        sb.append("Name : " + name + ", ID : " + id + ", Birth Year :" + birthYear + "\n");

        if (voted)
            sb.append("Voted in " + ballotBox + "\n");
        else
            sb.append("Can vote in " + ballotBox + "\n");

        if (party != null)
            sb.append("Party : " + party.getName() + "\n");

        return sb.toString();
    }
}
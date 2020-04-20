package core;

import java.util.Arrays;
import java.util.Objects;

public class Citizen {
    /* Defaults:
      name: citizen
      id: 123456789
      birthYear: 1990
      isolation: false
      ballotBox: null       maybe empty object of ballotBox?
      party: null           maybe empty object of party?
      voted: false
  */
    private String name;
    private String id;
    private int birthYear;
    private boolean isolation; // bidud
    private BallotBox ballotBox; // kalpi eleha hu meshuyah
    private Party party;
    private boolean voted;

    /************ Constructor ************/
    public Citizen(String name, String id, int birthYear, boolean isolation, BallotBox ballotBox, Party party, boolean voted) {
        setName(name);
        setId(id);
        setBirthYear(birthYear);
        setIsolation(isolation);
        setBallotBox(ballotBox);
        setInParty(party);
        setVoted(voted);
    }

    public Citizen(Citizen citizen) {
        this(citizen.name, citizen.id, citizen.birthYear, citizen.isolation, citizen.ballotBox, citizen.party, citizen.voted);
    }

    public Citizen(String name, String id, int birthYear, boolean isolation, BallotBox ballotBox) {
        this (name, id, birthYear, isolation, ballotBox, null, false);
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
    private boolean setName(String name){
        // checks if the citizen got multiple names
        // checks if there is a character that is not alphabetic in his name

        boolean done = false;
        String result = "";

        if(name != null){
            String[] temp = name.split(" ");
            for(int i = 0; i < temp.length && !done; i++){
                if(!temp[i].matches("^[a-zA-Z]*$")){
                    done = true;
                }else{
                    result += temp[i] +" ";
                }
            }
        }

        if(done)
            this.name = "citizen";
        else
            this.name = result.substring(0, result.length() - 1);

        return done;
    }

    private boolean setId(String id){
        boolean legalIdLength = id.length() >= 1 && id.length() <= 9;

        if(id != null && legalIdLength){
            this.id = id;
            return true;
        }else
            this.id = "123456789";

        return false;
    }

    private boolean setBirthYear(int birthYear){
        if(birthYear >= 0){
            this.birthYear = birthYear;
            return true;
        }else
            this.birthYear = 1990;

        return false;
    }

    private boolean setIsolation(boolean isolation) {
        this.isolation = isolation;
        return isolation;
    }

    public boolean setBallotBox(BallotBox ballotBox) {
        if (ballotBox != null)
            this.ballotBox = ballotBox;
        else {
            this.ballotBox = null;
            return false;
        }
        return true;
    }

    public boolean setInParty(Party party) {
        if(party != null){
            this.party = party;
            return true;
        }else
            this.party = null;

        return false;
    }

    private boolean setVoted(boolean voted) {
        this.voted = voted;
        return voted;
    }

    /************** Functions **************/
    public void vote(){
        if(!voted)
            setVoted(true);
    }


    public boolean equals(Citizen other) {
        if(other == null && this == null) return true;
        else
            return birthYear == other.birthYear &&
                isolation == other.isolation &&
                voted == other.voted &&
                name.equals(other.name) &&
                id.equals(other.id);
//                    && ( ballotBox.equals(other.ballotBox) || (ballotBox == null && other.ballotBox == null) )&&
//                    ( party.equals(other.party) || (party == null && other.party == null) );
    }

/*    public boolean equals(Citizen other){
        if(other != null){
            boolean isSameName = name.equals(other.name);
            boolean isSameId = id.equals(other.id);
            boolean isSameBirthYear = birthYear == other.birthYear;
            boolean isSameBallotBox = ballotBox.equals(other.ballotBox);
            boolean isSameParty = party.equals(other.party);
            boolean isSameVoted = voted == other.voted;

            if(isSameName && isSameId && isSameBirthYear && isSameBallotBox && isSameParty && isSameVoted )
                return true;
        }
        return false;
    }
 */

    // String name, String id, int birthYear, boolean isolation, BallotBox ballotBox, Party party, boolean voted

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

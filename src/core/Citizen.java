package core;

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
        boolean done = false;
        boolean legalIdLength = id.length() >= 1 && id.length() <= 9;

        if(id != null && legalIdLength){
            this.id = id;
            done = true;
        }else
            this.id = "123456789";

        return done;
    }

    private boolean setBirthYear(int birthYear){
        boolean done = false;
        if(birthYear >= 0){
            this.birthYear = birthYear;
            done = true;
        }else
            this.birthYear = 1990;

        return done;
    }

    private boolean setIsolation(boolean isolation) {
        this.isolation = isolation;
        return isolation;
    }

    private boolean setBallotBox(BallotBox ballotBox) {
        // if you can set the BallotBox at least to one of its successor
        // return true

        boolean done = true;

        if(ballotBox instanceof Army)
            this.ballotBox = new Army((Army)ballotBox);
        else if(ballotBox instanceof Corona)
            this.ballotBox = new Corona((Corona)ballotBox);
        else if(ballotBox instanceof Regular)
            this.ballotBox = new Regular((Regular)ballotBox);
        else
            done = false;

        return done;
    }

    public boolean setInParty(Party party) {
        boolean done = false;

        if(party != null){
            done = true;
            this.party = new Party(party);
        }else
            this.party = null;

        return done;
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

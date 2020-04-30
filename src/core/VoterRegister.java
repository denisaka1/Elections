package core;

import java.util.ArrayList;
import java.util.Objects;

public class VoterRegister {
    /* Defaults:
       citizens.length: 0
       citizensCounter: 0
   */
    private ArrayList<Citizen> citizenList;
    private int citizensCounter;

    /************ Constructor ************/
    public VoterRegister(ArrayList<Citizen> citizens){
        setCitizens(citizens);
    }

    public VoterRegister() {
        this(null);
    }

    /************ Set Functions ************/
    private boolean setCitizens(ArrayList<Citizen> citizens){
        if (citizens != null) {
            for (int i = 0; i < citizens.size(); i++) {
                citizenList.add(new Citizen(citizens.get(i)));
            }
            return true;
        }else {
            citizenList = new ArrayList<Citizen>(0);
            return false;
        }
    }

    /************ Get Functions ************/
    public ArrayList<Citizen> getCitizens() {
        return citizenList;
    }

/*    public int getIndexByCitizen(Citizen citizen) {
        for (int i = 0; i < citizens.length; i++) {
            if(citizen != null) {
                if (citizens[i].equals(citizen)) {
                    return i;
                }
            }
        }
        return -1;
    }*/

    public Citizen getCitizenById(String id) {
        if (id != null) {
            for(Citizen citizen: citizenList){
                if (citizen.getID() == id)
                    return citizen;
            }

        }
        return null;
    }

    /************** Functions **************/

    public boolean addCitizen(Citizen citizen) {
        if (citizen != null && !citizenList.contains(citizen)){
            citizenList.add(new Citizen(citizen));
            return true;
        }
        return false;
    }

    // TODO: if not used maybe delete... ?
    public boolean addCitizens(Citizen... citizens) {
        if (citizens != null) {
            for(Citizen citizen: citizens){
                addCitizen(citizen);

            }
            return true;
        }
        return false;
    }

    public boolean equals(VoterRegister voterRegister){
        if (voterRegister == null && this == null)
            return true;
        else if  (voterRegister == null || this == null)
            return false;
        return citizensCounter == voterRegister.citizensCounter;
//                Arrays.equals(citizenList, voterRegister.citizenList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VoterRegister)) return false;
        VoterRegister that = (VoterRegister) o;
        return Objects.equals(citizenList, that.citizenList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(citizenList);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < citizensCounter; i++){
//            sb.append(citizens[i] + "\n");
        }
        return sb.toString();
    }
}
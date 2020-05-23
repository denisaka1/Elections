package model;

import model.citizens.*;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.Map;
import java.util.Objects;

public class VoterRegister {
    private Set<Citizen> citizens;

    /************* Constructor *************/
    public VoterRegister(Set<Citizen> citizens) {
        setCitizens(citizens);
    }

    public VoterRegister() {
        this((Set<Citizen>) null);
    }


    public VoterRegister(VoterRegister voterRegister) {
        this(voterRegister.getCitizens());
    }

    /************ Set Functions ************/
    private boolean setCitizens(Set<Citizen> citizens) {
        try {
            if (citizens != null)
                this.citizens = new Set<Citizen>(citizens);
            else
                this.citizens = new Set<Citizen>();
            return true;
        } catch (GenericSignatureFormatError e) {
            System.out.println("The generic signature not match");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        this.citizens = new Set<Citizen>();
        return false;
    }

    /************ Get Functions ************/
    public Set<Citizen> getCitizens() {
        return citizens;
    }

    public Citizen getCitizenById(String id) {
        for (int i = 0; i < citizens.size(); i++) {
            if (citizens.get(i).getID().equals(id))
                return citizens.get(i);
        }
        return null;
    }

    /************** Functions **************/
    public boolean addCitizen(Citizen citizen) {
        try {
            if (!citizens.contains(citizen))
                if (citizens.add(returnCitizen(citizen)))
                    return true;
        } catch (NullPointerException npe) {
            System.out.println("Can't operate with null");
        }
        return false;
    }

    private Citizen returnCitizen(Citizen citizen) {
        if (citizen instanceof Citizen)
            return new Citizen((Citizen) citizen);
        else if (citizen instanceof Corona)
            return new Corona((Corona)citizen);
        else if (citizen instanceof Soldier)
            return new Soldier((Soldier)citizen);
        else if (citizen instanceof SoldierCorona)
            return new SoldierCorona((SoldierCorona)citizen);
        else
            return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoterRegister that = (VoterRegister) o;
        return Objects.equals(citizens, that.citizens);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < citizens.size(); i++){
            sb.append(citizens.get(i) + "\n");
        }
        return sb.toString();
    }
}
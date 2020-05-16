package model;

import model.citizens.*;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.Objects;

public class VoterRegister {
    private Set<Citizen> citizens;

    /************* Constructor *************/
    public VoterRegister(Set<Citizen> citizens) {
        setCitizens(citizens);
    }

    public VoterRegister() {
        this(null);
    }

    /************ Set Functions ************/
    private boolean setCitizens(Set<Citizen> citizens) {
        this.citizens = new Set<Citizen>();
        try {
            addCitizens(citizens);
            return true;
        } catch (GenericSignatureFormatError e) {
            System.out.println("The generic signature not match");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

        return false;
    }

    /************ Get Functions ************/
    public Set<Citizen> getCitizens() {
        return citizens;
    }

    // getCitizenById

    /************** Functions **************/
    // addCitizen / addCitizens - Done

    public void addCitizens(Set<Citizen> citizens) {
        try {
            for(Citizen citizen: citizens.getSet()) {
                addCitizen(citizen);
            }
        } catch (NullPointerException npe) {
            System.out.println("The array is null!");
        }
    }

    public void addCitizen(Citizen citizen) {
        try {
            citizens.add(returnCitizen(citizen));
        } catch (NullPointerException npe) {
            System.out.println("Can't operate with null");
        }
    }

    private Citizen returnCitizen(Citizen citizen) {
        if (citizen instanceof Regular)
            return new Regular((Regular)citizen);
        else if (citizen instanceof Corona)
            return new Corona((Corona)citizen);
        else if (citizen instanceof Soldier)
            return new Soldier((Soldier)citizen);
        else if (citizen instanceof SoldierCorona)
            return new SoldierCorona((SoldierCorona)citizen);
        else
            return null;

    }
    // validID 9 digit -> !should be in ServiceManager!
    // validAge 18+ by birth year -> !should be in ServiceManager!

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
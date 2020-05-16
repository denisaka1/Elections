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
        if (this.citizens == null) {
            this.citizens = citizens;
        } else {
            try {
                this.citizens = new Set<Citizen>(Citizen.class);
            } catch (GenericSignatureFormatError e) {
                System.out.println("The generic signature not match");
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }
        }
        return true;
    }

    /************ Get Functions ************/
    public Set<Citizen> getCitizens() {
        return citizens;
    }

    // getCitizenById

    /************** Functions **************/
    // addCitizen / addCitizens
    // validID 9 digit
    // validAge 18+ by birth year

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
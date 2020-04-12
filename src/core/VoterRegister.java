package core;

import java.net.PortUnreachableException;

public class VoterRegister {
    private Citizen[] citizens;
    private int citizensCounter;

    /************ Constructor ************/
    public VoterRegister(Citizen[] citizens) {
        this.citizens = citizens;
        this.citizensCounter = 0;
    }

    public VoterRegister() {
        this(new Citizen[2]);
    }

    /************ Get Functions ************/
    public Citizen[] getCitizens() {
        return citizens;
    }

    public int getIndexByCitizen(Citizen citizen) {
        int counter = 0;
        for (int i = 0; i < citizens.length; i++) {
            if (citizens[i].equals(citizen)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    /************** Functions **************/
    private void expandCitizens() {
        Citizen[] temp = new Citizen[citizens.length * 2];
        for (int i = 0; i < citizens.length; i++) {
            temp[i] = citizens[i];
        }
        this.citizens = temp;
    }

    public boolean addCitizen(Citizen citizen) {
        if (citizensCounter >= citizens.length) {
            expandCitizens();
            addCitizen(citizen);
        } else {
            citizens[citizensCounter] = citizen;
            citizensCounter++;
            return true;
        }
        return false;
    }

    public boolean equals(VoterRegister voterRegister) {
        if (!voterRegister.getCitizens().equals(voterRegister))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < citizens.length; i++)
            if (citizens[i] != null)
                sb.append(citizens[i]);
        return sb.toString();
    }
}
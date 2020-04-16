package core;

public class VoterRegister {
    private Citizen[] citizens;
    private int citizensCounter;

    /************ Constructor ************/
    public VoterRegister(Citizen[] citizens) {
        this.citizens = citizens;
        this.citizensCounter = 0;
    }

    public VoterRegister() {
        this(new Citizen[0]);
    }

    /************ Get Functions ************/
    public Citizen[] getCitizens() {
        return citizens;
    }

    public int getIndexByCitizen(Citizen citizen) {
        int counter = 0;
        for (int i = 0; i < citizens.length; i++) {
            if(citizen != null) {
                if (citizens[i].equals(citizen)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Citizen getCitizenById(String id) {
        for (int i = 0; i < citizens.length; i++) {
            if (citizens[i] != null && id != null) {
                if (citizens[i].getID().equals(id))
                    return citizens[i];
            }
        }
        return null;
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
        if (citizens.length == 0) {
            this.citizens = new Citizen[1];
        }

        if (existCitizen(citizen)) {
            return false;
        } else if (citizensCounter >= citizens.length) {
            expandCitizens();
            addCitizen(citizen);
        } else {
            citizens[citizensCounter] = new Citizen(citizen);
            citizensCounter++;
            return true;
        }
        return false;
    }

    private boolean existCitizen(Citizen citizen) {
        for (int i = 0; i < citizens.length; i++) {
            if (citizens[i] != null && citizen != null) {
                if (citizens[i].equals(citizen)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        VoterRegister voterRegister = (VoterRegister) obj;
        if (!voterRegister.getCitizens().equals(voterRegister))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < citizens.length; i++)
            if (citizens[i] != null)
                sb.append(citizens[i] + "\n");
        return sb.toString();
    }
}
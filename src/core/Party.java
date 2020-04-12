package core;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Party {
    private String name;
    private String section;
    private String creationDate; // optional for "Date" class
    private Citizen[] candidates; // all party candidates (primariz)
    private int candidatesCounter;

    /************ Constructor ************/
    public Party(String name, String section, String creationDate, Citizen[] candidates) {
        this.name = name;
        this.section = section;
        this.creationDate = creationDate;
        this.candidates = candidates;
        this.candidatesCounter = 0;
    }

    public Party(String name, String section, String creationDate) {
        this (name, section, creationDate, new Citizen[2]);
    }

    /************ Get Functions ************/
    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Citizen[] getCandidates() {
        return candidates;
    }

    public int getCandidatesCounter() {
        return candidatesCounter;
    }
    /************ Get Functions ************/
    public void setName(String name) {
        this.name = name;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setCandidates(Citizen[] candidates) {
        this.candidates = candidates;
    }

    /************** Functions **************/
    public boolean addCandidate(Citizen candidate, int place) {
        if (place >= candidates.length) {
            expandCandidatesByPlace(place);
            addCandidate(candidate, place);
        } else {
            if (candidates[place] != null) {
                candidates[place] = candidate;
                candidate.setInParty(getName());
                candidatesCounter++;
            } else {
                return false;
            }
            return true;
        }
        return false;
    }

    private void expandCandidatesByPlace(int place) {
        Citizen[] temp = new Citizen[place];
        for (int i = 0; i < candidates.length; i++) {
            temp[i] = candidates[i];
        }
        this.candidates = temp;
    }

    private void expandCandidates() {
        Citizen[] temp = new Citizen[candidates.length * 2];
        for (int i = 0; i < candidates.length; i++) {
            temp[i] = candidates[i];
        }
        this.candidates = temp;
    }

    @Override
    public boolean equals(Object obj) {
        Party party = (Party) obj;
        if (!party.getName().equals(name) || !party.getSection().equals(section)
                || !party.getCandidates().equals(candidates) || !party.getCreationDate().equals(creationDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Party name : " + name + "\n");
        sb.append("Section : " + section + "\n");
        sb.append("Creation Date : " + creationDate + "\n");
        sb.append("Candidates : " + Arrays.toString(candidates) + "\n");
        return sb.toString();
    }
}
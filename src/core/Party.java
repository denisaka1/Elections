package core;

import java.util.Arrays;

public class Party {
    /* Defaults:
        name: Default
        section: RIGHT_SECTION
        creatingDate: 1.1.00
        day: 1
        month: 1
        year: 2020
        candidates: null
    */
    private final String LEFT_SECTION = "left";
    private final String RIGHT_SECTION = "right";
    private final String CENTER_SECTION = "center";
    private String name;
    private String section;
    private int year;
    private int month;
    private int day;
    private Citizen[] candidates; // all party candidates (primariz)

    /************ Constructor ************/
    public Party(String name, String section, int year, int month, int day, Citizen[] candidates) {
        setName(name);
        setSection(section);
        setCreationDate(year, month, day);
        setCandidates(candidates);
    }

    public Party(String name, String section, int year, int month, int day) {
        this(name, section, year, month, day, null);
    }

    /************ Get Functions ************/
    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

    public Citizen[] getCandidates() {
        return candidates;
    }

    public int getCandidatesCounter() {
        return candidates.length;
    }

    /************ Set Functions ************/
    private boolean setName(String name) {
        boolean done;
        if(name != null){
            this.name = name;
            done = true;
        }else{
            done = false;
            this.name = "Default";
        }
        return done;
    }

    private boolean setSection(String section) {
        boolean done = false;
        if(section.contains(RIGHT_SECTION) || section.contains(LEFT_SECTION) || section.contains(CENTER_SECTION)){
            this.section = section.toLowerCase();
            done = true;
        }else{
            this.section = RIGHT_SECTION;
        }
        return done;
    }

    private boolean setCreationDate(int year, int month, int day){
        boolean done = false;
        boolean legalYear = year >= 0;
        int resultDay;
        int resultMonth;
        int resultYear;

        if(legalYear && day >= 0){
            resultYear = year;
            resultMonth = month;
            switch(resultMonth){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(day <= 31){
                        resultDay = day;
                        done = true;
                    }else{
                        resultDay = 1;
                        done = false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(day <= 30){
                        resultDay = day;
                        done = true;
                    }else{
                        resultDay = 1;
                        done = false;
                    }
                    break;
                case 2:
                    if(day <= 28){
                        resultDay = day;
                        done = true;
                    }else{
                        resultDay = 1;
                        done = false;
                    }
                    break;
                default:
                    resultDay = 1;
                    resultMonth = 1;
                    break;
            }
        }else{
            resultDay = 1;
            resultMonth = 1;
            resultYear = 2020;
            done = false;
        }
        this.year = resultYear;
        this.month = resultMonth;
        this.day = resultDay;
        return done;
    }

    private boolean setCandidates(Citizen[] candidates) {
        boolean done = false;
        this.candidates = new Citizen[candidates.length];
        for(int i = 0; i < candidates.length; i++) {
            this.candidates[i] = new Citizen(candidates[i]);
        }
        return done = true;
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
                || !party.getCandidates().equals(candidates) || party.getDay() != getDay()
                || party.getMonth() != getMonth() || party.getYear() != getYear())
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Party name : " + name + "\n");
        sb.append("Section : " + section + "\n");
        sb.append("Creation Date : " + day + "/" + month + "/" + year + "\n");
        sb.append("Candidates : " + Arrays.toString(candidates) + "\n");
        return sb.toString();
    }
}
package core;

import java.util.Hashtable;

public class Party {
    /* Defaults:
        name: Default
        section: RIGHT_SECTION
        day: 1
        month: 1
        year: 2020
        candidates.length: 0
    */

    public static final String LEFT_SECTION = "left";
    public static final String RIGHT_SECTION = "right";
    public static final String CENTER_SECTION = "center";
    private String name;
    private String section;
    private int year;
    private int month;
    private int day;
    private Hashtable<Citizen, Integer> candidates;

    public Party(String name, String section, int year, int month, int day, Hashtable<Citizen, Integer> candidates) {
        setName(name);
        setSection(section);
        setCreationDate(year, month, day);
        setCandidates(candidates);
    }

    public Party(String name, String section, int year, int month, int day) {
//        this(name, section, year, month, day, new Citizen[0], 0);
        this(name, section, year, month, day, null);
    }

    public Party(Party party){
        this(party.name, party.section, party.year, party.month, party.day, party.candidates);
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

    public Hashtable<Citizen, Integer> getCandidates() {
        return candidates;
    }

    public int getCandidatesCounter() {
        return candidates.size();
    }

    /************ Set Functions ************/
    private boolean setCandidates(Hashtable<Citizen, Integer> candidates){
        if(candidates != null && !candidates.isEmpty()){
            this.candidates = candidates;
            return true;
        }
        this.candidates = new Hashtable<Citizen, Integer>(0);
        return false;
    }

    private boolean setName(String name) {
        if(name != null) {
            this.name = name;
            return true;
        } else {
            this.name = "Default";
            return false;
        }
    }

    private boolean setSection(String section) {
        if(section.contains(RIGHT_SECTION) || section.contains(LEFT_SECTION) || section.contains(CENTER_SECTION)){
            this.section = section.toLowerCase();
            return true;
        } else {
            this.section = RIGHT_SECTION;
        }
        return false;
    }

    private boolean setCreationDate(int year, int month, int day) {
        boolean done = false;
        boolean legalYear = year >= 0;
        int resultDay;
        int resultMonth;
        int resultYear;

        if(legalYear && day >= 0) {
            resultYear = year;
            resultMonth = month;
            switch(resultMonth) {
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
        } else {
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

    /************** Functions **************/
    public boolean addCandidate(Citizen candidate, int place) {
        if (candidate != null && !candidate.isInParty() && place > 0 && !candidates.containsValue(place)) {
            candidates.put(candidate, place);
            candidate.assignToParty(this);
            return true;
        }
        return false;
    }

    private int minValue() {
        int min = 0;
        for (int value: candidates.values()) {
            if(min > value)
                min = value;
        }
        return min;
    }

    private void sortCandidates(){
        // TODO: if needed ?
    }
/*    public boolean addCandidate(Citizen candidate, int place) {
        if (candidates == null || candidates.length == 0) {
            this.candidates = new Citizen[1];
            this.candidatesPlaces = new int[1];
        }

        if (counterCandidates >= candidates.length) {
            if (place > (candidates.length * 2))
                expandCandidatesByPlace(place);
            else
                expandCandidates();

            addCandidate(candidate, place);
        } else {
            candidates[counterCandidates] = candidate;
            candidatesPlaces[counterCandidates] = place;
            counterCandidates++;
            candidate.setInParty(this);
            candidatesSort();
            return true;
        }
        return false;
    }

    private void candidatesSort() {
        for (int i = 0; i < candidatesPlaces.length; i++) {
            int min = candidatesPlaces[i];
            Citizen citizenMin = candidates[i];
            int minIndex = i;
            for (int j = i+1; j < candidatesPlaces.length; j++) {
                if (candidatesPlaces[j] < min && candidatesPlaces[j] > 0) {
                    min = candidatesPlaces[j];
                    citizenMin = candidates[j];
                    minIndex = j;
                }
            }

            int temp = candidatesPlaces[i];
            candidatesPlaces[i] = min;
            candidatesPlaces[minIndex] = temp;

            Citizen citizenTemp = candidates[i];
            candidates[i] = citizenMin;
            candidates[minIndex] = citizenTemp;
        }
    }

    private void expandCandidatesByPlace(int place) {
        Citizen[] tempCitizen = new Citizen[place + 1];
        int[] tempPlaces = new int[place + 1];
        for (int i = 0; i < candidates.length; i++) {
            tempCitizen[i] = candidates[i];
            tempPlaces[i] = candidatesPlaces[i];
        }
        this.candidates = tempCitizen;
        this.candidatesPlaces = tempPlaces;
    }*/



    public boolean equals(Party party) {
        if (this == null && party == null)
            return true;
        else if (party == null || this == null)
            return false;
        return name.toUpperCase().equals(party.name.toUpperCase()); // enough to check only name
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Party name : " + name + "\n");
        sb.append("Section : " + section + "\n");
        sb.append("Creation Date : " + day + "/" + month + "/" + year + "\n");
        sb.append("Candidates : " + candidates.size() + "\n");
        return sb.toString();
    }
}
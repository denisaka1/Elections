package view.showMenu;

import model.VoterRegister;

public class BeginElections extends Main {

    private VoterRegister vr;

    public BeginElections(VoterRegister voterRegister) {
        super();
        vr = voterRegister;
    }

    private void createYesNoWindow() {
        // TODO: create popup
        // TODO: yes -> which party -> +1 vote
    }

    private void askEveryone() {
        for(int i = 0; i < vr.getCitizens().size(); i++) {
            createYesNoWindow();
        }
    }

}

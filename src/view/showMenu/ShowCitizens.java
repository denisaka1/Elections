package view.showMenu;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.VoterRegister;
import model.citizens.Citizen;

public class ShowCitizens extends Main {

    // FIXME: add scrollPane

    private VoterRegister vr;

    public ShowCitizens(VoterRegister voterRegister) {
        super();
        vr = voterRegister;
        setHeadline("Show All Citizens");
    }
    private void assignCitizens() {
        Citizen citizen;
        Text text;
        for(int i = 0; i < vr.getCitizens().size(); i++) {
            citizen = vr.getCitizens().get(i);
            text = new Text(citizen.toString());
            mainView.getChildren().add(text);
            mainView.setMargin(text, new Insets(10, 0, 0, 20));
        }
    }

    @Override
    public VBox update() {
        super.update();
        assignCitizens();

        return mainView;
    }
}

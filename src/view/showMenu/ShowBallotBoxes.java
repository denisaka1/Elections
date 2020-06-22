package view.showMenu;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.BallotBox;
import model.citizens.Citizen;
import model.citizens.Corona;
import model.citizens.Soldier;
import model.citizens.SoldierCorona;
import view.ViewGUI;

import java.util.List;

public class ShowBallotBoxes extends Main {
    // FIXME: add scrollPane

    private List<BallotBox<Citizen>> regular;
    private List<BallotBox<Soldier>> soldier;
    private List<BallotBox<SoldierCorona>> soldierCorona;
    private List<BallotBox<Corona>> corona;

    public ShowBallotBoxes(List<BallotBox<Citizen>> citizen, List<BallotBox<Soldier>> soldier, List<BallotBox<SoldierCorona>> soldierCorona,
                           List<BallotBox<Corona>> corona) {
        super();
        regular = citizen;
        this.soldier = soldier;
        this.soldierCorona = soldierCorona;
        this.corona = corona;
        setHeadline("Show All Ballot Boxes");
    }

    private void setSubHeadLine(String s) {
        Text text = new Text(s);
        text.setFont(headLineFont);
        scrollPaneVB.getChildren().add(text);
        scrollPaneVB.setMargin(text, ViewGUI.DEFAULT_INSETS);
    }

    private void assignBallotBoxes() {
        assignRegular();
        assignSoldier();
        assignSoldierCorona();
        assignCorona();
    }

    private void assignRegular() {
        setSubHeadLine("Regular");
        Text text;
        for(BallotBox<Citizen> ballotBox: regular){
            text = new Text(ballotBox.toString());
            scrollPaneVB.getChildren().add(text);
//            scrollPane.setContent(text);
        }
    }

    private void assignSoldier() {
        setSubHeadLine("Soldier");
        Text text;
        for(BallotBox<Soldier> ballotBox: soldier){
            text = new Text(ballotBox.toString());
            scrollPaneVB.getChildren().add(text);
//            scrollPane.setContent(text);
        }
    }

    private void assignSoldierCorona() {
        setSubHeadLine("SoldierCorona");
        Text text;
        for(BallotBox<SoldierCorona> ballotBox: soldierCorona){
            text = new Text(ballotBox.toString());
            scrollPaneVB.getChildren().add(text);
//            scrollPane.setContent(text);
        }
    }

    private void assignCorona() {
        setSubHeadLine("Corona");
        Text text;
        for(BallotBox<Corona> ballotBox: corona){
            text = new Text(ballotBox.toString());
            scrollPaneVB.getChildren().add(text);
//            scrollPane.setContent(text);
        }
    }

    @Override
    public VBox update() {
        super.update();
        assignBallotBoxes();
        assignScrollPane();
//        mainView.getChildren().add(content);
//        mainView.setMargin(content, new Insets(10, 0, 0, 20));

        return mainView;
    }
}

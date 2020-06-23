package view.showMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.BallotBox;
import model.Party;
import model.VoterRegister;
import model.citizens.Citizen;
import model.citizens.SoldierCorona;
import view.ViewGUI;

public class ShowCitizens extends Show {

    // FIXME: add scrollPane

    private VoterRegister vr;

    public ShowCitizens(VoterRegister voterRegister) {
        super();
        vr = voterRegister;
        setHeadline("Show All Citizens");
    }

    private void assignCitizens() {
        ObservableList<Citizen> data = FXCollections.observableArrayList(vr.getCitizens().getSet());
        TableView<Citizen> table = new TableView<>();

        TableColumn citizenID = new TableColumn("ID");
        citizenID.setMinWidth(79);
        citizenID.setMaxWidth(79);
        citizenID.setCellValueFactory(new PropertyValueFactory<Citizen, String>("ID"));

        TableColumn name = new TableColumn("Name");
        name.setMinWidth(120);
        name.setMaxWidth(120);
        name.setCellValueFactory(new PropertyValueFactory<Citizen, String>("name"));

        TableColumn birthYear = new TableColumn("Birth Year");
        birthYear.setMinWidth(80);
        birthYear.setMaxWidth(80);
        birthYear.setCellValueFactory(new PropertyValueFactory<Citizen, String>("birthYear"));

        TableColumn ballotBox = new TableColumn("BallotBox");
        ballotBox.setMinWidth(130);
        ballotBox.setMaxWidth(130);
        ballotBox.setCellValueFactory(new PropertyValueFactory<Citizen, String>("ballotBox"));

        TableColumn party = new TableColumn("Party");
        party.setMinWidth(110);
        party.setMaxWidth(130);
        party.setCellValueFactory(new PropertyValueFactory<Citizen, String>("party"));

        table.setMinWidth(540);
        table.setMaxWidth(540);

        table.setFixedCellSize(20);
        table.setMaxHeight(40 + (vr.getCitizens().getSet().size() * 20));

        table.setItems(data);
        table.getColumns().addAll(citizenID, name, birthYear, ballotBox, party);

        scrollPaneVB.getChildren().add(table);
        scrollPaneVB.setMargin(table, ViewGUI.DEFAULT_INSETS);
    }

    @Override
    public VBox update() {
        super.update();
        assignCitizens();
        assignScrollPane();
        return mainView;
    }
}

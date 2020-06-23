package view.showMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Party;
import model.citizens.Citizen;
import view.ViewGUI;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowParties extends Show {
    // FIXME: add scrollPane

    private HashMap<Party, Integer> allParties;

    public ShowParties(HashMap<Party, Integer> parties) {
        super();
        allParties = parties;
        setHeadline("Show All Parties");
    }

    private void assignParties() {
/*        Text text;
        for(Party party: allParties.keySet()) {
            text = new Text(party.toString());
            scrollPaneVB.getChildren().add(text);
            scrollPaneVB.setMargin(text, ViewGUI.DEFAULT_INSETS);
        }
    }*/

        ObservableList<Party> data = FXCollections.observableArrayList(new ArrayList<Party>(allParties.keySet()));
        TableView<Party> table = new TableView<>();

        TableColumn name = new TableColumn("Name");
        name.setMinWidth(200);
        name.setMaxWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<Party, String>("name"));

        TableColumn section = new TableColumn("Section");
        section.setMinWidth(130);
        section.setMaxWidth(130);
        section.setCellValueFactory(new PropertyValueFactory<Party, String>("section"));

        TableColumn year = new TableColumn("Year");
        year.setMinWidth(70);
        year.setMaxWidth(70);
        year.setCellValueFactory(new PropertyValueFactory<Party, Integer>("year"));

        TableColumn month = new TableColumn("Month");
        month.setMinWidth(70);
        month.setMaxWidth(70);
        month.setCellValueFactory(new PropertyValueFactory<Party, Integer>("month"));

        TableColumn day = new TableColumn("Day");
        day.setMinWidth(70);
        day.setMaxWidth(70);
        day.setCellValueFactory(new PropertyValueFactory<Party, Integer>("day"));


        table.setMinWidth(540);
        table.setMaxWidth(540);

        table.setFixedCellSize(20);
        table.setMaxHeight(40 + (allParties.size() * 20));

        table.setItems(data);
        table.getColumns().addAll(name, section, year, month, day);

        scrollPaneVB.getChildren().add(table);
        scrollPaneVB.setMargin(table, ViewGUI.DEFAULT_INSETS);
    }

    @Override
    public VBox update() {
        super.update();
        assignParties();
        assignScrollPane();

        return mainView;
    }
}

package view.showMenu;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.BallotBox;
import model.citizens.Citizen;
import model.citizens.Corona;
import model.citizens.Soldier;
import model.citizens.SoldierCorona;
import view.ViewGUI;

import java.util.List;

public class ShowBallotBoxes extends Show {
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

        ObservableList<BallotBox<Citizen>> data = FXCollections.observableArrayList(regular);
        TableView<BallotBox<Citizen>> table = new TableView<>();

        TableColumn num = new TableColumn("#");
        num.setMinWidth(100);
        num.setMaxWidth(100);
        num.setCellValueFactory(new PropertyValueFactory<BallotBox<Citizen>, String>("id"));

        TableColumn address = new TableColumn("Address");
        address.setMinWidth(438);
        address.setMaxWidth(438);
        address.setCellValueFactory(new PropertyValueFactory<BallotBox<Citizen>, String>("address"));

        table.setMaxWidth(540);

        table.setFixedCellSize(20);
        table.setMaxHeight(40 + (regular.size() * 20));

        table.setItems(data);
        table.getColumns().addAll(num, address);

        scrollPaneVB.getChildren().add(table);
        scrollPaneVB.setMargin(table, ViewGUI.DEFAULT_INSETS);
    }

    private void assignSoldier() {
        setSubHeadLine("Soldier");

        ObservableList<BallotBox<Soldier>> data = FXCollections.observableArrayList(soldier);
        TableView<BallotBox<Soldier>> table = new TableView<>();

        TableColumn num = new TableColumn("#");
        num.setMinWidth(100);
        num.setMaxWidth(100);
        num.setCellValueFactory(new PropertyValueFactory<BallotBox<Citizen>, String>("id"));

        TableColumn address = new TableColumn("Address");
        address.setMinWidth(438);
        address.setMaxWidth(438);
        address.setCellValueFactory(new PropertyValueFactory<BallotBox<Citizen>, String>("address"));

        table.setMaxWidth(540);

        table.setFixedCellSize(20);
        table.setMaxHeight(40 + (soldier.size() * 20));

        table.setFixedCellSize(20);
        table.setMaxHeight(100);

        table.setItems(data);
        table.getColumns().addAll(num, address);

        scrollPaneVB.getChildren().add(table);
        scrollPaneVB.setMargin(table, ViewGUI.DEFAULT_INSETS);
    }

    private void assignSoldierCorona() {
        setSubHeadLine("SoldierCorona");

        ObservableList<BallotBox<SoldierCorona>> data = FXCollections.observableArrayList(soldierCorona);
        TableView<BallotBox<SoldierCorona>> table = new TableView<>();

        TableColumn num = new TableColumn("#");
        num.setMinWidth(100);
        num.setMaxWidth(100);
        num.setCellValueFactory(new PropertyValueFactory<BallotBox<Citizen>, String>("id"));

        TableColumn address = new TableColumn("Address");
        address.setMinWidth(438);
        address.setMaxWidth(438);
        address.setCellValueFactory(new PropertyValueFactory<BallotBox<Citizen>, String>("address"));

        table.setMaxWidth(540);

        table.setFixedCellSize(20);
        table.setMaxHeight(40 + (soldierCorona.size() * 20));

        table.setFixedCellSize(20);
        table.setMaxHeight(100);

        table.setItems(data);
        table.getColumns().addAll(num, address);

        scrollPaneVB.getChildren().add(table);
        scrollPaneVB.setMargin(table, ViewGUI.DEFAULT_INSETS);
    }

    private void assignCorona() {
        setSubHeadLine("Corona");

        ObservableList<BallotBox<Corona>> data = FXCollections.observableArrayList(corona);
        TableView<BallotBox<Corona>> table = new TableView<>();

        TableColumn num = new TableColumn("#");
        num.setMinWidth(100);
        num.setMaxWidth(100);
        num.setCellValueFactory(new PropertyValueFactory<BallotBox<Citizen>, String>("id"));

        TableColumn address = new TableColumn("Address");
        address.setMinWidth(438);
        address.setMaxWidth(438);
        address.setCellValueFactory(new PropertyValueFactory<BallotBox<Citizen>, String>("address"));

        table.setMaxWidth(540);

        table.setFixedCellSize(20);
        table.setMaxHeight(40 + (corona.size() * 20));

        table.setFixedCellSize(20);
        table.setMaxHeight(100);

        table.setItems(data);
        table.getColumns().addAll(num, address);

        scrollPaneVB.getChildren().add(table);
        scrollPaneVB.setMargin(table, ViewGUI.DEFAULT_INSETS);
    }

    @Override
    public VBox update() {
        super.update();
        assignBallotBoxes();
        assignScrollPane();

        return mainView;
    }
}

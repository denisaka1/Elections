package view.showMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import model.Party;
import view.ViewGUI;

import java.util.HashMap;

public class ShowResults extends Main {
    // FIXME: add scrollPane
    private PieChart chart;
    private HashMap<Party, Integer> allParties;

    public ShowResults(HashMap<Party, Integer> parties) {
        super();
        allParties = parties;
        setHeadline("Show Vote Results");
        chartResults();
    }

    public void chartResults() {
/*        ObservableList<PieChart.Data> pieChartResults =
                FXCollections.observableArrayList(
                        new PieChart.Data("Party 1", 17),
                        new PieChart.Data("Party 2", 30),
                        new PieChart.Data("Party 3", 50),
                        new PieChart.Data("Party 4", 10)
                );  */

        ObservableList<PieChart.Data> pieChartResults = FXCollections.observableArrayList();
        for(Party party: allParties.keySet()) {
            pieChartResults.add(new PieChart.Data(party.getName(), allParties.get(party)));
        }

        chart = new PieChart(pieChartResults);
        chart.setTitle("Election Votes");
    }

    public VBox update() {
        super.update();
        mainView.setMargin(chart, ViewGUI.DEFAULT_INSETS);

        return mainView;
    }
}

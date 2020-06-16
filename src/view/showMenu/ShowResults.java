package view.showMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;

public class ShowResults extends Main {
    private PieChart chart;

    public ShowResults() {
        super();
        setHeadline("Show Vote Results");
        chartResults();
    }

    public void chartResults() {
        ObservableList<PieChart.Data> pieChartResults =
                FXCollections.observableArrayList(
                        new PieChart.Data("Party 1", 17),
                        new PieChart.Data("Party 2", 30),
                        new PieChart.Data("Party 3", 50),
                        new PieChart.Data("Party 4", 10));
        chart = new PieChart(pieChartResults);
        chart.setTitle("Election Votes");
    }

    public VBox update() {
        super.update();
        mainView.setMargin(chart, new Insets(10, 0, 0, 20));

        return mainView;
    }
}

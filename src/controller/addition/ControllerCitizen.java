package controller.addition;

import exceptions.ClassAlreadyExists;
import exceptions.UnderAgeException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Toggle;
import model.ModelGUI;
import model.citizens.Citizen;
import model.citizens.Corona;
import model.citizens.Soldier;
import model.citizens.SoldierCorona;
import view.MainPaneView.AddCitizen;

public class ControllerCitizen {

    private ModelGUI theModel;
    private AddCitizen theView;
    private Runnable checkEnableAddCandidate, checkEnableShowAllCitizens;
    private int day, month, year, isolationDays, selectedBallotBox;
    private String name, ID;
    private boolean inIsolation = false;

    public ControllerCitizen(ModelGUI model, AddCitizen view, Runnable checkEnableAddCandidate,
                             Runnable checkEnableShowAllCitizens) {
        theModel = model;
        theView = view;
        this.checkEnableShowAllCitizens = checkEnableShowAllCitizens;
        this.checkEnableAddCandidate = checkEnableAddCandidate;

        eventForSubmitButton();
        changeListenerToYearComboBox();
        changeListenerToToggleGroup();
    }

    private void eventForSubmitButton() {
        EventHandler<ActionEvent> eventForSubmitButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert;
                try {
                    name = theView.getName();
                    ID = theView.getID();
                    day = theView.getDay();
                    month = theView.getMonth();
                    year = theView.getYear();
                    inIsolation = theView.getIsolation();
                    isolationDays = -1;
                    selectedBallotBox = theView.getSelectedBallotBox();

                    if (inIsolation)
                        isolationDays = theView.getIsolationDays();

                    alert = new Alert(Alert.AlertType.NONE);
                    if (!ID.matches("[0-9]+") || ID.length() != 9)
                        throw new NumberFormatException();
                    else if (theModel.getElectionYear() - year < 18)
                        throw new UnderAgeException("The minimum age is 18!");
                    else if (!name.matches("[a-zA-Z ]+"))
                        throw new ClassAlreadyExists(); // change
                    else if (false)  // Duplicate
                        throw new ClassAlreadyExists();
                    else {
                        boolean soldierAge = theModel.getElection().getYear() - year <= 21, isAdded;

                        if (inIsolation && soldierAge)
                            theModel.addCitizen(new SoldierCorona(name, ID, year, true, theModel.getElection().getBallotBoxByNumber(selectedBallotBox), isolationDays));
                        else if (inIsolation)
                            theModel.addCitizen(new Corona(name, ID, year, true, theModel.getElection().getBallotBoxByNumber(selectedBallotBox), isolationDays));
                        else if (soldierAge)
                            theModel.addCitizen(new Soldier(name, ID, year, theModel.getElection().getBallotBoxByNumber(selectedBallotBox)));
                        else
                            theModel.addCitizen(new Citizen(name, ID, year, theModel.getElection().getBallotBoxByNumber(selectedBallotBox)));

                        alert = new Alert(Alert.AlertType.NONE);
                        alert.setContentText("The Citizen has been added successfully!");
                        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                        alert.show();

                    }

                } catch(UnderAgeException npe) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The minimum age is 18!");
                    alert.show();
                } catch(NullPointerException npe) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("1 or more of the fields are empty!");
                    alert.show();
                } catch(NumberFormatException nfe) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The ID contains numbers!");
                    alert.show();
                } catch(ClassAlreadyExists re) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Citizen already exists!");
                    alert.show();
                } catch(Exception e) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Can't add citizen!");
                    alert.show();
                }
            }
        };
        theView.eventSubmitButton(eventForSubmitButton);
    }

    private void changeBallotBoxes() {
        inIsolation = theView.getIsolation();
        year = theView.getYear();
        int age = theModel.getElection().getYear() - year;
        String ballotBoxes;
        String[] splitBallotBoxes;

        if (age >= 18 && age <= 21) {
            if (inIsolation)
                ballotBoxes = theModel.getElection().getBallotBoxesByType(4, true); // 4 - SoliderCorona
            else
                ballotBoxes = theModel.getElection().getBallotBoxesByType(3, true); // 3 - Solider
        } else if (inIsolation)
            ballotBoxes = theModel.getElection().getBallotBoxesByType(2, true); // 2 - Corona
        else
            ballotBoxes = theModel.getElection().getBallotBoxesByType(1, true); // 1 - Citizen / Regular

        splitBallotBoxes = ballotBoxes.split(";");
        ComboBox ballotBox = new ComboBox();
        for (String ballot : splitBallotBoxes)
            ballotBox.getItems().add(ballot);

        theView.updateBallotBoxes(ballotBox);
    }

    private void changeListenerToYearComboBox() {
        ChangeListener<Integer> chl = new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                try {
                    changeBallotBoxes();
                } catch(Exception e) {
                    // ..
                }
            }
        };
        theView.addEventYearComboBox(chl);
    }

    private void changeListenerToToggleGroup() {
        ChangeListener<Toggle> chl = new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                try {
                    changeBallotBoxes();
                    theView.isolationDaysVisible();
                } catch(Exception e) {
                    // ..
                }
            }
        };
        theView.addEventIsoRadio(chl);
    }
}

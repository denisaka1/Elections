package controller.addition;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Toggle;
import model.ModelGUI;
import view.MainPaneView.AddCitizen;

public class ControllerCitizen {

    private ModelGUI theModel;
    private AddCitizen theView;
    private Runnable checkEnableAddCandidate, checkEnableShowAllCitizens;
    //TODO: handle the addition

    public ControllerCitizen(ModelGUI model, AddCitizen view, Runnable checkEnableAddCandidate,
                             Runnable checkEnableShowAllCitizens) {
        theModel = model;
        theView = view;
        this.checkEnableShowAllCitizens = checkEnableShowAllCitizens;
        this.checkEnableAddCandidate = checkEnableAddCandidate;

        // FIXME: add Alert if the BirthYear is not correct
    }

    private void eventForSubmitButton() {
        EventHandler<ActionEvent> eventForSubmitButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert;
                try {
//                    String name = theView.getName();
//                    String ID = theView.getID();
//                    int day = theView.getDay();
//                    int month = theView.getMonth();
//                    int year = theView.getYear();
//                    boolean inIsolation = theView.getIsolation();
//
//                    if (inIsolation)
//                        int isolationDays = theView.getIsolationDays();



                } catch(NullPointerException npe) {
                    // TODO: finish
                } catch(NumberFormatException nfe) {
                    // TODO: finish
                } catch(Exception e) {
                    // TODO: finish
                }


            }
        };

        theView.eventSubmitButton(eventForSubmitButton);
    }

    private void changeListenerToYearComboBox() {
        ChangeListener<Toggle> chl = new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                String year = theView.getYear();

                try {
//                    int yearNumber = Integer.parseInt(year);
//                    boolean soldierAge = currentElectionYear - yearNumber <= 21;
//                    if (age <= 21 && age >= 18) {
//                        show
//                    }


                } catch(Exception e) {
                    // TODO: ....
                }


            }
        };
    }



/*    soldierAge = controllerCLI.getElection().getYear() - birthYear <= 21;
        if (isolation && soldierAge)
            return new SoldierCorona(name, id, birthYear, isolation, ballotBox, daysInIsolation);
        else if (isolation)
            return new Corona(name, id, birthYear, isolation, ballotBox, daysInIsolation);
        else if (soldierAge)
            return new Soldier(name, id, birthYear, ballotBox);
        else
                return new Citizen(name, id, birthYear, ballotBox);*/
}

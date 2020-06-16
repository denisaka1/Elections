package controller.addition;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import model.ModelGUI;
import view.MainPaneView.AddBallotBox;

public class ControllerBallotBox{
    private AddBallotBox mainView;
    private ModelGUI theModel;
    private Button showAllBallotBoxes;
    private Runnable submitAction;
//    private boolean isSuccessfull;

    public ControllerBallotBox(ModelGUI model, AddBallotBox newMainView,
                               Runnable submitAction) {
        theModel = model;
        mainView = newMainView;
//        showAllBallotBoxes = showAllBallotBoxButton;
        this.submitAction = submitAction;
        eventForSubmitButton();
    }


    private void eventForSubmitButton() {

        EventHandler<ActionEvent> eventForSubmitButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert;
                try {
                    String address = mainView.getAddress();
                    String ballotBoxType = mainView.getType();

                    boolean legalAddress = !address.isEmpty();
                    boolean isAdded = theModel.addBallotBox(address, ballotBoxType);
                    if(legalAddress && isAdded) {

                        alert = new Alert(Alert.AlertType.NONE);
                        alert.setContentText("The BallotBox has been added successfully!");
                        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                        alert.show();

                        submitAction.run();

                    } else
                        throw new Exception();

                } catch(Exception e){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("1 or more of fields are not selected");
                    alert.showAndWait();
                }
            }
        };
        mainView.eventSubmitButton(eventForSubmitButton);
    }
}

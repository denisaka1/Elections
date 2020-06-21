package exceptions;

import javafx.scene.control.Alert;

public class MissingItemException extends Exception{
//    String name;
    Alert alert;

    public MissingItemException(Alert alert) {
//        this.name = name;
        this.alert = alert;
    }

    public void showErrorMessage() {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("1 or more of the fields are empty!");
        alert.show();
    }
}

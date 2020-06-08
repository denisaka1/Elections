package view;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class Menu {

    protected Stage menu;
    protected Scene menuScene;
//    protected VBox mainFrame;
    protected ImageView flag;
    protected BorderPane border;


    public Menu(Stage stage) {

        menu = new Stage();
        border = new BorderPane();
//        mainFrame = new VBox();
//
//        mainFrame.setSpacing(ViewGUI.BUTTON_SPACING);
//        mainFrame.setAlignment(Pos.CENTER);

        flag = ViewGUI.setImage(ViewGUI.pathToImage, menu);

        border.getChildren().add(flag);
//        border.setCenter(mainFrame);

        menuScene = new Scene(border, ViewGUI.WIDTH, ViewGUI.HEIGHT);

        menu.setScene(menuScene);
        menu.initOwner(stage);
        menu.initModality(Modality.APPLICATION_MODAL);

        menu.show();
    }
}

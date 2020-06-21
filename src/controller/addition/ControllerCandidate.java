package controller.addition;

import model.ModelGUI;
import model.VoterRegister;
import view.MainPaneView.AssignCandidate;

public class ControllerCandidate {

    private AssignCandidate candidate;
    private ModelGUI theModel;
    private VoterRegister vr;

    private Runnable checkEnableBeginElections;

    public ControllerCandidate(AssignCandidate assignCandidate,
                               ModelGUI model,
                               Runnable r) {
        candidate = assignCandidate;
        theModel = model;
//        vr = voterRegister;
        checkEnableBeginElections = r;
    }

    //FIXME
    /*private void eventForSubmitButton() {
        EventHandler<ActionEvent> eventForSubmitButton = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {


                Alert alert = null;
                try {
                    String citizenID = candidate.getCitizenID();
                    String[] partyName = candidate.getPartyName().split("-");

                    boolean isEmpty = citizenID == null || partyName == null;

                    if(isEmpty) {
                        throw new MissingItemException(alert);
                    }

                    int id = Integer.parseInt(citizenID.substring(0, 9));
                    String name = partyName[0];
                    // add candidate place as well

                    //FIXME: add place
                    if (theModel.assignCandidate(id, name, place)) {
                        alert = new Alert(Alert.AlertType.NONE);
                        alert.setContentText("The Candidate has been added successfully!");
                        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

                        checkEnableBeginElections.run();

                    } else {
                        throw new ClassAlreadyExists("Candidate", alert);
                    }


                } catch(ClassAlreadyExists cae) {
                    cae.showErrorMessage();
                } catch(MissingItemException mie) {
                    mie.showErrorMessage();
                } catch(Exception e) {
                    System.out.println("Something went wrong");
                }
            }
        };
        candidate.eventSubmitButton(eventForSubmitButton);
    }*/
}

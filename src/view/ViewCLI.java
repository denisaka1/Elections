package view;

import controller.Controller;
import exceptions.*;
import model.BallotBox;
import model.Party;
import model.citizens.*;

import java.util.Scanner;

public class ViewCLI {
    private Controller controller;
    private Scanner s;

    public ViewCLI(Controller controller, Scanner scanner) {
        this.controller = controller;
        this.s = scanner;
    }

    public void showMenu() throws StringLengthException, UnderAgeException {
        boolean exit = false;
        while (!exit) {
            System.out.println(controller.getCLIMenu());
            int choose = s.nextInt();
            switch (choose) {
                case 1:
                    controller.addBallotBox(getBallotBox(s));
                    break;
                case 2:
                    controller.addCitizen(getCitizen(s, false));
                    break;
                case 3:
                    controller.addParty(getParty(s));
                    break;
                case 4:
                    String[] candidate = getCandidate(s);
                    controller.addCandidate(candidate[0], candidate[1], Integer.parseInt(candidate[2]));
                    break;
                case 5:
                    System.out.println(controller.getAllBallotBox());
                    break;
                case 6:
                    System.out.println(controller.getAllCitizens());
                    break;
                case 7:
                    System.out.println(controller.getAllParties());
                    break;
                case 8:
                    controller.startVoteCLI(s);
                    break;
                case 9:
                    controller.getResults();
                    break;
                case 10:
                default:
                    exit = true;
                    break;
            }
        }
    }

    private Citizen getCitizen(Scanner s, boolean inParty) throws StringLengthException, UnderAgeException {
        int birthYear, daysInIsolation = 0, tempInt;
        boolean isolation, soldierAge, hasLegalID = false, isMinor = true;
        String name, id, temp;
        char ansChar;
        BallotBox ballotBox;

        s.nextLine();
        System.out.print("Enter name : ");
        name = s.nextLine();

        do {
            System.out.print("Enter ID : ");
            temp = s.next();
            if (temp.length() == 9){
                id = temp;
                hasLegalID = true;
            }
            else
                throw new StringLengthException("Error in ID. ID must be with 9 numbers");
        } while (!hasLegalID);

        do {
            System.out.print("Enter Birth Year : ");
            tempInt = s.nextInt();
            if (controller.getElection().getYear() - tempInt >= 18) {
                birthYear = tempInt;
                isMinor = false;
            } else
                throw new UnderAgeException("You are a minor. Can't enter to Voter Register");
        } while(isMinor);

//        birthYear = s.nextInt();

        System.out.print("You in isolation [Y/N] : ");
        ansChar = s.next().toCharArray()[0];
        if (ansChar == 'y' || ansChar == 'Y') {
            isolation = true;
            System.out.print("How many days are you in isolation?");
            daysInIsolation = s.nextInt();
        }
        else if (ansChar == 'n' || ansChar == 'N')
            isolation = false;
        else
            isolation = false;

        System.out.println(controller.getLegalBallotBoxes(birthYear, isolation));

        System.out.println("Enter Ballot Box Number : ");
        ballotBox = controller.getElection().getBallotBoxByNumber(s.nextInt());

        soldierAge = controller.getElection().getYear() - birthYear <= 21;
        if (isolation && soldierAge)
            return new SoldierCorona(name, id, birthYear, isolation, ballotBox, daysInIsolation);
        else if (isolation)
            return new Corona(name, id, birthYear, isolation, ballotBox, daysInIsolation);
        else if (soldierAge)
            return new Soldier(name, id, birthYear, ballotBox);
        else
            return new Citizen(name, id, birthYear, ballotBox);
    }

    private Party getParty(Scanner s) {
        String name;
        String section;
        int sectionAns;
        int year;
        int month;
        int day;

        s.nextLine();
        System.out.print("Enter name : ");
        name = s.nextLine();

        System.out.print("Enter Section \n1 - Right \n2 - Center \n3 - Left ");
        sectionAns = s.nextInt();
        switch (sectionAns) {
            case 2:
                section = Party.CENTER_SECTION;
                break;
            case 3:
                section = Party.LEFT_SECTION;
                break;
            case 1:
            default:
                section = Party.RIGHT_SECTION;
                break;
        }

        System.out.print("Enter Creation Year : ");
        year = s.nextInt();

        System.out.print("Enter Creation Month : ");
        month = s.nextInt();

        System.out.print("Enter Creation Day : ");
        day = s.nextInt();

        return new Party(name, section, year, month, day);
    }

    private BallotBox<? extends Citizen> getBallotBox(Scanner s) {
        String address;
        int kind;

        s.nextLine();
        System.out.print("Enter Address : ");
        address = s.nextLine();

        System.out.print("Which kind of ballot box \n1 - Regular \n2 - Corona \n3 - Army\n4 - Army Corona ");
        kind = s.nextInt();
        switch (kind) {
            case 2:
                return new BallotBox<Corona>(address, Corona.class);
            case 3:
                return new BallotBox<Soldier>(address, Soldier.class);
            case 4:
                return new BallotBox<SoldierCorona>(address, SoldierCorona.class);
            case 1:
            default:
                return new BallotBox<Citizen>(address, Citizen.class);
        }
    }

    private String[] getCandidate(Scanner s) {
        String[] info = new String[3];

        System.out.print("Enter Citizen ID : ");
        info[0] = s.next();

        System.out.println(controller.election.getAllParties());
        s.nextLine();
        System.out.print("Enter Party Name : ");
        info[1] = s.nextLine();

        System.out.print("Enter Place : ");
        info[2] = Integer.toString(s.nextInt());

        return info;
    }

    private String getVoteParty(Scanner s, String citizenName) {
        System.out.print(citizenName + ", You want to vote ? [Y/N]");
        char ansChar = s.next().toCharArray()[0];
        if (ansChar == 'y' || ansChar == 'Y') {
            s.nextLine();
            System.out.print("You want to vote to : ");
            return s.nextLine();
        } else if (ansChar == 'n' || ansChar == 'N') {
            return "false";
        } else
            return " ";
    }

    private boolean CoronaQuiz(Scanner s) {
        System.out.print("Are you wearing a protective suit ?  [Y/N] ");
        char ansChar = s.next().toCharArray()[0];
        if (ansChar == 'y' || ansChar == 'Y')
            return true;
        return false;
    }
}

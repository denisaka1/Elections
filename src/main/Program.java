package main;

import controller.Controller;
import model.BallotBox;
import model.Party;
import model.VoterRegister;
import model.citizens.Citizen;
import model.citizens.Corona;
import model.citizens.Soldier;
import model.citizens.SoldierCorona;

public class Program {
    public static void main(String[] args) {
//        Controller controller = new Controller();
//        VoterRegister vr = new VoterRegister();

        BallotBox<Soldier> b1 = new BallotBox<Soldier>("asdasdas", Soldier.class);
        BallotBox<SoldierCorona> b2 = new BallotBox<SoldierCorona>("asdasdas", SoldierCorona.class);
        BallotBox<Citizen> b3 = new BallotBox<Citizen>("asdasdas", Citizen.class);
        BallotBox<Corona> b4 = new BallotBox<Corona>("asdasdas", Corona.class);

        SoldierCorona c1 = new SoldierCorona("Denis", "123456789", 1998);
        Corona c4 = new Corona("Denis", "123456789", 1998);
        Soldier c3 = new Soldier("Denis", "123456789", 1998);
        Citizen c2 = new Citizen("Denis", "123456789", 1998, b3);

        Controller c = new Controller();
        c.addBallotBox(b3);
        c.addCitizen(c2);
        c.addCitizen(c2);
        c.addCitizen(c2);


//        System.out.println(vr);
//        System.out.println(vr.getCitizens().get(0).getClass().getSimpleName());
//        System.out.println(vr.getCitizens().get(0));


        /*Elections e = new Elections();
        BallotBox<Corona> bc = new BallotBox<Corona>("ASDsadas", Corona.class);
        Corona c1 = new Corona("dsad","12312123", 2000);
        bc.addCitizen(c1);
        e.addBallotBox(bc);
        System.out.println(e.getCorona().get*/

        /*Scanner s = new Scanner(System.in);
        ServiceManager.hardCodeToTest(); // HARD CODE

        boolean exit = false;
        while (!exit) {
            ServiceManager.showMenu();
            int choose = s.nextInt();
            switch (choose) {
                case 1:
//                    ServiceManager.addBallotBox(getBallotBox(s));
                    break;
                case 2:
//                    ServiceManager.addCitizen(getCitizen(s, false));
                    break;
                case 3:
//                    ServiceManager.addParty(getParty(s));
                    break;
                case 4:
//                    String[] candidate = getCandidate(s);
//                    ServiceManager.addCandidate(candidate[0], candidate[1], Integer.parseInt(candidate[2]));
                    break;
                case 5:
                    System.out.println(ServiceManager.showAllBallotBox());
                    break;
                case 6:
                    System.out.println(ServiceManager.showAllCitizens());
                    break;
                case 7:
                    System.out.println(ServiceManager.showAllParties());
                    break;
                case 8:
                    ServiceManager.beginElections(s);
                    break;
                case 9:
                    ServiceManager.showResults();
                    break;
                case 10:
                default:
                    exit = true;
                    break;
            }
        }*/
    }

/*    public static Citizen getCitizen(Scanner s, boolean inParty) throws StringLengthException, UnderAgeException {
        String name;
        String id;
        int birthYear, daysInIsolation = 0;
        char ansChar;
        boolean isolation;
        BallotBox ballotBox;


        s.nextLine();
        System.out.print("Enter name : ");
        name = s.nextLine();

        boolean hasLegalID = false;
        String temp;
        do {
            System.out.println("Enter ID: ");
            temp = s.next();
            if (temp.length() == 9){
                id = temp;
                hasLegalID = true;
            }
            else
                throw new StringLengthException("Error in ID. ID must be with 9 numbers");
        } while (!hasLegalID);

        boolean isMinor = true;
        int tempInt;
        do {
            System.out.print("Enter Birth Year : ");
            tempInt = s.nextInt();
            if (election.getYear() - tempInt >= 18) {
                birthYear = tempInt;
                isMinor = false;
            } else
                throw new UnderAgeException("You are a minor. Can't enter to Voter Register");
        } while(isMinor);

        birthYear = s.nextInt();

        System.out.print("You in isolation [Y/N] : ");
        ansChar = s.next().toCharArray()[0];
        if (ansChar == 'y' || ansChar == 'Y') {
            isolation = true;
            System.out.println("How many days are you in isolation?");
            daysInIsolation = Integer.parseInt(s.nextLine());
        }
        else if (ansChar == 'n' || ansChar == 'N')
            isolation = false;
        else
            isolation = false;

        System.out.println(ServiceManager.getLegalBallotBoxes(birthYear, isolation));

        System.out.println("Enter Ballot Box Number : ");
        ballotBox = ServiceManager.getBallotBoxByNumber(s.nextInt());

        boolean soldierAge = (election.getYear() - birthYear <= 21);
        if (isolation && soldierAge)
            return new SoldierCorona(name, id, birthYear, isolation, ballotBox, daysInIsolation);
        else if (isolation)
            return new Corona(name, id, birthYear, isolation, ballotBox, daysInIsolation);
        else if (soldierAge)
            return new Soldier(name, id, birthYear, ballotBox);
        else
            return new Regular(name, id, birthYear, ballotBox);
    }

    public static Party getParty(Scanner s) {
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

    public static BallotBox getBallotBox(Scanner s) {
        String address;
        int kind;
        s.nextLine();
        System.out.print("Enter Address : ");
        address = s.nextLine();

        System.out.print("Which kind of ballot box \n1 - Regular \n2 - Army \n3 - Corona ");
        kind = s.nextInt();
        switch (kind) {
            case 2:
                return new Army(address);
            case 3:
                return new Corona(address);
            case 1:
            default:
                return new Regular(address);
        }
    }

    public static String[] getCandidate(Scanner s) {
        String[] info = new String[3];

        System.out.print("Enter Citizen ID : ");
        info[0] = s.next();

        System.out.println(ServicesManager.election.getAllPartiesLine());
        s.nextLine();
        System.out.print("Enter Party Name : ");
        info[1] = s.nextLine();

        System.out.print("Enter Place : ");
        info[2] = Integer.toString(s.nextInt());

        return info;
    }

    public static String getVoteParty(Scanner s, String citizenName) {
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

    public static boolean CoronaQuiz(Scanner s) {
        System.out.print("Are you wearing a protective suit ?  [Y/N] ");
        char ansChar = s.next().toCharArray()[0];
        if (ansChar == 'y' || ansChar == 'Y')
            return true;
        return false;
    }*/
}
package core;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            ServicesManager.showMenu();
            int choose = s.nextInt();
            if (choose >= 1 && choose <= 9)
                ServicesManager.swithMenu(choose);
            else
                break;
        }
    }
}
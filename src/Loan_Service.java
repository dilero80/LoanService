import Services.UserService;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Loan_Service {
    public static void main(String[] args) {
        boolean exit = false;
        do {
            Menu.displayPrincipalMenu();
            switch (selectOption()){
                case 1:
                    loanSwitch();
                    break;
                case 2:
                    userSwitch();
                    break;
                case 3:
                    libSwitch();
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }while (!exit);
    }

    private static void libSwitch() {
        boolean exit = false;
        do {
            Menu.displayLibMenu();
            switch (selectOption()){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit = true;
                    break;
            }

        }while (!exit);
    }

    private static void userSwitch() {

        UserService us = new UserService();
        boolean exit = false;
        do {
            Menu.displayUserMenu();
            switch (selectOption()){
                case 1:
                    us.createUser();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit = true;
                    break;
            }

        }while (!exit);
    }

    private static void loanSwitch() {
        Menu.displayLoanMenu();
        boolean exit = false;
        do {
            Menu.displayLibMenu();
            switch (selectOption()){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit = true;
                    break;
            }

        }while (!exit);
    }

    private static Integer selectOption(){
        Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
        System.out.println("Digit your option : ");
        return read.nextInt();
    }
}
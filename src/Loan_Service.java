import Services.LibMaterialService;
import Services.LoanService;
import Services.UserService;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Loan_Service {
    static UserService us = new UserService();

    public static void main(String[] args) throws Exception {
        boolean exit = false;
        us.getUserList();



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
                    libSwitch("Text");
                    break;
                case 4:
                    libSwitch("Audio");
                    break;
                case 5:
                    libSwitch("Video");
                    break;
                case 6:
                    exit = true;
                    break;
            }
        }while (!exit);
    }

    private static void libSwitch(String typeofAVT) throws Exception {
        boolean exit = false;
        int type = getTypeInt(typeofAVT);
        LibMaterialService lm = new LibMaterialService();
        do {
            Menu.displayLibMenu(typeofAVT);
            switch (selectOption()) {
                case 1 -> System.out.println("This Material has been created " + lm.createLibMaterial(type));
                case 2 -> lm.getLibList(type);
                case 3 -> System.out.println("This material has been Deleted " + lm.deleteLibMaterial(type));
                case 4 -> System.out.println("This material has been updated " + lm.updateLibMaterial(type));
                case 5 -> exit = true;
            }

        }while (!exit);
    }

    private static int getTypeInt(String typeofAVT) {
        return switch (typeofAVT){
            case "Text" -> 1;
            case "Audio" -> 2;
            case "Video" -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + typeofAVT);
        };

    }

    private static void userSwitch() throws Exception {

        boolean exit = false;
        do {
            Menu.displayUserMenu();
            switch (selectOption()) {
                case 1 -> us.createUser();
                case 2 -> us.showUserList();
                case 3 -> us.deleteUser();
                case 4 -> us.updateUser();
                case 5 -> exit = true;
            }

        }while (!exit);
    }

    private static void loanSwitch() throws Exception {
        LoanService ls = new LoanService();

        boolean exit = false;
        do {
            Menu.displayLoanMenu();
            switch (selectOption()){
                case 1:
                    if (ls.createLoan()){
                        System.out.println("LOAN CREATED CORRECTLY");
                    }
                    else {
                        System.out.println("LOAN CANNOT BE CREATED");
                    }
                    break;
                case 2:
                    if(ls.returnLoan()){
                        System.out.println("LOAN CORRECTLY RETURNED ");
                    }
                    else {
                        System.out.println("CAN'T RETURN LOAN");
                    }
                    break;
                case 3:
                    ls.printList();
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
package Services;

import Entities.LibMaterial;
import Entities.Loan;
import Entities.User;
import Enums.typeOfLibMaterial;
import Persistence.LoanDAO;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoanService {
    Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    ArrayList<Loan> loans;
    LibMaterialService libMaterialService = new LibMaterialService();
    LoanDAO dao = new LoanDAO();
    UserService us = new UserService();
    public LoanService() throws Exception {
        this.loans = getLoansList();
    }
    public boolean createLoan() throws Exception {
        Loan loan = new Loan();
        int id = loans.size() + 1;
        int typeOfLib = loansMenu();
        loan.setTypeOfLoan(typeOfLib);
        int userId = getUserIdforLoan();
        if (userId != 0) {
            loan.setUserId(userId);
        } else {
            return false;
        }
        System.out.println("Select type of Lib to Loan");
        loan.setLoanMaterial(getLibMaterialToLoan(typeOfLib));
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(LocalDate.of(3000,12,31));
        loans.add(loan);
        dao.saveLoan(loan);
        return true;
    }

    public boolean returnLoan() throws Exception {
        int id;
        Optional<Loan> loan = Optional.of(new Loan());
        getLoansList();
        System.out.println("DIGIT LOAN ID");
        id = read.nextInt();
        loan = Optional.ofNullable(dao.getLoanById(id));
        System.out.println(loan);
        if (loan.isPresent()){
            LibMaterial libMaterial = loan.get().getLoanMaterial();
            //libMaterial.setAvaliable(false);
            System.out.println(loan.get().getTypeOfLoan());
            libMaterialService.updateLibMaterialIsAvaliable(loan.get().getTypeOfLoan(), libMaterial);
            System.out.println("LOAN RETURNED");
            return true;
        }
        else{
            System.out.println("CAN'T RETURN LOAN");
            return false;

        }


    }
    private LibMaterial getLibMaterialToLoan(int option) {
        LibMaterial libMaterial;

        libMaterialService.getLibList(option);
        System.out.println("Insert ID of " +typeOfLibMaterial.values()[option-1] +" to Loan");
        do{
            libMaterial = libMaterialService.GetLibByID(option ,read.next());
            if (libMaterial == null) {
                System.out.println(typeOfLibMaterial.values()[option - 1] + "NOT FOUND");
                System.out.println("PLEASE INSERT CORRECT ID ");
            }
            else{
                    if (libMaterial.isAvaliable()) {
                        libMaterialService.updateLibMaterialIsAvaliable(option, libMaterial);
                    }
                    else {
                        System.out.println(typeOfLibMaterial.values()[option-1] + " IS NOT AVAILABLE");
                        return null;
                    }
            }

        }while ((libMaterial == null) && !libMaterial.isAvaliable());

        return libMaterial;


    }

    private int loansMenu(){
        int option;
        AtomicInteger counter = new AtomicInteger();
        do {
            System.out.println("========================================");
            System.out.println("----- TYPE OF LIB MATERIAL TO LOAN MENU-----");
            System.out.println("1. TEXT");
            System.out.println("2. AUDIO");
            System.out.println("3. VIDEO");
            //System.out.print(counter.getAndIncrement());
            //Arrays.stream(typeOfLibMaterial.values())

            Arrays.stream(typeOfLibMaterial.values())
                    .map(Enum::name)
                    .forEach(System.out::println);

            System.out.println("========================================");
            System.out.print("Digit the option");
            option = read.nextInt();
        }while(option > 3 );
        return option;
    }

    public int getUserIdforLoan () throws Exception {
        int id;
        Optional<User> userId;
        boolean flag = false;
        do{
            us.getUserList();
            System.out.println("Digit the User ID for Loan");
            id = read.nextInt();
            userId = us.getUserById(id);
            if (userId.isPresent()){
                flag = true;
            } else if (id == 0) {
                System.out.println("NOW EXIT");
                return 0;
            } else {
                System.out.println("User not found please insert new Id or press 0 for exit");
            }

        }while (!flag);
        return userId.get().getId();

    }
    public ArrayList<Loan> getLoansList() throws Exception {
        return dao.getLoans();

    }
    public void printList(){
        loans.forEach(System.out::println);

    }


}

package Services;

import Entities.Loan;
import Entities.Text;
import Persistence.LoanDAO;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LoanService {
    Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    LoanDAO loanDAO = new LoanDAO();
    public LoanService() {
    }

    public Loan createTextLoan(Text text){
        Loan loan = new Loan();
        System.out.println("Digit the User ID for Loan");
        loan.setUserId(read.nextInt());
        loan.setLoanMaterial(text);
        loan.setTypeOfLoan(1);
        loan.setReturnDate(null);


        return loan;
    }

}

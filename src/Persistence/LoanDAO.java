package Persistence;

import Entities.Loan;

import java.util.ArrayList;

public class LoanDAO extends DAO {


    public LoanDAO() {
    }

    public void saveLoan(Loan l) throws Exception {
        try {
            if (l == null) {
                throw new Exception("Loan can't be null");
            }
            String sql = "INSERT INTO Loans (loanMaterialId, loanDate, returnDate, idUser, typeOfLoan) "
                    + "VALUES ( " + l.getId()+ " , '" + l.getLoanDate()+ "' ,'" + l.getReturnDate() + "' ,'" + l.getUserId() + "' ,'" + l.getTypeOfLoan() + "');";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    public ArrayList<Loan> getLoansByUserId(Integer id) throws Exception {
        var loans = new ArrayList<Loan>();
        Loan loan = new Loan();
        try {
            if (id == null) {
                throw new Exception("User id can't be null");
            }
            String sql = "SELECT * FROM loans WHERE idUser = " + id;
            consultDB(sql);
            while (resultSet.next()) {
                loan.setId(Integer.valueOf(resultSet.getString(0)));
                //loan.setLoanMaterial(resultSet.getString(1));
                loan.setLoanDate(resultSet.getDate(2));
                loan.setReturnDate(resultSet.getDate(3));
                loan.setUserId(resultSet.getInt(4));
                loans.add(loan);
            }
            return loans;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

}

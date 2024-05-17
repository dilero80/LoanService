package Persistence;


import Entities.Loan;
import Services.LibMaterialService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class LoanDAO extends DAO<Loan> {

    LibMaterialService ls = new LibMaterialService();
    public LoanDAO() throws Exception {
    }

    @Override
    public void save(Loan l) throws Exception {
        try {
            if (l == null) {
                throw new Exception("Loan can't be null");
            }

            String sql = "INSERT INTO Loans (loanMaterialId, loanDate, returnDate, idUser, typeOfLoan) "
                    + "VALUES ( '" + l.getLoanMaterial().getId()+ "' , '" + l.getLoanDate()+ "' ,'" + l.getReturnDate() + "' ," + l.getUserId() + ", " + l.getTypeOfLoan() +");";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void delete(Loan object) throws Exception {
    }

    @Override
    public void update(Loan object, String lastId) throws Exception {
    }

    @Override
    public Loan getById(String id) throws Exception {
        try {
            /*if (id == Integer.parseInt(null)) {
                throw new Exception("Id can't be null");
            }*/
            Loan loan = new Loan();
            LocalDate loanDate = null;
            LocalDate returnLoanDate = null;
            int typeOfLib;
            String idOfLib;
            String sql = "SELECT * FROM loans WHERE idloans = " + id;
            consultDB(sql);
            while (resultSet.next()) {
                loan.setId(resultSet.getInt(1));
                idOfLib = resultSet.getString(2);
                try {
                    loanDate =(resultSet.getDate(3)).toLocalDate();
                    returnLoanDate = (resultSet.getDate(4)).toLocalDate();
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                loan.setLoanDate(loanDate);
                loan.setReturnDate(returnLoanDate);
                loan.setUserId(resultSet.getInt(5));
                typeOfLib = resultSet.getInt(6);
                loan.setTypeOfLoan(typeOfLib);
                loan.setLoanMaterial(ls.GetLibByID(typeOfLib,idOfLib));

                return loan;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
        return null;
    }

    @Override
    public List<Loan> getList() throws Exception {
        LocalDate loanDate = null;
        LocalDate returnLoanDate = null;
        int typeOfLib;
        String idOfLib;
        var loans = new ArrayList<Loan>();


        try {
            String sql = "SELECT * FROM loans" ;
            consultDB(sql);
            while (resultSet.next()) {
                Loan loan = new Loan();
                loan.setId(resultSet.getInt(1));
                idOfLib = resultSet.getString(2);
                try {
                    loanDate =(resultSet.getDate(3)).toLocalDate();
                    returnLoanDate = (resultSet.getDate(4)).toLocalDate();

                }catch (Exception e){
                    System.out.println(e.toString());
                }
                loan.setLoanDate(loanDate);
                loan.setReturnDate(returnLoanDate);
                loan.setUserId(resultSet.getInt(5));
                typeOfLib = resultSet.getInt(6);
                loan.setLoanMaterial(ls.GetLibByID(typeOfLib,idOfLib));
                System.out.println(loan);
                loans.add(loan);
            }
            loans.forEach(System.out::println);
            return loans;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }
    public ArrayList<Loan> getLoansByUserId(Integer id) throws Exception {
        LocalDate loanDate = null;
        LocalDate returnLoanDate = null;
        int typeOfLib;
        String idOfLib;
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
                idOfLib = resultSet.getString(1);
                try {
                    loanDate =(resultSet.getDate(2)).toLocalDate();
                    returnLoanDate = (resultSet.getDate(3)).toLocalDate();

                }catch (Exception e){
                    System.out.println(e.toString());
                }
                loan.setLoanDate(loanDate);
                loan.setReturnDate(returnLoanDate);
                loan.setUserId(resultSet.getInt(4));
                typeOfLib = resultSet.getInt(5);
                loan.setLoanMaterial(ls.GetLibByID(typeOfLib,idOfLib));
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

package Entities;

import java.sql.Date;
import java.util.Calendar;

public class Loan {
    private Integer id;
    private LibMaterial loanMaterial;
    private Date loanDate;
    private Date returnDate;
    private Integer userId;
    private Integer typeOfLoan;


    public Loan() {
    }

    public Loan(Integer id, LibMaterial loanMaterial, Date loanDate, Date returnDate, Integer userId, Integer typeOfLoan) {
        this.id = id;
        this.loanMaterial = loanMaterial;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.userId = userId;
        this.typeOfLoan = typeOfLoan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LibMaterial getLoanMaterial() { return loanMaterial;
    }

    public void setLoanMaterial(LibMaterial loanMaterial) {
        this.loanMaterial = loanMaterial;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeOfLoan() {
        return typeOfLoan;
    }

    public void setTypeOfLoan(Integer typeOfLoan) {
        this.typeOfLoan = typeOfLoan;
    }
}


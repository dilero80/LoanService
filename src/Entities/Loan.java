package Entities;



import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private Integer id;
    private LibMaterial loanMaterial;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private Integer userId;
    private Integer typeOfLoan;



    public Loan() {
    }

    public Loan(Integer id, LibMaterial loanMaterial, LocalDate loanDate, LocalDate returnDate, Integer userId, Integer typeOfLoan) {
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

    public LibMaterial getLoanMaterial() {
        return loanMaterial;
    }

    public void setLoanMaterial(LibMaterial loanMaterial) {
        this.loanMaterial = loanMaterial;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan loan)) return false;
        return Objects.equals(id, loan.id) && Objects.equals(loanMaterial, loan.loanMaterial) && Objects.equals(loanDate, loan.loanDate) && Objects.equals(returnDate, loan.returnDate) && Objects.equals(userId, loan.userId) && Objects.equals(typeOfLoan, loan.typeOfLoan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanMaterial, loanDate, returnDate, userId, typeOfLoan);
    }

    @Override
    public String toString() {
        return "Loan => " +
                "id=" + id +
                ", loanMaterial= [\n" + loanMaterial + "\n]" +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", userId=" + userId;
    }
}



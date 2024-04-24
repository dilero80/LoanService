package Entities;

import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private Integer id;
    private ArrayList<Loan> loans ;

    public User(String name, String surname, Integer id, ArrayList<Loan> loans) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.loans = loans;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }
}

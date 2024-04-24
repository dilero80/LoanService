package Persistence;

import Entities.Loan;
import Entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO{

    public void saveUser(User u) throws Exception {
        try {
            if (u == null) {
                throw new Exception("User can't be null");
            }
            String sql = "INSERT INTO users (userId, name, surname) "
                    + "VALUES ( " + u.getId()+ " , '" + u.getName() + "' ,'" + u.getSurname() + "');";

            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    public void deleteUser(User u) throws Exception {
        try {
            if (u == null) {
                throw new Exception("User can't be null");
            }
            String sql = "DELETE FROM users WHERE userId = " + u.getId();
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    public User findUserById(Integer id) throws Exception {
        User user = new User();
        try {
            if (id == null) {
                throw new Exception("ID can't be null");
            }
            String sql = "SELECT * FROM users WHERE userId = " + id;
            consultDB(sql);
            while (resultSet.next()) {
                user.setId(Integer.valueOf(resultSet.getString(0)));
                user.setName(resultSet.getString(1));
                user.setSurname(resultSet.getString(2));
            }
            return user;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    public List<User> getUsers(Integer id) throws Exception {
        List<User> users= new ArrayList<>();
        List <Loan> loans = new ArrayList<>();
        User user = new User();
        LoanDAO lsDAO = new LoanDAO();
        try {
            if (id == null) {
                throw new Exception("ID can't be null");
            }
            String sql = "SELECT * FROM users";
            consultDB(sql);
            while (resultSet.next()) {
                user.setId(Integer.valueOf(resultSet.getString(0)));
                user.setName(resultSet.getString(1));
                user.setSurname(resultSet.getString(2));
                user.setLoans(lsDAO.getLoansByUserId(id));
            }
            return users;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }




}

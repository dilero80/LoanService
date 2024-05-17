package Persistence;

import Entities.Loan;
import Entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User>{

    public UserDAO() {
    }

    @Override
    public void save(User user) throws Exception {
        try {
            if (user == null) {
                throw new Exception("User can't be null");
            }
            String sql = "INSERT INTO users (userId, name, surname) "
                    + "VALUES ( " + user.getId()+ " , '" + user.getName() + "' ,'" + user.getSurname() + "');";

            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void delete(User user) throws Exception {
        try {
            if (user == null) {
                throw new Exception("User can't be null");
            }
            String sql = "DELETE FROM users WHERE userId = " + user.getId();
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void update(User user, String lastId) throws Exception {
        try {
            if (user == null) {
                throw new Exception("User can't be null");
            }
            String sql = "'UPDATE users SET" +
                    "userId =" + user.getId() +"name ='" + user.getName() + "', surname = '" + user.getSurname() + "'" +
                    "WHERE id = " + lastId;

            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    @Override
    public User getById(String id) throws Exception {
        User user = new User();
        try {
            if (id == null) {
                throw new Exception("ID can't be null");
            }
            String sql = "SELECT * FROM users WHERE userId = " + id;
            consultDB(sql);
            while (resultSet.next()) {
                user.setId(Integer.valueOf(resultSet.getString(2)));
                user.setName(resultSet.getString(3));
                user.setSurname(resultSet.getString(4));
            }
            return user;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    @Override
    public ArrayList<User> getList() throws Exception {
        ArrayList<User> users= new ArrayList<>();
        List <Loan> loans = new ArrayList<>();
        LoanDAO lsDAO = new LoanDAO();
        try {
            String sql = "SELECT * FROM users";
            consultDB(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(2));
                user.setName(resultSet.getString(3));
                user.setSurname(resultSet.getString(4));
                //user.setLoans(lsDAO.getLoansByUserId(user.getId()));
                user.setLoans(null);
                System.out.println(user);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }




}

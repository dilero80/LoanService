package Services;

import Entities.Loan;
import Entities.User;
import Persistence.UserDAO;

import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    UserDAO dao = new UserDAO();
    public UserService() {
    }

    public User createUser(){
        User user = new User();
        System.out.println("============CREATE USER================");
        System.out.println("Insert Name");
        user.setName(read.next());
        System.out.println("Insert Surname");
        user.setSurname(read.next());
        System.out.println("Digit ID");
        user.setId(read.nextInt());
        user.setLoans(new ArrayList<Loan>());
        try {
            dao.saveUser(user);
        } catch (Exception e) {
            System.out.println("User Creation error on SQL");
            throw new RuntimeException(e);

        }
        System.out.println("User Created Successfully");
        return user;
    }
     public void deleteUser () throws Exception {
        User user = new User();
        System.out.println("============DELETE USER================");
        System.out.println("Digit User ID to Delete");
        user = dao.findUserById(read.nextInt());

        try {
            dao.deleteUser(user);
        } catch (Exception e) {
            System.out.println("User Creation error on SQL");
            throw new RuntimeException(e);

         }

     }






}

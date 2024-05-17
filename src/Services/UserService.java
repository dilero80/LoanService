package Services;

import Entities.Loan;
import Entities.User;
import Persistence.UserDAO;
import org.w3c.dom.ls.LSOutput;

import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserService {

    Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    UserDAO dao = new UserDAO();
    List<User> users = new ArrayList<>();
    public UserService() {
    }

    public void createUser(){
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
            dao.save(user);
            this.addUserToList(user);
        } catch (Exception e) {
            System.out.println("User Creation error on SQL");
            throw new RuntimeException(e);

        }
        System.out.println("User Created Successfully");

    }
     public void deleteUser () throws Exception {
        User user = new User();
        System.out.println("============DELETE USER================");
        System.out.println("Digit User ID to Delete");
        user = dao.getById(String.valueOf(read.nextInt()));
        try {
            dao.delete(user);
            System.out.println(user);
            this.users.remove(user);
        } catch (Exception e) {
            System.out.println("User Delete error on SQL");
            throw new RuntimeException(e);

         }
     }

     private void addUserToList(User user){
        users.add(user);
     }

     public void getUserList() throws Exception {
        this.users = dao.getList();
        System.out.println(this.users);
     }

     public void showUserList(){
        users.forEach(System.out::println);
     }

     private User findUserById (String id) throws Exception {

        try {
             return dao.getById(id);
         } catch (Exception e) {
             throw new RuntimeException(e);
         }


     }

    public void updateUser() {
        try{
            User user = new User();
            System.out.println("============UPDATE USER================");
            System.out.println("Digit User ID to Update");
            user = dao.getById(read.next());
            int lastId = user.getId();
            int listPos = users.indexOf(user);
            System.out.println("Digit new Name");
            user.setName(read.next());
            System.out.println("Digit new Surname");
            user.setSurname(read.next());
            System.out.println("Digit new ID");
            user.setId(read.nextInt());
            dao.update(user, String.valueOf(lastId));
            users.set(listPos,user);
            System.out.println("User Updated");
        }
        catch (Exception e){
            System.out.println("Error updating user");
        }
    }

    public Optional<User> getUserById (int id) throws Exception {
        return Optional.ofNullable(dao.getById(String.valueOf(id)));
    }
}

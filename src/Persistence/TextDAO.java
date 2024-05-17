package Persistence;

import Entities.Loan;
import Entities.Text;
import Entities.User;

import java.util.ArrayList;
import java.util.List;

public class TextDAO extends DAO<Text>{

    public TextDAO() {}

    @Override
    public void save(Text text) throws Exception {
        try {
            if (text == null) {
                throw new Exception("Text can't be null");
            }
            String sql = "INSERT INTO texts (idText, author, isAvailable, numPages) "
                    + "VALUES ( " + text.getId()+ " , '" + text.getAuthor()
                    + "' ,'" + (text.isAvaliable()? 1:0) + "','" + text.getNumPages() + "');";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void delete(Text text) throws Exception {
        try {
            if (text == null) {
                throw new Exception("Text  can't be null");
            }
            String sql = "DELETE FROM text WHERE userId = " + text.getId();
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void update(Text text, String lastId) throws Exception {
        try {
            if (text == null) {
                throw new Exception("Text can't be null");
            }
            String sql = "UPDATE texts SET " +
                    "idText ='" + text.getId() +"', author ='" + text.getAuthor() + "', numPages = " + text.getNumPages() + "', numPages = " + text.getNumPages() +
                    " WHERE idText = '" + lastId + "';";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            disconnectDB();
        }
    }

    @Override
    public Text getById(String id) throws Exception {
        Text text = new Text();
        try {
            if (id == null) {
                throw new Exception("ID can't be null");
            }
            String sql = "SELECT * FROM texts WHERE idText = " + id;
            consultDB(sql);
            while (resultSet.next()) {
                text.setId(resultSet.getString(2));
                text.setAuthor(resultSet.getString(3));
                text.setAvaliable(resultSet.getInt(4) == 1);
                text.setNumPages(resultSet.getInt(5));
            }
            return text;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            disconnectDB();
        }
        return null;
    }

    @Override
    public List<Text> getList() throws Exception {
        ArrayList<Text> texts= new ArrayList<>();
        try {
            String sql = "SELECT * FROM texts";
            consultDB(sql);

            while (resultSet.next()) {
                Text text = new Text();
                text.setId(resultSet.getString(2));
                text.setAuthor(resultSet.getString(3));
                text.setAvaliable(resultSet.getInt(4) == 1);
                text.setNumPages(resultSet.getInt(5));
                texts.add(text);
            }
            return texts;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }


    public void updateTextIsAvaliable(Text text, String id) throws Exception {
        try {
            if (text == null) {
                throw new Exception("Text can't be null");
            }
            System.out.println(text.isAvaliable());
            int isAvailable = (text.isAvaliable()?1:0);
            String sql = "UPDATE texts SET " +
                    "isAvailable = " + isAvailable +
                    " WHERE idText = '" + id + "';";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            disconnectDB();
        }
    }

}

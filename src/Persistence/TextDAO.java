package Persistence;

import Entities.Text;
import Entities.User;

public class TextDAO extends DAO{

    public TextDAO() {

    }

    public void saveText(Text text) throws Exception {
        try {
            if (text == null) {
                throw new Exception("Text can't be null");
            }
            String sql = "INSERT INTO texts (idText, author, isAvailable, numPages) "
                    + "VALUES ( " + text.getId()+ " , '" + text.getAuthor()
                    + "' ,'" + text.isAvaliable() + "','" + text.getNumPages() + "');";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    public void deleteText(Text text) throws Exception {
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





}

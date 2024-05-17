package Persistence;

import Entities.Audio;
import Entities.LibMaterial;

import java.sql.*;
import java.util.*;

public abstract class DAO<T> {
    protected Connection connection;
    protected ResultSet resultSet;
    protected Statement statement;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "loans";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBURL = "jdbc:mysql://127.0.0.1:3306/";

    protected void connectDB() throws Exception {
        try {
            Class.forName(DRIVER);
            String urlDB = DBURL + DATABASE + "?useSSL=true&requireSSL=true";
            connection = DriverManager.getConnection(urlDB, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void disconnectDB() throws Exception {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    protected void insertModifyDelete(String sql) throws Exception {
        try {
            connectDB();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            // connection.rollback();
            /*  Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente script en Workbench

                SET autocommit=1;
                COMMIT;

                **Sin rollback igual anda */

            System.out.println(ex.toString());
        } finally {
            disconnectDB();
        }
    }

    protected void consultDB(String sql) throws Exception {
        try {
            connectDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public abstract void save(T object) throws Exception;

    public abstract void delete(T object) throws Exception;

    public abstract void update(T object, String lastId) throws Exception;

    public abstract T getById(String id) throws Exception;

    public abstract List<T> getList() throws Exception;





}

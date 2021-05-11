package data;

import java.sql.*;

public class MySQLService {


    private Connection con;


    public MySQLService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/necromunda", "Simon", "password");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet call(String statement) {
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();

            rs = stmt.executeQuery(statement);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  rs ;
    }
}

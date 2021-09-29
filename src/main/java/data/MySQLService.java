package data;

import java.sql.*;


//https://86.12.177.19:4567/campaign

public class MySQLService {


    public Connection con;


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

    public PreparedStatement createStatement(String statement, Integer options) throws Exception {
        return con.prepareStatement(statement, options);
    }

    public PreparedStatement createStatement(String statement) throws Exception {
        return con.prepareStatement(statement);
    }

    public ResultSet get(PreparedStatement statement) {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }

    public Integer create(PreparedStatement statement) {
        Integer lastId = null;

        try {
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                lastId = rs.getInt(1);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastId;
    }

    public ResultSet update(PreparedStatement statement) {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }

    public void delete(PreparedStatement statement) {
        try {
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}


package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    Connection connection = null;

    public DBConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/finalProject";
            String dbName = "root";
            String dbPassword = "";

            connection = DriverManager.getConnection(dbURL,dbName,dbPassword);
            System.out.printf("DB Connected");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
    }

    public PreparedStatement getStatement(String query){

        PreparedStatement pstn = null;
        try {
            pstn = connection.prepareStatement(query);
        }
        catch (SQLException e ){
            e.printStackTrace();
        }
        return pstn;
    }


}
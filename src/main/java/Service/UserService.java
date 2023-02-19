package Service;

import DBConnection.DBConnection;
import Model.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    public void insertUser(Student student){
        String query = "insert into user(userName, fullName, password)" + "values(?,?,?)"; // same as database

        PreparedStatement preparedStatements = new DBConnection().getStatement(query);  // execute parametrized query

        try{
            preparedStatements.setString(1, student.getUserName());
            preparedStatements.setString(1, student.getFullName());
            preparedStatements.setString(1, student.getPassword());


        }
        catch(
                SQLException e){
            e.printStackTrace();
        }
    }



}

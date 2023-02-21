package Service;

import DBConnection.DBConnection;
import Model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    public void insertUser(Student student){
        String query = "insert into user(userName, fullName, password)" + "values(?,?,?)"; // same as database

        PreparedStatement preparedStatements = new DBConnection().getStatement(query);  // execute parametrized query

        try{
            preparedStatements.setString(1, student.getUserName());
            preparedStatements.setString(2, student.getFullName());
            preparedStatements.setString(3, student.getPassword());

            preparedStatements.execute();

        }
        catch(
                SQLException e){
            e.printStackTrace();
        }
    }


    // Delete User
    public void deleteUser(int id){
        String query = "delete from user where id = ?";
        PreparedStatement ps = new DBConnection().getStatement(query);

        try{
            ps.setInt(1,id);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(int id, Student student) throws SQLException{
//        Strin
    }

    public Student getUser(String userName, String password){
        Student student = null;

        String query = "select * from user where userName=? and password=?";
        PreparedStatement ps = new DBConnection().getStatement(query);

        try {
          ps.setString(1, userName);
          ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                student = new Student();

                student.setId(rs.getInt("id"));
                student.setUserName(rs.getString("userName"));

                student.setFullName(rs.getString("fullName"));
                student.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }


}

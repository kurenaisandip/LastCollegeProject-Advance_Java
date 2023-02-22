package Service;

import DBConnection.DBConnection;
import Model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        String query = "update users set full_name=?,userName=?,password=?," +
                "role=? where id=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        pstm.setString(1, student.getFullName());
        pstm.setString(2, student.getUserName());
        pstm.setString(3, student.getPassword());
//        pstm.setString(4, student.getRole());
        pstm.setInt(5, id);

        pstm.execute();
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


    public List<Student> getUserList() {
        List<Student> userList = new ArrayList<>();
        String query = "select * from users";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setFullName(rs.getString("fullName"));
                student.setUserName(rs.getString("userName"));
                student.setPassword(rs.getString("password"));


                userList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }


}

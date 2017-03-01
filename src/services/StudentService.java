package services;

import domains.Student;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna KC on 12/18/2016.
 */
public class StudentService {

    public void delete(int id) {

        String query = "delete from student where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Student getStudent(int id) {
        Student student= null;

        String query = "select * from student where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setRoll(rs.getInt("roll"));
                student.setFaculty(rs.getString("faculty"));
                student.setAddress(rs.getString("address"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public List<Student> getStudentList(){

        List<Student> studentList = new ArrayList<Student>();
        String query = "select * from student";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setRoll(rs.getInt("roll"));
                student.setFaculty(rs.getString("faculty"));
                student.setAddress(rs.getString("address"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));

                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public void insert(Student student) {
        String query = "insert into student (name,roll,faculty,address,age,gender) values(?,?,?,?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, student.getName());
            pstm.setInt(2, student.getRoll());
            pstm.setString(3,student.getFaculty());
            pstm.setString(4,student.getAddress());
            pstm.setInt(5,student.getAge());
            pstm.setString(6,student.getGender());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Student student) {
        String query = "update student set name=?, roll=?, faculty=?, address=?, age=?,gender=? where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, student.getName());
            pstm.setInt(2, student.getRoll());
            pstm.setString(3,student.getFaculty());
            pstm.setString(4,student.getAddress());
            pstm.setInt(5,student.getAge());
            pstm.setString(6,student.getGender());
            pstm.setInt(7, student.getId());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


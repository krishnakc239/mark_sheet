package services;

import domains.Student;
import domains.Subject;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna KC on 12/24/2016.
 */
public class MarkServices {

    public List<Student> getStudentList() {
        List<Student> studentlist = new ArrayList<>();
        String query = "select * from student";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setRoll(new Integer(rs.getString("roll")));

                studentlist.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentlist;

    }
    public List<Subject> getSubjectList(){

        List<Subject> subjectList = new ArrayList<Subject>();
        String query = "select * from subject";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getInt("id"));
                subject.setCode(rs.getString("code"));
                subject.setName(rs.getString("name"));
                subject.setPM(rs.getInt("PM"));
                subject.setFM(rs.getInt("FM"));
                subject.setBatch(rs.getString("batch"));

                subjectList.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjectList;
    }
}


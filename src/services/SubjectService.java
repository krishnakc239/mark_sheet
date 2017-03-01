package services;


import domains.Subject;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna KC on 12/18/2016.
 */
public class SubjectService {

    public void delete(int id) {

        String query = "delete from subject where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Subject getSubject(int id) {
        Subject subject= null;

        String query = "select * from subject where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                subject = new Subject();
                subject.setId(rs.getInt("id"));
                subject.setCode(rs.getString("code"));
                subject.setName(rs.getString("name"));
                subject.setPM(rs.getInt("PM"));
                subject.setFM(rs.getInt("FM"));
                subject.setBatch(rs.getString("batch"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subject;
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

    public void insert(Subject subject) {
        String query = "insert into subject (code,name,PM,FM,batch) values(?,?,?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, subject.getCode());
            pstm.setString(2, subject.getName());
            pstm.setInt(3, subject.getPM());
            pstm.setInt(4, subject.getFM());
            pstm.setString(5,subject.getBatch());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Subject subject) {
        String query = "update subject set code=?, name=?, PM=?,FM=?,batch=? where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, subject.getCode());
            pstm.setString(2, subject.getName());
            pstm.setInt(3,subject.getPM());
            pstm.setInt(4,subject.getFM());
            pstm.setString(5,subject.getBatch());
            pstm.setInt(6,subject.getId());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}



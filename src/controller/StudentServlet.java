package controller;

import domains.Student;
import domains.Student;
import services.StudentService;
import services.StudentService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

/**
 * Created by krishna KC on 12/18/2016.
 */
public class StudentServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String page = request.getParameter("page");
        page = BaseController.checkSession(request,response,page);
        RequestDispatcher rd;
        String message = "";

        if (page.equalsIgnoreCase("studentList")) {
            List<Student> studentList = new StudentService().getStudentList();
            request.setAttribute("studentList", studentList);
            rd = request.getRequestDispatcher("student/list.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("studentForm")) {
            rd = request.getRequestDispatcher("student/studentForm.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("addstudent")) {
            Student student = new Student();
            student.setName(request.getParameter("name"));
            student.setRoll(new Integer(request.getParameter("roll")));
            student.setFaculty(request.getParameter("faculty"));
            student.setAddress(request.getParameter("address"));
            student.setAge(new Integer(request.getParameter("age")));
            student.setGender(request.getParameter("gender"));
            new StudentService().insert(student);

            List<Student> studentList = new StudentService().getStudentList();
            request.setAttribute("studentList", studentList);
            rd = request.getRequestDispatcher("student/list.jsp");
            rd.forward(request,response);
        }

        if (page.equalsIgnoreCase("edit")) {
            int id = new Integer(request.getParameter("id"));
            Student student = new StudentService().getStudent(id);
            request.setAttribute("student", student);
            rd = request.getRequestDispatcher("student/edit.jsp");
            rd.forward(request,response);

        }
        if (page.equalsIgnoreCase("updatestudent")) {

            int id = new Integer(request.getParameter("id"));
            Student student = new Student();
            student.setName(request.getParameter("name"));
            student.setRoll(new Integer(request.getParameter("roll")));
            student.setFaculty(request.getParameter("faculty"));
            student.setAddress(request.getParameter("address"));
            student.setAge(new Integer(request.getParameter("age")));
            student.setGender(request.getParameter("gender"));
            student.setId(id);

            new StudentService().update(student);
            List<Student> studentList = new StudentService().getStudentList();
            request.setAttribute("studentList", studentList);
            rd = request.getRequestDispatcher("student/list.jsp");
            rd.forward(request,response);

        }
        if (page.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new StudentService().delete(id);

            List<Student> studentList = new StudentService().getStudentList();
            request.setAttribute("studentList", studentList);
            rd = request.getRequestDispatcher("student/list.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}


package controller;

import domains.Student;
import domains.Subject;
import services.StudentService;
import services.SubjectService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by krishna KC on 12/18/2016.
 */
public class MarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        RequestDispatcher rd = null;
        if (page.equalsIgnoreCase("markList")) {

            List<Student> studentList = new StudentService().getStudentList();
            request.setAttribute("studentList",studentList);
            rd = request.getRequestDispatcher("mark/list.jsp");
            rd.forward(request, response);

        }

        if (page.equalsIgnoreCase("marksAdd")) {

            int id = Integer.parseInt(request.getParameter("id"));
            Student student = new StudentService().getStudent(id);
            request.setAttribute("student", student);

            List<Student> studentList = new StudentService().getStudentList();
            List<Subject> subjectList = new SubjectService().getSubjectList();

            request.setAttribute("studentList", studentList);
            request.setAttribute("subjectList", subjectList);

            rd=request.getRequestDispatcher("mark/marksForm1.jsp");
            rd.forward(request, response);

        }
        if(page.equalsIgnoreCase("viewMarkSheet")){
            rd=request.getRequestDispatcher("mark/marksheet.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

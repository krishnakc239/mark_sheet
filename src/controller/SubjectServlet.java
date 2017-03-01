package controller;

import domains.Subject;
import services.SubjectService;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

/**
 * Created by krishna KC on 12/18/2016.
 */
public class SubjectServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String page = request.getParameter("page");
        page = BaseController.checkSession(request,response,page);
        RequestDispatcher rd;
        String message = "";

        if (page.equalsIgnoreCase("subjectList")) {
            List<Subject> subjectList = new SubjectService().getSubjectList();
            request.setAttribute("subjectList", subjectList);
            rd = request.getRequestDispatcher("subject/list.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("subjectForm")) {
            rd = request.getRequestDispatcher("subject/subjectForm.jsp");
            rd.forward(request,response);
        }

        if (page.equalsIgnoreCase("addsubject")) {
            Subject subject = new Subject();
            subject.setCode(request.getParameter("code"));
            subject.setName(request.getParameter("name"));
            subject.setPM(new Integer(request.getParameter("PM")));
            subject.setFM(new Integer(request.getParameter("FM")));
            subject.setBatch(request.getParameter("batch"));
            new SubjectService().insert(subject);

            List<Subject> subjectList = new SubjectService().getSubjectList();
            request.setAttribute("subjectList", subjectList);
            rd = request.getRequestDispatcher("subject/list.jsp");
            rd.forward(request,response);
        }

        if (page.equalsIgnoreCase("edit")) {
            int id = new Integer(request.getParameter("id"));
            Subject subject = new SubjectService().getSubject(id);
            request.setAttribute("subject", subject);
            rd = request.getRequestDispatcher("subject/edit.jsp");
            rd.forward(request,response);

        }
        if (page.equalsIgnoreCase("updatesubject")) {

            int id = new Integer(request.getParameter("id"));
            Subject subject = new Subject();
            subject.setCode(request.getParameter("code"));
            subject.setName(request.getParameter("name"));
            subject.setPM(new Integer((request.getParameter("PM"))));
            subject.setFM(new Integer((request.getParameter("FM"))));
            subject.setBatch(request.getParameter("batch"));
            subject.setId(id);

            new SubjectService().update(subject);
            message = "Subject Updated!!";
            request.setAttribute("message", message);

            List<Subject> subjectList = new SubjectService().getSubjectList();
            request.setAttribute("subjectList", subjectList);
            rd = request.getRequestDispatcher("subject/list.jsp");
            rd.forward(request,response);

        }
        if (page.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new SubjectService().delete(id);

            List<Subject> subjectList = new SubjectService().getSubjectList();
            request.setAttribute("subjectList", subjectList);
            rd = request.getRequestDispatcher("subject/list.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}



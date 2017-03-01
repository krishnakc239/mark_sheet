package controller;

import domains.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by krishna KC on 12/20/2016.
 */
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        page = BaseController.checkSession(request, response, page);
        RequestDispatcher rd;
        String message = "";

        if (page.equalsIgnoreCase("login")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new UserService().getUser(username, password);

            if (user!=null) {//user tat is logging in when login button clicked  Welcome To:${(sessionScope.user.name)};
                HttpSession session=request.getSession(false);
                session.setAttribute("user", user);
                message = "Login Succes!!!!";
                request.setAttribute("message",message);
                rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request,response);
            }else{
                message = "Invalid Login. Please check username or password!";
                request.setAttribute("message",message);
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }

        }
        if (page.equalsIgnoreCase("logout")) {
            HttpSession session=request.getSession(false);
            session.invalidate();

            message = "Successfully Logged out!!";
            request.setAttribute("message",message);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

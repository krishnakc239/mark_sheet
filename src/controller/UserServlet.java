package controller;

import domains.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Krishna K.C on 12/12/2016.
 */
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String page = request.getParameter("page");
        page = BaseController.checkSession(request, response, page);
        RequestDispatcher rd;
        String message = "";

        if(page.equalsIgnoreCase("home")){

            message ="HOME!!!";
            request.setAttribute("message",message);
            rd=request.getRequestDispatcher("user/home.jsp");
            rd.forward(request, response);

        }
        if (page.equalsIgnoreCase("userList")) {
            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);
            rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("userForm")) {
            rd = request.getRequestDispatcher("user/userForm.jsp");
            rd.forward(request, response);
        }


        if (page.equalsIgnoreCase("addUser")) {
            User user = new User();
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));
            new UserService().insert(user);
            message = "User Added!!";
            request.setAttribute("message", message);

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);
            rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().getUser(id);
            request.setAttribute("user", user);
            rd = request.getRequestDispatcher("user/edit.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("updateUser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new User();
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));
            user.setId(id);

            new UserService().update(user);

            message = "User Updated!!";
            request.setAttribute("message", message);

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);
            rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().delete(id);

            message = "User Deleted!!";
            request.setAttribute("message", message);

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);
            rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }


    }



    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}

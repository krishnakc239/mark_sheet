package controller;
import domains.User;
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
public class BaseController extends HttpServlet {
    public static String checkSession(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        if(page == null){
            page = "test";
        }
        RequestDispatcher rd = null;
        if(!page.equalsIgnoreCase("login") && !page.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession(true);
            User user = (User) session.getAttribute("user");

            if(user == null){
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }
        }
        return page;
    }
}

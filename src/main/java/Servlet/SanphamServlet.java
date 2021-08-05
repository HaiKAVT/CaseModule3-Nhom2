package Servlet;

import Models.User;
import Services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class SanphamServlet extends HttpServlet {
    UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "about" :
                resp.sendRedirect("views/about.jsp");
                break;
            case "createUser":
//                req.setAttribute("listUser", userService.listUser);
                resp.sendRedirect("views/createAccount.jsp");
//                requestDispatcher = req.getRequestDispatcher("views/createAccount.jsp");
//                requestDispatcher.forward(req, resp);
                break;
            case "deleteUser":
                int indexDeleteUser = Integer.parseInt(req.getParameter("id"));
                try {
                    userService.delete(indexDeleteUser);
                    req.setAttribute("listUser", userService.listUser);
                    req.setAttribute("listSp", userService.listUser);
                    requestDispatcher = req.getRequestDispatcher("views/homeAdmin.jsp");
                    requestDispatcher.forward(req, resp);
                } catch (Exception e) {
                    resp.sendRedirect("views/404.jsp");
                }
                break;
            default:
                req.setAttribute("listUser", userService.listUser);
                requestDispatcher = req.getRequestDispatcher("views/login.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createUser":
                try {
                    String ten = req.getParameter("ten");
                    String sdt = req.getParameter("sdt");
                    String email = req.getParameter("email");
                    String diachi = req.getParameter("diachi");
                    String birthday = req.getParameter("birthday");
                    String userName = req.getParameter("userName");
                    String passWord = req.getParameter("passWord");

                    User user = new User(1, ten, sdt, email, diachi, birthday, userName, passWord);
                    userService.save(user);
                    resp.sendRedirect("views/login.jsp");
                } catch (Exception e) {
                    resp.sendRedirect("views/404.jsp");
                }
                break;
            case "login":
                boolean check = false;
                String userName = req.getParameter("userName");
                String passWord = req.getParameter("passWord");
                for (User user : userService.listUser) {
                    if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
                        check = true;
                        break;
                    }
                    if (userName.equals("admin") && passWord.equals("admin")) {
                        req.setAttribute("listUser", userService.listUser);
                        req.setAttribute("listSp", userService.listUser);
                        requestDispatcher = req.getRequestDispatcher("views/homeAdmin.jsp");
                        requestDispatcher.forward(req, resp);
                        break;
                    }

                }

                if (check) {
                    req.setAttribute("listUser", userService.listUser);
                    requestDispatcher = req.getRequestDispatcher("views/homeUser.jsp");
                    requestDispatcher.forward(req, resp);
                } else {
                    resp.sendRedirect("/login");
                }



        }
    }
}

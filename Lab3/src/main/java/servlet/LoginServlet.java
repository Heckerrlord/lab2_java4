package servlet;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import common.CookiesUtils;

@WebServlet("/cookies")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = CookiesUtils.get("username", request);
        String password = CookiesUtils.get("password", request);
        request.getRequestDispatcher("/views/cookies/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        String showPassParam = request.getParameter("showPass");
        boolean showPass = (showPassParam != null) && Boolean.parseBoolean(showPassParam);
        if (showPass) {
            request.setAttribute("password", password);
            request.setAttribute("type", "text");
        } else {
            request.setAttribute("password", "");
            request.setAttribute("type", "password");
        }
        //Nếu tên đăng nhập k bằng poly => thực hiện request.setAttribute
        if (!username.equals("poly")) {
            request.setAttribute("message", "Sai tên đăng nhập");
        } else if (!password.equals("fpt2023")) {
            request.setAttribute("message", "Sai mật khẩu");
        } else {
            request.setAttribute("message", "Đăng nhập thành công");
        }
        int hours = (remember == null) ? 0 : 30 * 24;
        CookiesUtils.add("username", username, hours, response);
        CookiesUtils.add("password", password, hours, response);
        request.setAttribute("username", username);
        request.setAttribute("password", password);

        request.getRequestDispatcher("/views/cookies/login.jsp").forward(request, response);
    }
}

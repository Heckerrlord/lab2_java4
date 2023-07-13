package servlet;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/dang-ky", "/result" })
public class DangKyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/form/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
		boolean married = (req.getParameter("married") != null);
		String country = req.getParameter("country");
		String[] hobbies = req.getParameterValues("hobbies");
		System.out.println(">>hobbies: " + Arrays.toString(hobbies));
//		System.out.println(">>username: " + username);
//		System.out.println(">>gender: " + gender);
//		System.out.println(">>married: " + married);
//		System.out.println(">>country: " + country);
		
		
		req.getRequestDispatcher("/views/form/result.jsp").forward(req, resp);
	}

}

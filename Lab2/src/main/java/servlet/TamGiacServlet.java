package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/tam-giac", "/dien-tich", "/chu-vi" })
public class TamGiacServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/tam-giac.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(req.getParameter("a"));
		double b = Double.parseDouble(req.getParameter("b"));
		double c = Double.parseDouble(req.getParameter("c"));
		// đọc b và c ở đây
		if ((a + b > c) && (a + c > b) && (b + c > a)) {
			double chuVi = (a + b + c);
			String uri = req.getRequestURI();
			if (uri.contains("dien-tich")) { // [Tính diện tích].Click
				double dienTich = Math.sqrt(chuVi * (a + b - c) * (a + c - b) * (b + c - a)) / 4;
				req.setAttribute("message", "Diện tích của tam giác là " + dienTich);
			} else { // [Tính chu vi].Click
				req.setAttribute("message", "Chu vi của tam giác là " + chuVi);
			}
		} else {
			req.setAttribute("message", "Không thỏa mãn các cạnh của một tam giác!");
		}

		req.getRequestDispatcher("/views/tam-giac.jsp").forward(req, resp);
	}

}

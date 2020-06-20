package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.Data;

@WebServlet("/ServletCalculo")
public class ServletCalculo extends HttpServlet {

	Data da = null;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data = request.getParameter("id");
		String[] spl = data.split("/");
		byte dia = Byte.parseByte(spl[0]);
		byte mes = Byte.parseByte(spl[1]);
		short ano = Short.parseShort(spl[2]);

		try {
			da = new Data(data, ano, mes, dia);
			HttpSession session = request.getSession();
			session.setAttribute("idade", da.getIdade());

		}

		catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar calSist = Calendar.getInstance();
		if (ano > calSist.getWeekYear() || da.getData() == -1) {
			RequestDispatcher rd = request.getRequestDispatcher("dataInvalida.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("dataValida.jsp");
			rd.forward(request, response);

		}

	}

}
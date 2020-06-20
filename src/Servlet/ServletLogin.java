package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.LoginSenha;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginSenha login = new LoginSenha("admin", "123");
		HttpSession session = request.getSession();
		session.setAttribute("aut", login);

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		if (login.validarSenha(usuario, senha) == true) {
			RequestDispatcher rd = request.getRequestDispatcher("/restrito");
			rd.forward(request, response);
		} else {

			response.sendRedirect("acessoNegado.html");

		}

	}
}
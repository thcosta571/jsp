package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.LoginSenha;

@WebServlet("/restrito")
public class ServletRestrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession(false) != null) {

			LoginSenha ref = (LoginSenha) request.getSession(false).getAttribute("aut");

			request.setAttribute("usuario", ref.getUsuario());

			RequestDispatcher rd = request.getRequestDispatcher("restrito.jsp");
			rd.forward(request, response);

		} else {

			RequestDispatcher rd = request.getRequestDispatcher("acessoIndevido.jsp");
			rd.forward(request, response);

		}
	}
}

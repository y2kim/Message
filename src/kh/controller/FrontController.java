package kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.branch.dao.MessagesDAO;
import kh.branch.dto.Message;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		boolean isRedirect = true;
		String whereTo = null;

		if(command.equals("/input.do")) {
			whereTo = "input.jsp";
		}else if(command.equals("/output.do")) {
			whereTo = "output.jsp";
		}else if(command.equals("/insert.do")) {
			try {
				String name = request.getParameter("name");
				String message = request.getParameter("message");
				System.out.println(name+" : "+ message);
				MessagesDAO mdao = new MessagesDAO();
				Message msg = new Message();
				msg.setName(name);
				msg.setMessage(message);
				int result = mdao.insertOneMessage(msg);
				request.setAttribute("result", result);
				whereTo = "result.jsp";
			}catch (Exception e) {
				e.printStackTrace();
				whereTo = "error.jsp";
			}
		}else if(command.equals("/other.do")) {
			whereTo = "other.jsp";
		}

		if(isRedirect) {
			response.sendRedirect(whereTo);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(whereTo);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

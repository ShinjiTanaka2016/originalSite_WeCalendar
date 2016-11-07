package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GroupBeans;
import model.WeCalendarDAO;

/**
 * Servlet implementation class AddGroupMenberCheck
 */
@WebServlet("/AddGroupMenberCheck")
public class AddGroupMenberCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String errorMsg = "";
		HttpSession session = request.getSession();

		GroupBeans gb = (GroupBeans)session.getAttribute("groupdata");
		WeCalendarDAO wcDAO = new WeCalendarDAO();
		String id = request.getParameter("groupid");
		String name = request.getParameter("groupname");
		String pass = request.getParameter("grouppass");
		String createUser = request.getParameter("createuser");
		String member = "/" + gb.getCreateUser() + "/";

		String member1 = request.getParameter("member1");
		String member2 = request.getParameter("member2");
		String member3 = request.getParameter("member3");
		String member4 = request.getParameter("member4");
		String member5 = request.getParameter("member5");
		String member6 = request.getParameter("member6");

		if(member1.length() > 0){member += member1 + "/";}
		if(member2.length() > 0){member += member2 + "/";}
		if(member3.length() > 0){member += member3 + "/";}
		if(member4.length() > 0){member += member4 + "/";}
		if(member5.length() > 0){member += member5 + "/";}
		if(member6.length() > 0){member += member6 + "/";}

		wcDAO.addGroupData(id, name, pass, createUser, member);
		gb.setGroupMember(member);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/addGroupCompleteResult.jsp");
		rd.forward(request, response);
	}

}

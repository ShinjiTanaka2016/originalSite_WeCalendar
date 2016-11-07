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
 * Servlet implementation class UpdateGroupMenberCheck
 */
@WebServlet("/UpdateGroupMenberCheck")
public class UpdateGroupMenberCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		WeCalendarDAO wcDAO = new WeCalendarDAO();
		HttpSession session = request.getSession();
		GroupBeans gB = (GroupBeans) session.getAttribute("groupdata");
		String id = gB.getGroupId();
		String errorMsg = "";

		String member1 = request.getParameter("member1") + "/";
		String member2 = request.getParameter("member2") + "/";
		String member3 = request.getParameter("member3") + "/";
		String member4 = request.getParameter("member4") + "/";
		String member5 = request.getParameter("member5") + "/";
		String member6 = request.getParameter("member6") + "/";

		if(wcDAO.getGroupMember(id,"/"+member1)==true && member1.length() > 0){errorMsg += "ID:" + member1 + "<br>";}
		if(wcDAO.getGroupMember(id,"/"+member2)==true && member2.length() > 0){errorMsg += "ID:" + member2 + "<br>";}
		if(wcDAO.getGroupMember(id,"/"+member3)==true && member3.length() > 0){errorMsg += "ID:" + member3 + "<br>";}
		if(wcDAO.getGroupMember(id,"/"+member4)==true && member4.length() > 0){errorMsg += "ID:" + member4 + "<br>";}
		if(wcDAO.getGroupMember(id,"/"+member5)==true && member5.length() > 0){errorMsg += "ID:" + member5 + "<br>";}
		if(wcDAO.getGroupMember(id,"/"+member6)==true && member6.length() > 0){errorMsg += "ID:" + member6 + "<br>";}

		if(errorMsg.length() > 0){
			errorMsg += "上記のIDはすでに登録されています。<br><br>"
					 +  "<a href=\"/WeCalendar/updateGroupMember.jsp\" class=\"btn btn-primary btn-sm\">戻る</a>";
			request.setAttribute("msg",errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		}else{
			if(member1.equals("/")){member1 = "";}
			if(member2.equals("/")){member2 = "";}
			if(member3.equals("/")){member3 = "";}
			if(member4.equals("/")){member4 = "";}
			if(member5.equals("/")){member5 = "";}
			if(member6.equals("/")){member6 = "";}

			String addMember = member1 + member2 + member3 + member4 + member5 + member6;
			wcDAO.updateGroupMember(gB.getGroupId(), addMember);
			gB.setGroupMember(gB.getGroupMember() + addMember);

		}
	}
}

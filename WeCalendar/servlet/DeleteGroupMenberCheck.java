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
 * Servlet implementation class DeleteGroupMenberCheck
 */
@WebServlet("/DeleteGroupMenberCheck")
public class DeleteGroupMenberCheck extends HttpServlet {
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
		String groupId = gB.getGroupId();

		String member1 = request.getParameter("member1");
		String member2 = request.getParameter("member2");
		String member3 = request.getParameter("member3");
		String member4 = request.getParameter("member4");
		String member5 = request.getParameter("member5");
		String member6 = request.getParameter("member6");

		//	エラーチェック
		String all = member1 + member2 + member3 + member4 + member5 + member6;
		String error01 = "";
		if(all.length() == 0){ error01 = "入力がありません。<br>";}
		//	ユーザID有無チェック
		String error02 = "";
		if(wcDAO.getGroupMember(member1,groupId)==false && member1.length() > 0){error02 += "ID:" + member1 + "<br>";}
		if(wcDAO.getGroupMember(member2,groupId)==false && member2.length() > 0){error02 += "ID:" + member2 + "<br>";}
		if(wcDAO.getGroupMember(member3,groupId)==false && member3.length() > 0){error02 += "ID:" + member3 + "<br>";}
		if(wcDAO.getGroupMember(member4,groupId)==false && member4.length() > 0){error02 += "ID:" + member4 + "<br>";}
		if(wcDAO.getGroupMember(member5,groupId)==false && member5.length() > 0){error02 += "ID:" + member5 + "<br>";}
		if(wcDAO.getGroupMember(member6,groupId)==false && member6.length() > 0){error02 += "ID:" + member6 + "<br>";}
		if(error02.length() > 0){
			error02 += "<br>上記のユーザIDはメンバではありません。<br><br>";}

		String errorMsg = error01 + error02;
		if(errorMsg.length() > 0){
			errorMsg += "<br><a href=\"/WeCalendar/deleteGroupMember.jsp\" class=\"btn btn-info\" ><b>戻る</b></a>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);

		}else{	//	エラー無しの場合削除処理
			String Msg = "";
			if(!member1.equals(gB.getAdministrator()) && wcDAO.getGroupMember(member1,groupId)
			   && member1.length() > 0){wcDAO.deleteGroupMember(member1, groupId);Msg += member1 + "<br>";}
			if(!member2.equals(gB.getAdministrator()) && wcDAO.getGroupMember(member2,groupId)
			   && member2.length() > 0){wcDAO.deleteGroupMember(member2, groupId);Msg += member2 + "<br>";}
			if(!member3.equals(gB.getAdministrator()) && wcDAO.getGroupMember(member3,groupId)
			   && member3.length() > 0){wcDAO.deleteGroupMember(member3, groupId);Msg += member2 + "<br>";}
			if(!member4.equals(gB.getAdministrator()) && wcDAO.getGroupMember(member4,groupId)
			   && member4.length() > 0){wcDAO.deleteGroupMember(member4, groupId);Msg += member2 + "<br>";}
			if(!member5.equals(gB.getAdministrator()) && wcDAO.getGroupMember(member5,groupId)
			   && member5.length() > 0){wcDAO.deleteGroupMember(member5, groupId);Msg += member2 + "<br>";}
			if(!member6.equals(gB.getAdministrator()) && wcDAO.getGroupMember(member6,groupId)
			   && member6.length() > 0){wcDAO.deleteGroupMember(member6, groupId);Msg += member2 + "<br>";}

			request.setAttribute("msg", Msg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/deleteGroupMemberCompleteResult.jsp");
			rd.forward(request, response);
		}

	}

}

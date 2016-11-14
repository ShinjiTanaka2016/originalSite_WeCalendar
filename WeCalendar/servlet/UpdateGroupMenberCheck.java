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
		if(wcDAO.getUserId(member1)==false && member1.length() > 0){error02 += "ID:" + member1 + "<br>";}
		if(wcDAO.getUserId(member2)==false && member2.length() > 0){error02 += "ID:" + member2 + "<br>";}
		if(wcDAO.getUserId(member3)==false && member3.length() > 0){error02 += "ID:" + member3 + "<br>";}
		if(wcDAO.getUserId(member4)==false && member4.length() > 0){error02 += "ID:" + member4 + "<br>";}
		if(wcDAO.getUserId(member5)==false && member5.length() > 0){error02 += "ID:" + member5 + "<br>";}
		if(wcDAO.getUserId(member6)==false && member6.length() > 0){error02 += "ID:" + member6 + "<br>";}
		if(error02.length() > 0){
			error02 += "<br>上記のユーザIDは存在しません。<br><br>";}
		//	既存グループメンバチェック
		String error03="";
		if(wcDAO.getGroupMember(member1, groupId) && member1.length() > 0){error03 += "ID:" + member1 + "<br>";}
		if(wcDAO.getGroupMember(member2, groupId) && member1.length() > 0){error03 += "ID:" + member2 + "<br>";}
		if(wcDAO.getGroupMember(member3, groupId) && member1.length() > 0){error03 += "ID:" + member3 + "<br>";}
		if(wcDAO.getGroupMember(member4, groupId) && member1.length() > 0){error03 += "ID:" + member4 + "<br>";}
		if(wcDAO.getGroupMember(member5, groupId) && member1.length() > 0){error03 += "ID:" + member5 + "<br>";}
		if(wcDAO.getGroupMember(member6, groupId) && member1.length() > 0){error03 += "ID:" + member6 + "<br>";}
		if(error03.length() > 0){
			error03 += "<br>上記のユーザIDはすでに登録があります。<br><br>";}

		String errorMsg = error01 + error02 + error03;
		if(errorMsg.length() > 0){
			errorMsg += "<br><a href=\"/WeCalendar/updateGroupMember.jsp\" class=\"btn btn-info\" ><b>戻る</b></a>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);

		}else{	//	エラー無しの場合登録
			String Msg = "";
			if( member1.length() > 0){wcDAO.addGroupMember(member1, groupId);Msg += member1 + "<br>";}
			if( member2.length() > 0){wcDAO.addGroupMember(member2, groupId);Msg += member2 + "<br>";}
			if( member3.length() > 0){wcDAO.addGroupMember(member3, groupId);Msg += member3 + "<br>";}
			if( member4.length() > 0){wcDAO.addGroupMember(member4, groupId);Msg += member4 + "<br>";}
			if( member5.length() > 0){wcDAO.addGroupMember(member5, groupId);Msg += member5 + "<br>";}
			if( member6.length() > 0){wcDAO.addGroupMember(member6, groupId);Msg += member6 + "<br>";}

			request.setAttribute("msg", Msg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/updateGroupMemberCompleteResult.jsp");
			rd.forward(request, response);
		}
	}
}

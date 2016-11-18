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
 * Servlet implementation class DeleteGroupDataCheck
 */
@WebServlet("/DeleteGroupDataCheck")
public class DeleteGroupDataCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		GroupBeans gB = (GroupBeans) session.getAttribute("groupdata");
		String errorMsg = "";

		String groupId = gB.getGroupId();
		String groupPass = gB.getGroupPass();

		String DeletePass = request.getParameter("deletepass");

		//	入力パスワード確認
		if(!DeletePass.equals(groupPass)){
			errorMsg += "パスワードが違います。<br>"
					  + "<a href=\"/WeCalendar/myGroup.jsp\" class=\"btn btn-info\" ><b>戻る</b></a><br>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);

		//	エラー無しの場合グループID,スケジュールを削除
		}else{
			WeCalendarDAO wcDAO = new WeCalendarDAO();
		//	wcDAO.deleteGroupSchedule(groupId);
			wcDAO.deleteGroupData(groupId);
			wcDAO.deleteGroupAllMember(groupId);
			String Msg = "グループID[" + groupId + "]並びにグループスケジュールを削除しました。";

			gB.setGroupId("0");
			gB.setGroupName("0");
			gB.setGroupPass("0");
			gB.setAdministrator("0");
			session.setAttribute("groupdata", gB);

			request.setAttribute("msg",Msg );
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/deleteGroupDataComplete.jsp");
			rd.forward(request, response);
		}
	}
}
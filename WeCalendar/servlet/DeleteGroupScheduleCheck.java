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
import model.LoginUserBeans;
import model.ScheduleBeans;
import model.WeCalendarDAO;

/**
 * Servlet implementation class DeleteGroupScheduleCheck
 */
@WebServlet("/DeleteGroupScheduleCheck")
public class DeleteGroupScheduleCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String errorMsg = "";

		LoginUserBeans lUB = (LoginUserBeans)session.getAttribute("lub");
		String loginUserId = lUB.getUserId();
		GroupBeans gB = (GroupBeans)session.getAttribute("groupdata");
		String groupAdministrator = gB.getAdministrator();

		String id = request.getParameter("planid");
		int planId = Integer.parseInt(id);

		WeCalendarDAO wcDAO = new WeCalendarDAO();
		ScheduleBeans sb = new ScheduleBeans();
		sb = wcDAO.getPlanData(planId);

		//	エラーチェック
		//	IDチェック
		if(sb == null){
			errorMsg = "入力したスケジュールID(" +  planId  + ")は存在しません<br><br>"
					+ "<a href=\"/WeCalendar/deleteGroupSchedule.jsp\" class=\"btn btn-primary btn-sm\">戻る</a>";
			request.setAttribute("msg",errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		}else{
			//	グループスケジュール＆権限チェック
			String createUserId = sb.getCreateUser();
			String createGroupAdministrator = wcDAO.getGroupAdministrator(sb.getCreateGroup());
			if(sb.getCreateGroup()== null){
				errorMsg += "個人スケジュールはグループメニューから変更できません。<br>";
			}else if(!createUserId.equals(loginUserId)){
				if(!loginUserId.equals(createGroupAdministrator)){
					errorMsg += "削除権限がありません。<br>";
				}
			}
			if(errorMsg.length() > 0){
				errorMsg += "<br><a href=\"/WeCalendar/deleteGroupSchedule.jsp\" class=\"btn btn-primary btn-sm\">戻る</a>";
				request.setAttribute("msg",errorMsg);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/error.jsp");
				rd.forward(request, response);


			}else{	//	エラーでない場合、確認画面へ
				session.setAttribute("plandata",sb);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deleteGroupSchdulecheckResult.jsp");
				rd.forward(request, response);
			}
		}
	}

}

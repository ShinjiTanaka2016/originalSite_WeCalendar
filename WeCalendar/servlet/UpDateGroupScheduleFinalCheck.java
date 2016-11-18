package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ScheduleBeans;
import model.ScheduleDAO;

/**
 * Servlet implementation class UpDateGroupScheduleFinalCheck
 */
@WebServlet("/UpDateGroupScheduleFinalCheck")
public class UpDateGroupScheduleFinalCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorMsg = "";

		HttpSession session = request.getSession();
		ScheduleBeans sb = (ScheduleBeans) session.getAttribute("plandata");

		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endtime");

		//	エラーチェック
		if(sb.getDate().length()==0){errorMsg = "日付が入力されていません<br>";}
		if(sb.getTitle().length()==0){errorMsg = "タイトルが入力されていません<br>";}
		if(startTime.length()==0 && endTime.length()>0){
			errorMsg += "終了時間のみの入力はできません。<br>";
		}else if(endTime.length() > 0 && startTime.compareTo(endTime)>=0){
			errorMsg += "開始時間と終了時間の設定が異常です<br>";
		}
		if(errorMsg.length()>0){
			errorMsg += "<br><a href=\"/WeCalendar/updateGroupSchedule.jsp\" class=\"btn btn-primary btn-sm\">戻る</a><br>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/schduleError.jsp");
			rd.forward(request, response);


		}else{	//	エラー無しの場合、スケジュール更新処理
			String planId = request.getParameter("id");
			int id = Integer.parseInt(planId);
			String date = request.getParameter("date");
			String attribute = request.getParameter("attribute");
			String place = request.getParameter("place");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String authority = request.getParameter("authority");
			String createGroup = request.getParameter("creategroup");
			String createUser = request.getParameter("createuser");

			ScheduleDAO sDAO = new ScheduleDAO();
			sDAO.updateScedule(id, date, startTime, endTime, attribute, place, title, content,
								authority, createGroup, createUser);
			sb = sDAO.getPlanData(id);
			session.setAttribute("plandata",sb);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/updateGroupScheduleCompleteResult.jsp");
			rd.forward(request, response);
		}
	}
}
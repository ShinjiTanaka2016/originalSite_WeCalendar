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
import model.WeCalendarDAO;

/**
 * Servlet implementation class AddGroupIDCheck
 */
@WebServlet("/AddGroupIDCheck")
public class AddGroupIDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String errorMsg = "";
		WeCalendarDAO wcDAO = new WeCalendarDAO();
		HttpSession session = request.getSession();
		LoginUserBeans lUB = (LoginUserBeans) session.getAttribute("lub");
		String groupAdministrator = lUB.getUserId();

		String id = request.getParameter("groupid");
		String name = request.getParameter("groupname");
		String pass = request.getParameter("grouppass01");
		String groupPass02 = request.getParameter("grouppass02");

		if(wcDAO.getGroupId(id) == true){
			errorMsg += "そのIDはすでに使われています。<br>";
		}
		if(name.length()==0){
			errorMsg += "グループ名の入力がありません。<br>";
		}
		if(pass.length()==0){
			errorMsg += "パスワードの入力がありません。<br>";
		}
		if(!pass.equals(groupPass02)){
			errorMsg += "パスワードの確認がとれません。<br>";
		}

		if(errorMsg.length() > 0){
			errorMsg += "<br><br><a href=\"/WeCalendar/addGroup.jsp\" "
					  + "class=\"btn btn-primary btn-sm\">戻る</a>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		}else{
			GroupBeans gb = new GroupBeans(id,name,pass,groupAdministrator);
			request.setAttribute("gb", gb);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/addGroupMember.jsp");
			rd.forward(request, response);
		}
	}
}
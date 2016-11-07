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
 * Servlet implementation class UpdateGroupDataCheck
 */
@WebServlet("/UpdateGroupDataCheck")
public class UpdateGroupDataCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		LoginUserBeans lUB = (LoginUserBeans)session.getAttribute("lub");
		GroupBeans gB = (GroupBeans)session.getAttribute("groupdata");
		String errorMsg = "";

		String loginUser = lUB.getUserId();
		String createUser = gB.getCreateUser();
		String id = gB.getGroupId();
		String groupPass = gB.getGroupPass();
		String inputPass = request.getParameter("grouppass");

		//	各項目入力無しの場合、現パラメータを代入
		String newId = request.getParameter("newid");
		if(newId.length() == 0){newId = gB.getGroupId();}
		String newName = request.getParameter("newname");
		if(newName.length() == 0){newName = gB.getGroupName();}
		String newPass = request.getParameter("newgrouppass01");
		if(newPass.length() == 0){newPass = gB.getGroupPass();}
		String newPass02 = request.getParameter("newgrouppass02");
		if(newPass02.length() == 0){newPass02 = gB.getGroupPass();}

		//	エラー確認
		if(!loginUser.equals(createUser)){errorMsg += "変更する権限がありません。<br>";}
		if(!groupPass.equals(inputPass)){errorMsg += "パスワードが違います。<br>";}
		if(!newPass.equals(newPass02)){errorMsg += "パスワードの確認がとれません。<br>";}
		if(errorMsg.length() > 0){
			errorMsg += "<a href=\"/WeCalendar/updateGroupData.jsp\" class=\"btn btn-primary btn-sm\">戻る</a>";
			request.setAttribute("msg",errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);

		//	エラー無しの場合更新
		}else{
			WeCalendarDAO wcDAO = new WeCalendarDAO();
			wcDAO.updateGroupData(id, newId, newName, newPass);

			//	現グループ情報にセッションを更新
			gB.setGroupId(newId);
			gB.setGroupName(newName);
			gB.setGroupPass(newPass);
			session.setAttribute("groupdata", gB);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/updateGroupDataCompleteResult.jsp");
			rd.forward(request, response);
		}
	}
}

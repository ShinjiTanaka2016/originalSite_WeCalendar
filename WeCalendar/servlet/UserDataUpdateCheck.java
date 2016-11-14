package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginUserBeans;
import model.WeCalendarDAO;
import model.addUserBeans;

/**
 * Servlet implementation class UserDataUpdateCheck
 */
@WebServlet("/UserDataUpdateCheck")
public class UserDataUpdateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		LoginUserBeans lUB = (LoginUserBeans) session.getAttribute("lub");
		WeCalendarDAO wcDAO = new WeCalendarDAO();

		String userPass = lUB.getUserPass();
		String inputUserPass = request.getParameter("userpass");
		String errorMsg = "";

		String inputUserId = request.getParameter("newuserid");
		String inputUserName = request.getParameter("newusername");
		String inputUserMail = request.getParameter("newusermail");
		String inputUserPass01 = request.getParameter("newuserpass01");
		String inputUserPass02 = request.getParameter("newuserpass02");

		//	入力無しの場合、元データを代入
		if(inputUserId.length() == 0 ){inputUserId = lUB.getUserId();}
		if(inputUserName.length() == 0 ){inputUserName = lUB.getUserName();}
		if(inputUserMail.length() == 0 ){inputUserMail = lUB.getUserMail();}
		if(inputUserPass01.length() == 0 && inputUserPass02.length() == 0){
			inputUserPass01 = lUB.getUserPass();
			inputUserPass02 = lUB.getUserPass();
		}

		//	エラーチェック
		//	パスワードチェック
		if(!userPass.equals(inputUserPass)){errorMsg += "パスワードが違います。<br>";}
		//	idチェック
		if(!inputUserId.equals(lUB.getUserId()) && wcDAO.getUserId(inputUserId))
			{errorMsg += "入力したIDはすでに使われています。<br>";}
		if(!inputUserMail.equals(lUB.getUserMail()) && wcDAO.getUserMail(inputUserMail))
			{errorMsg += "入力したメールはすでに使われています。<br>";}
		//	入力チェック
		if(inputUserId.length() < 8 || 12 < inputUserId.length())
			{errorMsg += "<b>ユーザIDが指定の範囲外です(8～12,半角英数)</b><br>";}
		if(inputUserPass01.length() < 8 || 12 < inputUserPass01.length())
			{errorMsg += "<b>ユーザパスが指定の範囲外です(8～12文字,半角英数)</b><br>";}
		if(!inputUserPass01.equals(inputUserPass02))
			{errorMsg += "パスワードの確認がとれません";}

		if(errorMsg.length()>0){
			errorMsg += "<a href=\"/WeCalendar/userDataUpdate.jsp\" class=\"btn btn-primary btn-sm\">戻る</a>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);


		}else{	//	エラー無しの場合、更新処理
			addUserBeans aUB = new addUserBeans();
			aUB.setUserId(inputUserId);
			aUB.setUserName(inputUserName);
			aUB.setUserMail(inputUserMail);
			aUB.setUserPass(inputUserPass01);
			request.setAttribute("aub", aUB);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/updateUserDataFinalCheck.jsp");
			rd.forward(request, response);
		}
	}
}

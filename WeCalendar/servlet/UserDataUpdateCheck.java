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

		String userPass = lUB.getUserPass();
		String inputUserPass = request.getParameter("userpass");

		String errorMsg = "";

		//	パスワードチェック
		if(!userPass.equals(inputUserPass)){
			errorMsg += "パスワードが違います。";
			request.setAttribute("errormsg", errorMsg);
			RequestDispatcher rd =
					request.getRequestDispatcher("/WEB-INF/jsp/userDataUpdateError.jsp");
			rd.forward(request, response);
		}

		String inputUserId = request.getParameter("userid");
		String inputUserName = request.getParameter("username");
		String inputUserMail = request.getParameter("usermail");
		String inputUserPass01 = request.getParameter("newuserpass01");
		String inputUserPass02 = request.getParameter("newuserpass02");

		if(inputUserId.length() == 0 ){
			inputUserId = lUB.getUserId();
		}
		if(inputUserName.length() == 0 ){
			inputUserName = lUB.getUserName();
		}
		if(inputUserMail.length() == 0 ){
			inputUserMail = lUB.getUserMail();
		}
		if(inputUserPass01.length() == 0 && inputUserPass02.length() == 0){
			inputUserPass01 = lUB.getUserPass();
			inputUserPass02 = lUB.getUserPass();
		}

		//	入力エラーチェック
		if(inputUserId.length() < 8 || 12 < inputUserId.length()){
			errorMsg += "<b>ユーザIDが指定の範囲外です(8～12,半角英数)</b><br>";
		}
		if(inputUserPass01.length() < 8 || 12 < inputUserPass01.length()){
			errorMsg += "<b>ユーザパスが指定の範囲外です(8～12文字,半角英数)</b><br>";
		}
		if(!inputUserPass01.equals(inputUserPass02)){
			errorMsg += "パスワードの確認がとれません";
		}


		if(errorMsg.length() > 0){
			request.setAttribute("errormsg", errorMsg);
			RequestDispatcher rd =
					request.getRequestDispatcher("/WEB-INF/jsp/userDataUpdateError.jsp");
			rd.forward(request, response);
		}else{
			addUserBeans aUB = new addUserBeans();
			aUB.setUserId(inputUserId);
			aUB.setUserName(inputUserName);
			aUB.setUserMail(inputUserMail);
			aUB.setUserPass(inputUserPass01);
			request.setAttribute("aub", aUB);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/updateFinalCheck.jsp");
			rd.forward(request, response);
		}
	}
}

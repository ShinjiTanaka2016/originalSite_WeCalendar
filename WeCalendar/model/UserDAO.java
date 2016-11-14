package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	Connection con;
	static final String DATABASE_URL = "jdbc:mysql://localhost/wecalendar";
	static final String DATABASE_USER = "root";
	static final String DATABASE_PASWORD = "utsystem2016";

	public UserDAO(){
		connect();
	}

	//	データベース接続///////////////////////////////////////////////////
	protected boolean connect(){
		String msg = "";
		try{
			if(con != null){
				if(con.getWarnings() == null){
					return true;
				}
				disconnect();
			}
			try{
				Class.forName("com.mysql.jdbc.Driver");
				msg = "ドライバのロードに成功しました";
			}catch(ClassNotFoundException e){
				msg = "ドライバのロードに失敗しました";
			}

			con = DriverManager.getConnection(DATABASE_URL,DATABASE_USER,DATABASE_PASWORD);
			if(con.getWarnings() == null){
				return true;
			}
			disconnect();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	protected void disconnect(){
		if(con != null){
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			con = null;
		}
	}

	//	ユーザＩＤチェック/////////////////////////////////////////////////
	public boolean getUserId(String sUID){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM userdata WHERE user_id = ?");
			statement.setString(1, sUID);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				rs.close();
				statement.close();
				return true;
			}else{
				rs.close();
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("ユーザＩＤチェックエラー");
		}
		return false;
	}

	//	ユーザメールチェック///////////////////////////////////////////////
	public boolean getUserMail(String sUMail){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM userdata WHERE user_mail = ?");
			statement.setString(1, sUMail);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				rs.close();
				statement.close();
				return true;
			}else{
				rs.close();
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("ユーザメールチェックエラー");
		}
		return false;
	}


	//	ユーザ登録/////////////////////////////////////////////////////////
	public void setUserData(String userId,String userName,
							String userMail,String userPass){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("INSERT INTO userdata VALUES(?,?,?,?)");
			statement.setString(1, userId);
			statement.setString(2, userName);
			statement.setString(3, userMail);
			statement.setString(4, userPass);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("ユーザ登録エラー");
		}
	}

	//	ユーザログインチェック/////////////////////////////////////////////
	public boolean loginUserCheck(String userId,String userPass){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM userdata WHERE user_id=? AND user_pass=? ");
			statement.setString(1, userId);
			statement.setString(2, userPass);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				rs.close();
				statement.close();
				return true;
			}else{
				rs.close();
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("ログインエラー");
		}
		return false;
	}


	//	ログインユーザ情報取り出し/////////////////////////////////////
	public String getLoginUserId(String id){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT user_id FROM userdata WHERE user_id = ? ");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				id = rs.getString("user_id");
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("id取得エラー");
		}
		return id;
	}
	public String getLoginUserName(String id){
		String name = "";
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT user_name FROM userdata WHERE user_id = ?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				name = rs.getString("user_name");
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("name取得エラー");
		}
		return name;
	}
	public String getLoginUserMail(String id){
		String mail = "";
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT user_mail FROM userdata WHERE user_id = ?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				mail = rs.getString("user_mail");
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("mail取得エラー");
		}
		return mail;
	}
	public String getLoginUserPass(String id){
		String pass = "";
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT user_pass FROM userdata WHERE user_id = ?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				pass = rs.getString("user_pass");
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("pass取得エラー");
		}
		return pass;
	}


	//	ユーザ情報更新/////////////////////////////////////////////////////
	public void updateUserData(String newUserId,String newUserName,
			String newUserMail,String newUserPass,String nowUserId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("UPDATE userdata SET user_id=?,user_name=?,"
							+ "user_mail=?,user_pass=? WHERE user_id=?");
			statement.setString(1, newUserId);
			statement.setString(2, newUserName);
			statement.setString(3, newUserMail);
			statement.setString(4, newUserPass);
			statement.setString(5, nowUserId);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("更新エラー");
		}
	}

	//	ユーザ情報削除/////////////////////////////////////////////////////
	public void deleteUserData(String userId){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM userdata WHERE user_id=?");
			statement.setString(1, userId);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("削除エラー");
		}
	}
}

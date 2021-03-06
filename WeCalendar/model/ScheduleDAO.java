package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScheduleDAO {
	Connection con;
	static final String DATABASE_URL = "jdbc:mysql://localhost/wecalendar";	//160.16.204.110//localhost
	static final String DATABASE_USER = "root";
	static final String DATABASE_PASWORD = "utsystem2016";	//utsystem2016

	public ScheduleDAO(){
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

	//	スケジュール確認///////////////////////////////////////////////////
	public boolean getPlan(String today){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM plandata WHERE plan_day = ?");
			statement.setString(1, today);
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
			System.out.println("スケジュール確認エラー");
			e.printStackTrace();
		}
		return false;
	}


	//	スケジュール登録///////////////////////////////////////////////////
	public void setScedule(	String date,String startTime,String endTime,String attribute,
			String place,String title,String content,String authority,
			String createGroup,String createUser){

		String s = "";
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
			("INSERT INTO plandata(plan_day,start_time,end_time,plan_attribute,plan_place,"
					+ "plan_title,plan_content,view_authority,create_group_id,create_user_id)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, date);
			statement.setString(2, startTime);
			statement.setString(3, endTime);
			statement.setString(4, attribute);
			statement.setString(5, place);
			statement.setString(6, title);
			statement.setString(7, content);
			statement.setString(8, authority);
			statement.setString(9, createGroup);
			statement.setString(10, createUser);

			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("スケジュール登録エラー");
		}
	}

	//	スケジュール更新///////////////////////////////////////////////////
	public void updateScedule(int id,String date,String startTime,String endTime,String attribute,String place,
			String title,String content,String authority,String createGroup,String createUser){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
				("UPDATE plandata SET plan_day=?,start_time=?,end_time=?,plan_attribute=?,"
						+ "plan_place=?,plan_title=?,plan_content=?,view_authority=?,"
						+ "create_group_id=?,create_user_id=? WHERE plan_id=?");
			statement.setString(1, date);
			statement.setString(2, startTime);
			statement.setString(3, endTime);
			statement.setString(4, attribute);
			statement.setString(5, place);
			statement.setString(6, title);
			statement.setString(7, content);
			statement.setString(8, authority);
			statement.setString(9, createGroup);
			statement.setString(10, createUser);
			statement.setInt(11, id);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("スケジュール更新エラー");
		}
	}

	//	スケジュール削除///////////////////////////////////////////////////
	public void deleteSchedule(int id){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM plandata WHERE plan_id=?");
			statement.setInt(1, id);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("スケジュール削除エラー");
			e.printStackTrace();
		}
	}

	//	スケジュール情報取得///////////////////////////////////////////////
	public ScheduleBeans getPlanData(int id){
		connect();
		ScheduleBeans sb = new ScheduleBeans();
		try {
			PreparedStatement statement = con.prepareStatement
					("SELECT * FROM plandata WHERE plan_id=? ");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				sb.setPlanId(rs.getInt("plan_id"));
				sb.setDate(rs.getString("plan_day"));
				sb.setStartTime(rs.getString("start_time"));
				sb.setEndTime(rs.getString("end_time"));
				sb.setAttribute(rs.getString("plan_attribute"));
				sb.setPlace(rs.getString("plan_place"));
				sb.setTitle(rs.getString("plan_title"));
				sb.setContent(rs.getString("plan_content"));
				sb.setAuthority(rs.getString("view_authority"));
				sb.setCreateGroup(rs.getString("create_group_id"));
				sb.setCreateUser(rs.getString("create_user_id"));
			}else{
				return null;
			}
			rs.close();
			statement.close();
			return sb;
		} catch (SQLException e) {
			System.out.println("schedule取得エラー");
			e.printStackTrace();
		}
		return null;
	}

	//	全スケジュール一覧取得/////////////////////////////////////////////////
	public ScheduleBeans[] getSchedules() {
		ScheduleBeans[] scheduleArray = null;
		try{
			connect();

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery
					("SELECT * FROM plandata ORDER BY plan_day");
			scheduleArray = createSchedules(rs);

			statement.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return scheduleArray;
	}

	//	日付指定スケジュール一覧取得(個人)/////////////////////////////////////////////////
	public ScheduleBeans[] getTodaySchedules(String today,String userId) {
		ScheduleBeans[] scheduleArray = null;
		try{
			connect();

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery
					("SELECT * FROM plandata WHERE plan_day='"+today+"'"
					+" AND create_user_id='" + userId + "' AND view_authority='個人' ORDER BY start_time");
			scheduleArray = createSchedules(rs);
			rs.close();
			statement.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return scheduleArray;
	}

	//	日付指定スケジュール一覧取得(グループ)/////////////////////////////////////////////////
	public ScheduleBeans[] getTodaySchedulesGroup(String today,String groupId) {
		ScheduleBeans[] scheduleArray = null;
		try{
			connect();

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery
					("SELECT * FROM plandata WHERE plan_day='"+today+"'"
					+" AND create_group_id='" + groupId + "' AND view_authority='グループ' ORDER BY start_time");
			scheduleArray = createSchedules(rs);
			rs.close();
			statement.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return scheduleArray;
	}

	//	ユーザスケジュール一覧取得/////////////////////////////////////////////////
	public ScheduleBeans[] getUserSchedules(String userid) {
		ScheduleBeans[] scheduleArray = null;
		try{
			connect();

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery
					("SELECT * FROM plandata WHERE create_user_id='" + userid
							+ "' AND view_authority='個人' ORDER BY plan_day");
			scheduleArray = createSchedules(rs);

			statement.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return scheduleArray;
	}


	//	グループスケジュール一覧取得/////////////////////////////////////////////////
	public ScheduleBeans[] getGroupSchedules(String groupId) {
		ScheduleBeans[] scheduleArray = null;
		try{
			connect();

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery
					("SELECT * FROM plandata WHERE create_group_id='" + groupId
							+ "' AND view_authority='グループ' ORDER BY plan_day");
			scheduleArray = createSchedules(rs);

			statement.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return scheduleArray;
	}

	//	スケジュール配列/////////////////////////////////////////////////////////
	protected ScheduleBeans[] createSchedules(ResultSet rs) throws SQLException{
		ArrayList<ScheduleBeans> schedules = new ArrayList<ScheduleBeans>();

		while(rs.next()){
			schedules.add(createScheduleBeans(rs));
		}
		ScheduleBeans[] ScheduleArray = new ScheduleBeans[schedules.size()];
		schedules.toArray(ScheduleArray);
		return ScheduleArray;
	}

	//	スケジュール情報///////////////////////////////////////////
	protected ScheduleBeans createScheduleBeans(ResultSet rs) throws SQLException{
		ScheduleBeans sb = new ScheduleBeans();

		sb.setPlanId(rs.getInt("plan_id"));
		sb.setDate(rs.getString("plan_day"));
		sb.setStartTime(rs.getString("start_time"));
		sb.setEndTime(rs.getString("end_time"));
		sb.setAttribute(rs.getString("plan_attribute"));
		sb.setPlace(rs.getString("plan_place"));
		sb.setTitle(rs.getString("plan_title"));
		sb.setContent(rs.getString("plan_content"));
		sb.setAuthority(rs.getString("view_authority"));
		sb.setCreateGroup(rs.getString("create_group_id"));
		sb.setCreateUser(rs.getString("create_user_id"));

		return sb;
	}

	//	ユーザスケジュール一括削除///////////////////////////////////////////////////
	public void deleteUserSchedule(String userid){
		connect();
		try {
			PreparedStatement statement = con.prepareStatement
					("DELETE FROM plandata WHERE create_user_id=? AND view_authority='個人'");
			statement.setString(1, userid);
			int r = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("スケジュール削除エラー");
		}
	}
}
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarDisplayJava {

	public String getCalendar(String userId,String groupId){

		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);

		// 本日の取得
		int yyyy = c.get(Calendar.YEAR);
		int mm = c.get(Calendar.MONTH) + 1;
		int dd = c.get(Calendar.DAY_OF_MONTH);

		String today = yyyy + "/" + mm + "/" + dd;

		// 先月末の日付を求める
		c.set(yyyy, mm-2, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		int zedd = c.get(Calendar.DATE);

		// 先月末の曜日を求める
		c.set(yyyy, mm-2, zedd);
		int zedy = c.get(Calendar.DAY_OF_WEEK);	// 日曜日から1.2.3....土曜日が7

		// 当月末の日付を求める
		c.set(yyyy, mm-1, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		int tedd = c.get(Calendar.DATE);

		// 当月末の曜日を求める
		c.set(yyyy, mm-1, tedd);
		int tedy = c.get(Calendar.DAY_OF_WEEK);	// 日曜日から1.2.3....土曜日が7

		ArrayList<Integer> daysArray = new ArrayList<Integer>();
		for(int i = 0;i < zedy;i++){
			daysArray.add(0);
		}
		for(int i = 1;i <= tedd;i++){
			daysArray.add(i);
		}
		for(int i = 1;i <= 7 - tedy;i++){
			daysArray.add(0);
		}

		int row = daysArray.size()/7;
		String[] youbi = {"日","月","火","水","木","金","土"};

		//	描画処理
		String html = "";
		html += "<table class='calendar'>";
		html += "<caption>";
		// 今月へ戻るリンク
		html += "　<a class='btn btn-success' href='./Calendar.jsp'>今月へ戻る</a>";
		// 前月へ移動リンク
		html += "　<a class='btn btn-info' href='#' "
				 + ">前月</a>　";
		// 年月日表示;
		html += "　<b Style='font-size:26px;color:black;'>" + yyyy + "年" + mm + "月</b>";
		// 翌月へ移動リンク
		html += "　<a class='btn btn-info' href='#'"
				 + ">次月</a>";
		html += "</caption>";
		html += "<tr>";
		for(int i = 0; i < 7; i++){
			if(youbi[i].equals("日")){
				html += "<th style='background:pink;'><div style='color:red;'>"
						+ youbi[i] + "</div></th>";
			}else if(youbi[i].equals("土")){
				html += "<th style='background:skyblue;'><div style='color:blue;'>"
						+ youbi[i] + "</div></th>";
			}else{
				html += "<th style='background:#d6fcd9;'><div style='color:black;'>"
						+ youbi[i] + "</div></th>";
			}
		}

		// 日付部分描画
		String f = "<form action='/WeCalendar/ScheduleOfTodayCheck' method='post'>";
		ScheduleDAO sDAO = new ScheduleDAO();

		for(int i = 0;i < row;i++){
			html += "<tr>";
			for( int j = 7*i ; j < 7*(i+1) ; j++ ){
				String selectDate = yyyy + "/" + mm + "/" + (j-1);

				// 日付外部分は空白で表示
				if(daysArray.get(j).equals(0)){
					html += "<td></td>";

				}else{ // 日付部分に各色のボタンを設置
					html += "<td>" + f + "<input type='hidden' name='date' value='" + selectDate + "'>";
					if(sDAO.getUserPlan(selectDate, userId)==true){
						html += "<button class='btn btn_userplanday' type='submit' value='send'>" + daysArray.get(j);
						html += "</button>";
					}else if(sDAO.getGroupPlan(selectDate, groupId)==true){
						html += "<button class='btn btn_groupplanday' type='submit' value='send'>" + daysArray.get(j);
						html += "</button>";
					}else if(j%7 == 0){
						html += "<button class='btn btn_sunday' type='submit' value='send'>" + daysArray.get(j);
						html += "</button>";
					}else if(j%7 == 6){
						html += "<button class='btn btn_saturday' type='submit' value='send'>" + daysArray.get(j);
						html += "</button>";
					}else{
						html += "<button class='btn btn_day' type='submit' value='send'>" + daysArray.get(j);
						html += "</button>";
					}

					html += "</form></td>";
				}
			}
			html += "</tr>";
		}
		html += "</table>";
		return html;
	}
}

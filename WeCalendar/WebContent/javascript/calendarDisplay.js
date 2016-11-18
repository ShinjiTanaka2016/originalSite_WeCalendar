window.onload = function() {
  setCalendar();
};

// カレンダー生成
function setCalendar(yyyy, mm) {
	var yyyy, mm, dd;
	// yyyy,mmが未定義なら、現在の年月日を変数yyyy,mm,ddに代入する
	if (!yyyy && !mm && !dd) {
		var yyyy = new Date().getFullYear();
		var mm = new Date().getMonth();
		var dd = new Date().getDate();
		mm = mm -(-1); // mmプラス1で該当月となる
	}
	var toYear = yyyy;
	var toMonth = mm;
	var toDate = dd;

	var zdate = new Date(yyyy,mm-1,0); // 前月末
	var tdate = new Date(yyyy,mm,0); // 当月末
	zedd = zdate.getDate(); // 前月末日
	zedy = zdate.getDay(); // 前月末曜日
	tedd = tdate.getDate(); // 当月末日
	tedy = tdate.getDay(); // 当月末曜日

	// カレンダーに埋める数字を配列daysに格納（5行なら35要素、6行なら42要素）
	var days = [];

	// 前月末が土曜日以外（日曜日から0,1,2・・・土曜日が6）
	if (zedy != 6) {
	// 前月最終日曜日から月末曜日までの日付
	for (var i=zedy; i>=0; i--) {
    	days[zedy-i] = (zedd - i);
	}
	// 当月日付
	for (var i=1; i<=tedd; i++) {
    	days[zedy+i] = i;
	}
		// 当月末が35番目までに終了
		if ((zedy + tedd) <= 34) {
			// 翌月日付
			for (var i=1; i<35-zedy-tedd; i++) {
				days[zedy+tedd+i] = i;
			}
		// 当月末が35番目を超えて終了
		} else if((zedy + tedd) > 34) {
	    	// 翌月日付
	    	for (var i=1; i<42-zedy-tedd; i++) {
	      		days[zedy+tedd+i] = i;
	    	}
		}

	// 前月末が土曜日
	} else if(zedy == 6) {
		// 当月日付
		for (var i=1; i<=tedd; i++) {
	    	days[i-1] = i;
		}
		// 翌月日付
		for (var i=0; i<35-tedd; i++) {
	    	days[tedd+i] = i + 1;
		}
	}

	// DOM生成（描画）
	var out = "<table class=\"calendar\">";

	out += "<caption>";
	// 今月へ戻るリンク
	out += "<a class=\"btn btn-success\" href='#' onclick='setCalendar();return false;'>今月へ戻る</a>　　";
	// 前月へ移動リンク
	out += "<a class=\"btn btn-success\" href='#' yyyy='"+yyyy+"' mm='"+mm+"'"
		 + " onclick='backmm(this);return false;'>前月</a>　";
	// 年月日表示
	out += '<b Style=\"font-size:26px;color:black;\">'+yyyy+'年'+mm+'月</b>';
	// 翌月へ移動リンク
	out += "　<a class=\"btn btn-success\" href='#' yyyy='"+yyyy+"' mm='"+mm+"'"
		 + "onclick='nextmm(this);return false;'>次月</a>";

	out += "</caption>";

	var youbi = ["日", "月", "火", "水", "木", "金", "土"];
	out += "<tr>";
	for (var i in youbi) {
		if(youbi[i]=="日"){
  			out += "<th style=\"background:pink;\"><div style=\"color:red;\">" + youbi[i] + "</div></th>";
		}else if(youbi[i]=="土"){
  			out += "<th style=\"background:skyblue;\"><div style=\"color:blue;\">" + youbi[i] + "</div></th>";
		}else{out += "<th style=\"background:#d6fcd9;\"><div style=\"color:black;\">" + youbi[i] + "</th>";}
	}
	out += "</tr>";

	// 配列daysの中身を展開
	// 行数を計算する
	var row = days.length/7;
	// 行数分だけ回す
		var f = "<form action=\"/WeCalendar/ScheduleOfTodayCheck\" method=\"post\">";
		var n = 1;
		for (var i=1; i<=row; i++) {
    		out += "<tr>";
			for (var j=7*i-6; j<=7*i; j++) {
				var toDay = yyyy + "/" + mm + "/" + days[j-1];
				if(n==1 && days[j-1]>7){
					out += "<td></td>";
				}else if((n==5 || n==6) && days[j-1]<8){
					out += "<td></td>";
				}else{
					out += "<td>" + f + "<input type=\"hidden\" name=\"date\" value=\"" + toDay + "\">";
					//	曜日ごと色分け(土＝青・日＝赤・他＝緑)
					if((j%7)==0 && yyyy==toYear && mm==toMonth && days[j-1]==toDate){
						out += "<button class=\"btn_tosaturday\" type=\"submit\" value=\"send\">"+ days[j-1];
					}else if((j%7)==0){
						out += "<button class=\"btn_saturday\" type=\"submit\" value=\"send\">"+ days[j-1];
					}else if((j%7)==1 && yyyy==toYear && mm==toMonth && days[j-1]==toDate){
						out += "<button class=\"btn_tosunday\" type=\"submit\" value=\"send\">"+ days[j-1];
					}else if((j%7)==1){
						out += "<button class=\"btn_sunday\" type=\"submit\" value=\"send\">"+ days[j-1];
					}else if(yyyy==toYear && mm==toMonth && days[j-1]==toDate){
						out += "<button class=\"btn_today\" type=\"submit\" value=\"send\">"+ days[j-1];
					}else{
						out += "<button class=\"btn_day\" type=\"submit\" value=\"send\">"+ days[j-1];
					}
					out += "</form></td>";
				}
			}
			out += "</tr>";
			n++;
		}
	out += "</table>";

	// 最後にhtmlに渡す
	document.getElementById("result").innerHTML = out;
}


// 前月へ移動
function backmm(e) {
	var yyyy = e.getAttribute('yyyy');
	var mm = e.getAttribute('mm');
	if (mm != 1) {
  		mm = mm-1;
	} else if (mm == 1) {
  		mm = 12;
  		yyyy = yyyy - 1;
	}
	setCalendar(yyyy, mm);
}

// 翌月へ移動
function nextmm(e) {
	var yyyy = e.getAttribute('yyyy');
	var mm = e.getAttribute('mm');
	if (mm != 12) {
		mm = parseInt(mm) + 1;
	} else if (mm == 12) {
		mm = 1;
		yyyy = parseInt(yyyy) + 1;
	}
	setCalendar(yyyy, mm);
}
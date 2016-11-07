CREATE DATABASE wecalendar;

CREATE TABLE userdata(
	user_id VARCHAR(12) NOT NULL,
	user_name VARCHAR(255) NOT NULL,
	user_mail VARCHAR(255) NOT NULL,
	user_pass VARCHAR(12) NOT NULL,
    PRIMARY KEY(user_id,user_mail)
);


CREATE TABLE groupdata(
	group_id VARCHAR(12) NOT NULL,
	group_name VARCHAR(255) NOT NULL,
	group_pass VARCHAR(12) NOT NULL,
	group_membar TEXT NOT NULL,
	group_create_user_id VARCHAR(12) NOT NULL,
    PRIMARY KEY(group_id)
);


CREATE TABLE plandata(
	plan_id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	plan_day DATE NOT NULL,
	plan_time TIME,
	plan_attribute ENUM('仕事','イベント','プライベート','その他') NOT NULL DEFAULT 'その他',
	plan_place VARCHAR(255),
	plan_title VARCHAR(255) NOT NULL DEFAULT '予定',
	plan_content TEXT,
	view_authority ENUM('全員','グループ','個人') NOT NULL DEFAULT '個人',
	create_group_id VARCHAR(12),
	create_user_id VARCHAR(12) NOT NULL,
	create_date TIMESTAMP NOT NULL
);
INSERT INTO userdata VALUES('a','a','a','a');
INSERT INTO userdata VALUES('user_id','user_name','user_mail','user_pass');
INSERT INTO groupdata VALUES('group_id','group_name','group_pass','group_membar','group_create_user_id');
INSERT INTO plandata VALUES('plan_day','plan_time','plan_attribute','plan_place','plan_title','plan_content','view_authority','create_group_id','create_user_id');


INSERT INTO plandata(plan_day,plan_time,plan_attribute,plan_place,plan_title,plan_content,view_authority,create_group_id,create_user_id)
 VALUES('1111-11-11','00:00:00','その他','plan_place','plan_title','plan_content','個人','create_group','create_user');

SELECT plan_day,plan_time,plan_title,create_user_id FROM wecalendar.plandata;

INSERT INTO テーブル名 VALUES('カラム①の値','カラム②の値');			/* 追加 */
DELETE FROM テーブル名 WHERE カラム名=値;								/* 削除 */
UPDATE テーブル名 SET カラム名①=値,カラム名②=値 WHERE カラム名=値;	/* 更新 */


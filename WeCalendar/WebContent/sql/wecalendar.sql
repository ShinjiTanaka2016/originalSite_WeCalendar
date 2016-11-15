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


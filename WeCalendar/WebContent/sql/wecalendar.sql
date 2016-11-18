CREATE DATABASE wecalendar character set UTF8;

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
	group_administrator VARCHAR(12) NOT NULL,
    PRIMARY KEY(group_id)
);

CREATE TABLE affiliationgroup(
	user_id VARCHAR(12) NOT NULL,
	group_id VARCHAR(12) NOT NULL
);


CREATE TABLE plandata(
	plan_id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	plan_day DATE NOT NULL,
	start_time TIME,
	end_time TIME,
	plan_attribute varchar(255) NOT NULL DEFAULT 'ÇªÇÃëº',
	plan_place VARCHAR(255),
	plan_title VARCHAR(255) NOT NULL DEFAULT 'ó\íË',
	plan_content TEXT,
	view_authority varchar(255) NOT NULL DEFAULT 'å¬êl',
	create_group_id VARCHAR(12),
	create_user_id VARCHAR(12) NOT NULL,
	create_date TIMESTAMP NOT NULL
);

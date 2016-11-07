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
	plan_attribute ENUM('�d��','�C�x���g','�v���C�x�[�g','���̑�') NOT NULL DEFAULT '���̑�',
	plan_place VARCHAR(255),
	plan_title VARCHAR(255) NOT NULL DEFAULT '�\��',
	plan_content TEXT,
	view_authority ENUM('�S��','�O���[�v','�l') NOT NULL DEFAULT '�l',
	create_group_id VARCHAR(12),
	create_user_id VARCHAR(12) NOT NULL,
	create_date TIMESTAMP NOT NULL
);
INSERT INTO userdata VALUES('a','a','a','a');
INSERT INTO userdata VALUES('user_id','user_name','user_mail','user_pass');
INSERT INTO groupdata VALUES('group_id','group_name','group_pass','group_membar','group_create_user_id');
INSERT INTO plandata VALUES('plan_day','plan_time','plan_attribute','plan_place','plan_title','plan_content','view_authority','create_group_id','create_user_id');


INSERT INTO plandata(plan_day,plan_time,plan_attribute,plan_place,plan_title,plan_content,view_authority,create_group_id,create_user_id)
 VALUES('1111-11-11','00:00:00','���̑�','plan_place','plan_title','plan_content','�l','create_group','create_user');

SELECT plan_day,plan_time,plan_title,create_user_id FROM wecalendar.plandata;

INSERT INTO �e�[�u���� VALUES('�J�����@�̒l','�J�����A�̒l');			/* �ǉ� */
DELETE FROM �e�[�u���� WHERE �J������=�l;								/* �폜 */
UPDATE �e�[�u���� SET �J�������@=�l,�J�������A=�l WHERE �J������=�l;	/* �X�V */


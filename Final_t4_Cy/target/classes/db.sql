create table cy_member(
c_id varchar2(10 char) primary key,
c_pw varchar2(100 char) not null,
c_name varchar2 (10 char) not null,
c_minimi varchar2 (200 char) not null,
c_gender char (2 char) not null,
c_phone char(11 char) not null,
c_birth varchar2 (20 char) not null,
c_photo varchar2 (200 char) not null,
c_dotori number(20)
);

select * from cy_member;

drop table cy_member cascade constraint purge;
---------------------------------------------------
create table cy_pageInfo(
p_id varchar2(10 char),
p_name varchar2(10 char), --이름
p_birth varchar2(20 char), --생일
p_photo varchar2 (200 char), --프로필사진
p_music varchar2(100 char), --프로필뮤직
p_musicsec varchar2(100 char), --브금 재생시간
p_theme varchar2(100 char), --설정 테마
p_profile varchar2(1000 char), --프로필메시지
p_email varchar2(200 char), --이메일주소
p_sns varchar2(1000 char), --sns주소
p_state varchar2(200 char), --구직상태

constraint page_user
foreign key(p_id) references cy_member(c_id)
on delete cascade
);

select * from cy_pageInfo;
drop table cy_pageInfo cascade constraint purge;

---------------------------------------------------

-- 방명록
create table cy_message(
	c_no number(4) primary key,	
	c_writer varchar2(10 char) not null,
	c_guest_comment varchar2(200 char) not null,
	c_date date not null,


	constraint message_writer
		foreign key(c_writer) references cy_member(c_id)
		on delete cascade 
);

create sequence cy_message_seq;

select * from cy_message;

drop table cy_message cascade constraint purge;
drop sequence cy_message_seq;

-------------------------------------- 포트폴리오
create table PortInfo(
p_user varchar2(10 char),
p_textarea varchar2(500 char),
p_month1 varchar2 (20 char),
p_month2 varchar2 (20 char),
p_school varchar2(20 char),
p_major varchar2(20 char),
p_schoolInfo varchar2(5 char),
p_selectBox1 varchar2(30 char),
p_selectBox2 varchar2(30 char),
p_licenDate varchar2(20 char),
p_licenName varchar2(20 char),
p_skillname varchar2(20 char),
p_skillrange varchar2(20 char),
p_hobby varchar2(20 char),

constraint port_user
foreign key(p_user) references cy_member(c_id)
on delete cascade
);

select * from PortInfo;
drop table PortInfo cascade constraint purge;

------------------------------------자소서

create table resume(
r_user varchar2(10 char),
r_txt1 varchar2(2000 char),
r_txt2 varchar2(2000 char),
r_txt3 varchar2(2000 char),
r_txt4 varchar2(2000 char),
r_txt5 varchar2(2000 char),

constraint resume_user
foreign key(r_user) references cy_member(c_id)
on delete cascade
);

select * from resume;

drop table resume cascade constraint purge;

----------------------------------------- board
create table board (
	b_no number(2) primary key,
	b_title varchar2 (200 char) not null,
	b_content varchar2 (1000 char) not null,
	b_writer varchar2 (50 char) not null,
	b_hit number(3) default 0,
	b_date date not null,
	constraint board_user
	foreign key(b_writer) references cy_member(c_id)
	on delete cascade
);

--b_viewcnt number default 0

create sequence board_seq;
select * from board;

drop table board cascade constraint purge;
drop sequence board_seq;

---------------------------구입내역(브금)
create table bgm_history(
	bh_no number(2) primary key,
	bh_id varchar2(50 char),
	bh_music varchar2(100 char),
	bh_date date
);

create sequence bgm_history_seq;
select * from bgm_history;

drop table bgm_history cascade constraint purge;
drop sequence bgm_history_seq;
---------------------------구입내역(테마)
create table theme_history(
	th_no number(2) primary key,
	th_id varchar2(50 char),
	th_theme varchar2(100 char),
	th_date date
);

create sequence theme_history_seq;
select * from theme_history;

select count(*) from theme_history where th_id='test3' and th_theme = 'pink'


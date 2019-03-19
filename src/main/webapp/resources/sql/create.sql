

create table store(
store_no number primary key,
store_name varchar2(100) not null,
store_location varchar2(100) not null,
store_tel varchar2(100) not null
);

create table dealer(
dealer_id varchar2(100) primary key,
dealer_pass varchar2(100) not null,
dealer_name varchar2(100) not null,
dealer_phone varchar2(100) not null,
dealer_email varchar2(100) not null,
store_no number not null,
FOREIGN KEY (store_no)
REFERENCES store(store_no) ON DELETE cascade
);


create table board(
board_num number primary key,
board_name varchar2(100) not null,
board_pass varchar2(100) not null,
board_subject varchar2(100) not null,
board_content varchar2(100) not null,
board_file varchar2(100),
board_original varchar2(100),
board_re_ref  number,
board_re_lev  number,
board_re_seq  number,
board_readcount number,
board_date date,
dealer_id varchar2(100),
car_no varchar2(100),
FOREIGN KEY (dealer_id)
REFERENCES dealer(dealer_id) ON DELETE SET NULL,
FOREIGN KEY (car_no)
REFERENCES car(car_no) ON DELETE SET NULL
);


create table car(
car_no varchar2(100) primary key,
car_price number not null,
car_class varchar2(100) not null,
car_model varchar2(100) not null,
car_engine varchar2(100),
car_accident varchar2(100),
car_old varchar2(100),
car_distance number,
car_condition varchar2(100),
car_change varchar2(100),
car_fault varchar2(100),
car_fuel varchar2(100),
car_cc number not null,
car_color varchar2(100),
car_option varchar2(100),
car_score number not null,
car_image varchar2(100),
dealer_id varchar2(100),
FOREIGN KEY (dealer_id)
REFERENCES dealer(dealer_id) ON DELETE SET NULL
);



create table car_temp(
temp_name varchar2(100) not null,
temp_location varchar2(100) not null,
temp_phone varchar2(100) not null,
temp_car_no varchar2(100) not null primary key,
temp_class varchar2(100) not null,
temp_model varchar2(100) not null,
temp_year varchar2(100),
temp_distance number,
temp_accident varchar2(100),
dealer_id varchar2(100),
FOREIGN KEY (dealer_id)
REFERENCES dealer(dealer_id) ON DELETE SET NULL
);

drop sequence  temp_no_seq; 
drop sequence dealer_id_seq; 

create sequence temp_no_seq; /*½ÃÄö½º Ãß°¡*/
create sequence dealer_id_seq; /*½ÃÄö½º Ãß°¡*/



create table advice(
advice_no number,
advice_name varchar2(100),
advice_phone varchar2(100),
advice_time varchar2(100),
advice_note varchar2(100),
car_no varchar2(100),
dealer_id varchar2(100),
FOREIGN KEY (car_no)
REFERENCES car(car_no) ON DELETE SET NULL,
FOREIGN KEY (dealer_id)
REFERENCES dealer(dealer_id) ON DELETE SET NULL
);


create table drive(
drive_no number primary key,
drive_car_no varchar2(100),
drive_car_class varchar2(100),
drive_car_model varchar2(100),
dealer_id varchar2(100),/*fk*/
drive_date date,
drive_ampm varchar2(100),
drive_name varchar2(100),
drive_phone varchar2(100),
drive_complete number,
FOREIGN KEY (dealer_id)
REFERENCES dealer(dealer_id) ON DELETE SET NULL
);
create sequence drive_seq;
create sequence testdate_seq;

create table test_date(
date_no number primary key,
date_date date not null,
date_ampm varchar2(100),
date_yn number,
store_no varchar2(100),
car_no varchar2(100),
FOREIGN KEY (car_no)
REFERENCES car(car_no) ON DELETE SET NULL
);



create table grade(
rowscore number,
hiscore number,
grade varchar2(10)
);

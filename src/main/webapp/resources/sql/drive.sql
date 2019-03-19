
select	to_char(sysdate + (level - 1), 'yyyy-mm-dd')	date_date
from	dual
connect	by level <= 7;


create sequence drive_seq;
create sequence testdate_seq;


select * from store;
select * from car;
select * from drive;
select * from test_date;


select	distinct store_location
from		(
				select	distinct
						substr(st.store_location, 1, instr(st.store_location, ' ')-1)
										as	store_location
						,		st.store_no	as store_no
				from	store				st
				join	dealer				dl
				on		dl.store_no			=		st.store_no
				join	car					cr
				on		cr.dealer_id		=		dl.dealer_id
				where	cr.car_class		=		'E-class'
				order by st.store_no
			)
			
update drive
set	drive_complete = 0

drop table userprofile;
drop SEQUENCE user_seq;

create table userprofile(
    user_id number(10) NOT NULL,
    name varchar2(50) NOT NULL,
    username varchar2(50) NOT NULL unique,
    email varchar2(50) NOT NULL unique,
    password varchar2(50) NOT NULL,
    PRIMARY KEY(user_id)  
);


CREATE SEQUENCE user_seq START WITH     1000 INCREMENT BY 1;

INSERT INTO userprofile
(user_id,name, username, email, password)
VALUES
(1001,'mahesh nagarwal', 'misterWolf','m@gmail.com','mahesh');

select * from userprofile where name like '%esh%';

--to find service name
select value from v$parameter where name='service_names';

--spring.datasource.username=PROFILEDB
--spring.datasource.password=profiledbpass
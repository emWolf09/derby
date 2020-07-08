C##IMAGEDB ---- user name 
system ---pass

drop table profile_picture;
drop SEQUENCE image_seq;

create table profile_picture(
    image_id number(10) NOT NULL,
    user_id number(10) NOT NULL unique,
    image_path varchar2(50) NOT NULL,
    created_on Date NOT NULL,
    PRIMARY KEY(image_id) 
);


CREATE SEQUENCE image_seq START WITH     7000 INCREMENT BY 1;

INSERT INTO profile_picture
(image_id,user_id, created_on,image_path)
VALUES
(7001,1001,TO_DATE('2017-02-11', 'yyyy-mm-dd'),'\filesystem\dp\');

INSERT INTO profile_picture
(image_id,user_id, created_on,image_path)
VALUES
(7002,1002,TO_DATE('2020-06-22', 'yyyy-mm-dd'),'\filesystem\dp\');

select * from profile_picture;

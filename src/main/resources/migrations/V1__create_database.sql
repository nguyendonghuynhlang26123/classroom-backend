drop table if exists tclassroom;

create sequence seq_gen start 100;

create table tclassroom(
    class_id bigint primary key not null,
    version integer not null,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
    class_title varchar(100) NOT NULL,
    class_code char(10),
    class_img char(200),
    class_room varchar(50),
    subject varchar(50),
    section varchar(50)
);
-- create table version (
-- 	head_guid varchar2(36 byte) not null,
-- 	constraint 'pk_version_head_guid' primary key ('head_guid')
-- );

create table member (
	member_name varchar2(30 byte) not null,
	password char(32 byte) not null,
	constraint "pk_member_member_name" primary key (member_name)
);

create table role (
	role_name varchar2(30 byte) not null,
	constraint "pk_role_role_name" primary key (role_name)
);

create table member_rel_role (
	role_name varchar2(30 byte) not null,
	member_name varchar2(30 byte) not null,
	constraint "pk_member_rel_role_mr_name" primary key (role_name, member_name)
);

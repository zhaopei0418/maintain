-- create table version (
-- 	head_guid varchar2(36 byte) not null,
-- 	constraint 'pk_version_head_guid' primary key ('head_guid')
-- );

-- 授权企业表，查询导出数据使用
create table grant_company (
	authorization_token char(32 byte) not null,
	company_code varchar2(36 byte) not null,
	note varchar2(100 char),
	constraint "pk_gc_auth_token" primary key (authorization_token)
);

create table member (
	code varchar2(32 byte) not null,
	name varchar2(30 byte) not null,
	password char(32 byte) not null,
	constraint "pk_member_code" primary key (code)
);

create table role (
	code varchar2(32 byte) not null,
	name varchar2(30 byte) not null,
	descript varchar2(100 char),
	constraint "pk_role_code" primary key (code)
);

create table permission (
	code varchar2(32 byte) not null,
  name varchar2(30 byte) not null,
	descript varchar2(100 char),
	url varchar2(128 byte) not null,
	constraint "pk_permission_code" primary key (code)
);

create table sys_group (
	code varchar2(32 byte) not null,
	name varchar2(50 char) not null,
	descript varchar2(100 char),
	constraint "pk_group_code" primary key (code)
);

create table group_rel_member (
	group_code varchar2(32 byte) not null,
	member_code varchar2(32 byte) not null,
	constraint "pk_grm_group_member_code" primary key (group_code, member_code)
);

create table group_rel_role (
	role_code varchar2(32 byte) not null,
	group_code varchar2(32 byte) not null,
	constraint "pk_grr_role_group_code" primary key (role_code, group_code)
);

create table role_rel_permission (
	role_code varchar2(32 byte) not null,
	permission_code varchar2(32 byte) not null,
	constraint "pk_rrp_role_permission_code" primary key (role_code, permission_code)
);

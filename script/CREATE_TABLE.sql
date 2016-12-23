create table version (
	head_guid varchar2(36 byte) not null,
	constraint 'pk_version_head_guid' primary_key ('head_guid')
);

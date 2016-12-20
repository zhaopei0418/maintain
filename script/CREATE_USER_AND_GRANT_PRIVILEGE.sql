--先删除用户
drop user zhaopei cascade;

--创建用户
create user zhaopei identified by zhaopei;

--对用户授予连接数据库的访问访问资源的权限
grant connect, resource to zhaopei;

--对用户授予创建会话和DBA的权限
grant create session to zhaopei;

commit;

exit;

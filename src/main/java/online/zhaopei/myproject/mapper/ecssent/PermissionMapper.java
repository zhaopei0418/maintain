package online.zhaopei.myproject.mapper.ecssent;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.Permission;
import online.zhaopei.myproject.sqlprovide.ecssent.PermissionSqlProvide;

public interface PermissionMapper {

	@SelectProvider(type = PermissionSqlProvide.class, method = "getPermissionListByMemberCodeSql")
	List<Permission> getPermissionListByMemberCode(String memberCode);
	
	@SelectProvider(type = PermissionSqlProvide.class, method = "getPermissionListAllSql")
	List<Permission> getPermissionListAll();
}

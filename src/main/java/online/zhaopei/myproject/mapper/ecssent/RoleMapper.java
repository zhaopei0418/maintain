package online.zhaopei.myproject.mapper.ecssent;

import java.util.Set;

import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.Role;
import online.zhaopei.myproject.sqlprovide.ecssent.RoleSqlProvide;

public interface RoleMapper {

	@SelectProvider(type = RoleSqlProvide.class, method = "getRoleListByMemberCodeSql")
	Set<Role> getRoleListByMemberCode(String memberCode);
}

package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

public class PermissionSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -849586826314372230L;

	public String getPermissionListByMemberCodeSql(final String memberCode) {
		return new SQL() {{
			this.SELECT("p.code");
			this.SELECT("p.name");
			this.SELECT("p.descript");
			this.SELECT("p.url");
			
			this.FROM("member m");
			this.LEFT_OUTER_JOIN("group_rel_member grm on grm.member_code = m.code");
			this.LEFT_OUTER_JOIN("group_rel_role grr on grm.group_code = grr.group_code");
			this.LEFT_OUTER_JOIN("role_rel_permission rrp on rrp.role_code = grr.role_code");
			this.LEFT_OUTER_JOIN("permission p on rrp.permission_code = p.code");
			
			this.WHERE("m.code = '" + memberCode + "'");
		}}.toString();
	}
	
	public String getPermissionListAllSql() {
		return new SQL() {{
			this.SELECT("code");
			this.SELECT("name");
			this.SELECT("descript");
			this.SELECT("url");
			this.FROM("permission");
		}}.toString();
	}
}

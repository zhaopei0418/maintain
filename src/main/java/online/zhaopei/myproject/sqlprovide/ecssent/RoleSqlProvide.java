package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

public class RoleSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2738056706977576012L;

	public String getRoleListByMemberCodeSql(final String memberCode) {
		return new SQL() {{
			this.SELECT("r.code");
			this.SELECT("r.name");
			this.SELECT("r.descript");
			
			this.FROM("member m");
			this.LEFT_OUTER_JOIN("group_rel_member grm on grm.member_code = m.code");
			this.LEFT_OUTER_JOIN("group_rel_role grr on grm.group_code = grr.group_code");
			this.LEFT_OUTER_JOIN("role r on r.code = grr.role_code");
			
			this.WHERE("m.code = '" + memberCode + "'");
		}}.toString();
	}
}

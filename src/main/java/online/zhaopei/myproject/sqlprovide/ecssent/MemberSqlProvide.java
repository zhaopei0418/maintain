package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.Member;

public class MemberSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5516476884598015054L;

	public String insertMemberSql(final Member member) {
		return new SQL() {{
			this.INNER_JOIN("member");
			
			OracleTool.values(this, "member_name", member.getName());
			OracleTool.values(this, "password", member.getPassword());
		}}.toString();
	}
	
	public String countMemberSql(final Member member) {
		return new SQL() {{
			this.SELECT("count(1)");
			this.FROM("member");
			
			OracleTool.where(this, "member_name", member.getName());
		}}.toString();
	}
	
	public String deleteMemberSql(final Member member) {
		return new SQL() {{
			this.DELETE_FROM("member");
			
			OracleTool.where(this, "member_name", member.getName());
		}}.toString();
	}
	
	public String updateMemberSql(final Member member) {
		return new SQL() {{
			this.UPDATE("member");
			OracleTool.set(this, "password", member.getPassword());
			OracleTool.where(this, "member_name", member.getName());
		}}.toString();
	}
	
	public String getMemberListSql(final Member member) {
		return new SQL() {{
			this.SELECT("name");
			this.SELECT("password");
			
			this.FROM("memeber");
			
			OracleTool.where(this, "member_name", member.getName());
		}}.toString();
	}
	
	public String getMemberByUserNameSql(final String userName) {
		return new SQL() {{
			this.SELECT("code");
			this.SELECT("name");
			this.SELECT("password");
			this.SELECT("nickname");
			this.SELECT("email");
			this.SELECT("company_code");
			this.FROM("member");
			
			this.WHERE("name = '" + userName + "'");
		}}.toString();
	}
}

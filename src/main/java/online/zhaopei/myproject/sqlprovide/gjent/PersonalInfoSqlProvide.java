package online.zhaopei.myproject.sqlprovide.gjent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

public class PersonalInfoSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8269148158645035995L;

	public String getPersonByIdSql() {
		return new SQL() {{
			this.SELECT("uuid, pername, certid");
			this.FROM("personal_info");
			this.WHERE("certid = #{id}");
		}}.toString();
	}
}

package online.zhaopei.myproject.sqlprovide.para;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

public class CustomsSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1630423204207078524L;

	public String getCustomsByCodeSql() {
		return new SQL() {{
			this.SELECT("*");
			this.FROM("customs");
			this.WHERE("customs_code = #{customsCode}");
		}}.toString();
	}
}

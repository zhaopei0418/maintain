package online.zhaopei.myproject.sqlprovide.para;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class CurrSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 950013451277540855L;

	public String getCurrByCodeSql(final String code) {
		return new SQL() {{
			this.SELECT("curr_code");
			this.SELECT("curr_name");
			this.FROM("curr");
			
			if (!StringUtils.isEmpty(code)) {
				this.WHERE("curr_code = '" + code + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
}

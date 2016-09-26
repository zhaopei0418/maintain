package online.zhaopei.myproject.sqlprovide.para;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class WrapSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2813008814719704573L;

	public String getWrapByCodeSql(final String wrapCode) {
		return new SQL() {{
			this.SELECT("wrap_code");
			this.SELECT("wrap_name");
			this.FROM("wrap");
			
			if (!StringUtils.isEmpty(wrapCode)) {
				this.WHERE("wrap_code = '" + wrapCode + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}

}

package online.zhaopei.myproject.sqlprovide.para;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class CountrySqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -511685456388292074L;

	public String getCountryByCodeSql(final String code) {
		return new SQL() {{
			this.SELECT("country_code");
			this.SELECT("coun_c_name");
			this.FROM("country");

			if (!StringUtils.isEmpty(code)) {
				this.WHERE("country_code = '" + code + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
}

package online.zhaopei.myproject.sqlprovide.para;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class UnitSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5825674449555355621L;

	public String getUnitByCodeSql(final String unitCode) {
		return new SQL() {{
			this.SELECT("unit_code");
			this.SELECT("unit_name");
			this.FROM("unit");
			
			if (!StringUtils.isEmpty(unitCode)) {
				this.WHERE("unit_code = '" + unitCode + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
}

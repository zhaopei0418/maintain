package online.zhaopei.myproject.sqlprovide.para;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class TransfSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8812365309067192264L;

	public String getTransfByCodeSql(final String transfCode) {
		return new SQL() {{
			this.SELECT("traf_code");
			this.SELECT("traf_spec");
			this.FROM("transf");
			
			if (!StringUtils.isEmpty(transfCode)) {
				this.WHERE("traf_code = '" + transfCode + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
}

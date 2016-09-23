package online.zhaopei.myproject.sqlprovide.para;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class TradeSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4553244453506019688L;

	public String getTradeByCodeSql(final String code) {
		return new SQL() {{
			this.SELECT("trade_mode");
			this.SELECT("abbr_trade");
			this.FROM("trade");
			if (!StringUtils.isEmpty(code)) {
				this.WHERE("trade_mode = '" + code + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
}

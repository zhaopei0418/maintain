package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class InvtListSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7453188197490834512L;

	public String getInvtListListByHeadGuidSql(final String headGuid) {
		return new SQL() {{
			this.SELECT("head_guid");
			this.SELECT("g_num");
			this.SELECT("item_record_no");
			this.SELECT("item_no");
			this.SELECT("item_name");
			this.SELECT("g_code");
			this.SELECT("g_name");
			this.SELECT("g_model");
			this.SELECT("bar_code");
			this.SELECT("country");
			this.SELECT("currency");
			this.SELECT("qty");
			this.SELECT("qty1");
			this.SELECT("qty2");
			this.SELECT("unit");
			this.SELECT("unit_1");
			this.SELECT("unit_2");
			this.SELECT("price");
			this.SELECT("total_price");
			this.SELECT("note");
			this.SELECT("sys_date");
			this.FROM("ceb2_invt_list");

			if (!StringUtils.isEmpty(headGuid)) {
				this.WHERE("head_guid = '" + headGuid + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
}

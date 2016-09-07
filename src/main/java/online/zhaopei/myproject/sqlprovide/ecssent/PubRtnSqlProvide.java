package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class PubRtnSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6711187188321675389L;

	public String getPubRtnListByBizGuidSql(final String bizGuid) {
		return new SQL() {{
			this.SELECT("msg_guid");
			this.SELECT("biz_type");
			this.SELECT("biz_guid");
			this.SELECT("pre_no");
			this.SELECT("h2k_no");
			this.SELECT("app_status");
			this.SELECT("rtn_status");
			this.SELECT("rtn_time");
			this.SELECT("rtn_info");
			this.SELECT("note");
			this.SELECT("sys_days");
			this.SELECT("sys_date");
			this.FROM("ceb2_pub_rtn");
			if (!StringUtils.isEmpty(bizGuid)) {
				this.WHERE("biz_guid = '" + bizGuid + "'");
			}
			this.ORDER_BY("rtn_time desc");
		}}.toString();
	}
}

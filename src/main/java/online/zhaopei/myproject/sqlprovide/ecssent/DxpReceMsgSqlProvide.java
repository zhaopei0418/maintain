package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.common.tool.OracleTool;

public class DxpReceMsgSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6315331403630024183L;

	public String getDxpReceMsgByMsgGuidSql(final String msgGuid) {
		return new SQL() {{
			this.SELECT("msg_guid");
			this.SELECT("encoding");
			this.SELECT("msg_size");
			this.SELECT("msg_blob");
			this.SELECT("biz_blob");
			this.SELECT("note");
			this.SELECT("sys_days");
			this.SELECT("sys_date");
			this.FROM("dxp_rece_msg");
			
			if (!StringUtils.isEmpty(msgGuid)) {
				OracleTool.where(this, "msg_guid", msgGuid);
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
}

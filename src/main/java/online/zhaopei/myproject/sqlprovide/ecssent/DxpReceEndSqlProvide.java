package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.DxpReceEnd;

public class DxpReceEndSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7029758789791775046L;

	public String getDxpReceEndListSql(final DxpReceEnd dxpReceEnd) {
		return new SQL() {{
			this.SELECT("msg_guid");
			this.SELECT("dxp_mode");
			this.SELECT("dxp_status");
			this.SELECT("dxp_host");
			this.SELECT("msg_type");
			this.SELECT("msg_name");
			this.SELECT("msg_id");
			this.SELECT("msg_key");
			this.SELECT("msg_time");
			this.SELECT("send_ad");
			this.SELECT("rece_ad");
			this.SELECT("sys_date");
			this.FROM("dxp_rece_end");
			
			OracleTool.where(this, "msg_guid", dxpReceEnd.getMsgGuid());
			OracleTool.where(this, "dxp_mode", dxpReceEnd.getDxpMode());
			OracleTool.where(this, "dxp_status", dxpReceEnd.getDxpStatus());
			OracleTool.where(this, "dxp_host", dxpReceEnd.getDxpHost());
			OracleTool.where(this, "msg_type", dxpReceEnd.getMsgType());
			OracleTool.where(this, "msg_name", dxpReceEnd.getMsgName());
			OracleTool.where(this, "msg_id", dxpReceEnd.getMsgId());
			OracleTool.where(this, "msg_key", dxpReceEnd.getMsgKey());
			OracleTool.where(this, "send_ad", dxpReceEnd.getSendAd());
			OracleTool.where(this, "rece_ad", dxpReceEnd.getReceAd());
			OracleTool.where(this, "sys_date", dxpReceEnd.getBeginSysDate(), ">=");
			OracleTool.where(this, "sys_date", dxpReceEnd.getEndSysDate(), "<=");
			OracleTool.where(this, "sys_date", dxpReceEnd.getSysDateStr(), "=");
		}}.toString();
	}
}

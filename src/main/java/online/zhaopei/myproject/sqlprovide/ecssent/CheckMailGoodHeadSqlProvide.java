package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.CheckMailGoodHead;

public class CheckMailGoodHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3238915169560229437L;

	public String getCheckMailGoodHeadListSql(final CheckMailGoodHead checkMailGoodHead) {
		return new SQL() {{
			this.SELECT("seq_no");
			this.SELECT("entry_id");
			this.SELECT("ie_flage");
			this.SELECT("order_no");
			this.SELECT("logistics_no");
			this.SELECT("logistics_name");
			this.SELECT("logistics_code");
			this.SELECT("ecp_code");
			this.SELECT("ecp_name");
			this.SELECT("wrap_type");
			this.SELECT("pack_num");
			this.SELECT("gross_wt");
			this.SELECT("net_wt");
			this.SELECT("goods_value");
			this.SELECT("freight");
			this.SELECT("controlled_status");
			this.SELECT("controlled_date");
			this.SELECT("operator");
			this.SELECT("message_time");
			this.SELECT("check_date");
			this.SELECT("check_type");
			this.SELECT("check_man");
			this.SELECT("check_opinion");
			this.SELECT("customs_code");
			this.SELECT("check_result");
			this.SELECT("conduct_result");
			this.SELECT("consignee");
			this.SELECT("shipper");
			this.SELECT("status");
			this.SELECT("if_check_insp");
			this.SELECT("if_machine");
			this.SELECT("status_insp");
			this.SELECT("op_type");
			this.SELECT("op_type_insp");
			this.SELECT("zyd_code");
			this.FROM("check_mail_good_head");

			OracleTool.where(this, "logistics_no", checkMailGoodHead.getLogisticsNo());
			OracleTool.where(this, "logistics_code", checkMailGoodHead.getLogisticsCode());
			OracleTool.where(this, "logistics_name", checkMailGoodHead.getLogisticsName(), true);
			OracleTool.where(this, "zyd_code", checkMailGoodHead.getZydCode());
			OracleTool.where(this, "entry_id", checkMailGoodHead.getEntryId());
			OracleTool.where(this, "check_date", checkMailGoodHead.getBeginCheckDate(), ">=");
			OracleTool.where(this, "check_date", checkMailGoodHead.getEndCheckDate(), "<=");
			OracleTool.where(this, "check_date", checkMailGoodHead.getCheckDateStr(), "=");
			OracleTool.where(this, "message_time", checkMailGoodHead.getBeginMessageTime(), ">=");
			OracleTool.where(this, "message_time", checkMailGoodHead.getEndMessageTime(), "<=");
			OracleTool.where(this, "message_time", checkMailGoodHead.getMessageTimeStr(), "=");
			OracleTool.where(this, "status", checkMailGoodHead.getStatus());
			OracleTool.where(this, "status_insp", checkMailGoodHead.getStatusInsp());
			OracleTool.where(this, "customs_code", checkMailGoodHead.getCustomsCode());
			OracleTool.where(this, "op_type", checkMailGoodHead.getOpType());
			OracleTool.where(this, "op_type_insp", checkMailGoodHead.getOpTypeInsp());
			
		}}.toString();
	}
}

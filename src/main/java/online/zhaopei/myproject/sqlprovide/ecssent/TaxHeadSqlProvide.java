package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.TaxHead;

public class TaxHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5459372648173022160L;

	public String getTaxHeadListSql(final TaxHead taxHead) {
		return new SQL() {{
			this.SELECT("head_guid");
			this.SELECT("return_time");
			this.SELECT("customs_code");
			this.SELECT("invt_no");
			this.SELECT("tax_no");
			this.SELECT("tax_total");
			this.SELECT("customs_tax");
			this.SELECT("value_added_tax");
			this.SELECT("consumption_tax");
			this.SELECT("status");
			this.SELECT("ent_duty_no");
			this.SELECT("id_number");
			this.SELECT("assure_code");
			this.SELECT("ebc_code");
			this.SELECT("logistics_code");
			this.SELECT("msg_guid");
			this.SELECT("sys_date");
			this.SELECT("agent_code");
			this.FROM("ceb2_tax_head");
			
			OracleTool.where(this, "invt_no", taxHead.getInvtNo());
			OracleTool.where(this, "tax_no", taxHead.getTaxNo());
			OracleTool.where(this, "ent_duty_no", taxHead.getEntDutyNo());
			OracleTool.where(this, "id_number", taxHead.getIdNumber());
			OracleTool.where(this, "assure_code", taxHead.getAssureCode());
			OracleTool.where(this, "ebc_code", taxHead.getEbcCode());
			OracleTool.where(this, "logistics_code", taxHead.getLogisticsCode());
			OracleTool.where(this, "customs_code", taxHead.getCustomsCode());
			OracleTool.where(this, "sys_date", taxHead.getBeginSysDate(), ">=");
			OracleTool.where(this, "sys_date", taxHead.getEndSysDate(), "<=");
			OracleTool.where(this, "sys_date", taxHead.getSysDateStr(), "=");
		}}.toString();
	}
}

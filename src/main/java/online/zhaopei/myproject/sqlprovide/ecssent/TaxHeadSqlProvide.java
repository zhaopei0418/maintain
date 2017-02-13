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
			this.SELECT("cth.head_guid");
			this.SELECT("cth.return_time");
			this.SELECT("cth.customs_code");
			this.SELECT("cth.invt_no");
			this.SELECT("cih.order_no");
			this.SELECT("cih.logistics_no");
			this.SELECT("cth.tax_no");
			this.SELECT("cth.tax_total");
			this.SELECT("cth.customs_tax");
			this.SELECT("cth.value_added_tax");
			this.SELECT("cth.consumption_tax");
			this.SELECT("cth.status");
			this.SELECT("cth.ent_duty_no");
			this.SELECT("cth.id_number");
			this.SELECT("cth.assure_code");
			this.SELECT("cpci.company_name");
			this.SELECT("cth.ebc_code");
			this.SELECT("cih.ebc_name");
			this.SELECT("cth.logistics_code");
			this.SELECT("cih.logistics_name");
			this.SELECT("cth.msg_guid");
			this.SELECT("cth.sys_date");
			this.SELECT("cth.agent_code");
			this.SELECT("cih.agent_name");
			this.FROM("ceb2_tax_head cth");
			this.LEFT_OUTER_JOIN("ceb2_invt_head cih on cih.invt_no = cth.invt_no");
			this.LEFT_OUTER_JOIN("ceb_pre_company_info cpci on cpci.company_code = cth.assure_code");
			
			OracleTool.where(this, "cth.invt_no", taxHead.getInvtNo());
			OracleTool.where(this, "cth.tax_no", taxHead.getTaxNo());
			OracleTool.where(this, "cih.order_no", taxHead.getOrderNo());
			OracleTool.where(this, "cih.logistics_no", taxHead.getLogisticsNo());
			OracleTool.where(this, "cth.ent_duty_no", taxHead.getEntDutyNo());
			OracleTool.where(this, "cth.id_number", taxHead.getIdNumber());
			OracleTool.where(this, "cth.assure_code", taxHead.getAssureCode());
			OracleTool.where(this, "cpci.company_name", taxHead.getAssureName(), true);
			OracleTool.where(this, "cth.ebc_code", taxHead.getEbcCode());
			OracleTool.where(this, "cih.ebc_name", taxHead.getEbcName(), true);
			OracleTool.where(this, "cth.logistics_code", taxHead.getLogisticsCode());
			OracleTool.where(this, "cih.logistics_name", taxHead.getLogisticsName(), true);
			OracleTool.where(this, "cth.customs_code", taxHead.getCustomsCode());
			OracleTool.where(this, "cth.agent_code", taxHead.getAgentCode());
			OracleTool.where(this, "cih.agent_name", taxHead.getAgentName(), true);
			OracleTool.where(this, "cth.sys_date", taxHead.getBeginSysDate(), ">=");
			OracleTool.where(this, "cth.sys_date", taxHead.getEndSysDate(), "<=");
			OracleTool.where(this, "cth.sys_date", taxHead.getSysDateStr(), "=");
		}}.toString();
	}
}

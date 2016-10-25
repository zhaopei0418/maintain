package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.InvtCancel;

public class InvtCancelSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6539702310170797519L;

	public String getInvtCancelListSql(final InvtCancel invtCancel) {
		return new SQL() {{
			this.SELECT("head_guid");
			this.SELECT("cop_no");
			this.SELECT("order_no");
			this.SELECT("pre_no");
			this.SELECT("invt_no");
			this.SELECT("ebc_code");
			this.SELECT("ebc_name");
			this.SELECT("agent_code");
			this.SELECT("agent_name");
			this.SELECT("sys_date");
			this.SELECT("app_status");
			this.SELECT("reason");
			this.SELECT("customs_code");
			this.SELECT("logistics_no");
			this.SELECT("logistics_code");
			this.SELECT("logistics_name");
			this.FROM("ceb2_invt_cancel");
			
			if (!StringUtils.isEmpty(invtCancel.getCopNo())) {
				this.WHERE("cop_no = '" + invtCancel.getCopNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getPreNo())) {
				this.WHERE("pre_no = '" + invtCancel.getPreNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getInvtNo())) {
				this.WHERE("invt_no = '" + invtCancel.getInvtNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getEbcCode())) {
				this.WHERE("ebc_code = '" + invtCancel.getEbcCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getEbcName())) {
				this.WHERE("ebc_name like '%" + invtCancel.getEbcName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getAgentCode())) {
				this.WHERE("agent_code = '" + invtCancel.getAgentCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getAgentName())) {
				this.WHERE("agent_name like '%" + invtCancel.getAgentName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getAppStatus())) {
				this.WHERE("app_status = '" + invtCancel.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getCustomsCode())) {
				this.WHERE("customs_code = '" + invtCancel.getCustomsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getLogisticsCode())) {
				this.WHERE("logistics_code = '" + invtCancel.getLogisticsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getOrderNo())) {
				this.WHERE("order_no = '" + invtCancel.getOrderNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getLogisticsNo())) {
				this.WHERE("logistics_no = '" + invtCancel.getLogisticsNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getLogisticsName())) {
				this.WHERE("logistics_name like '%" + invtCancel.getLogisticsName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getBeginSysDate())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') >= '" + invtCancel.getBeginSysDate() + "'");
			}
			
			if (!StringUtils.isEmpty(invtCancel.getEndSysDate())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') <= '" + invtCancel.getEndSysDate() + "'");
			}
		}}.toString();
	}
}

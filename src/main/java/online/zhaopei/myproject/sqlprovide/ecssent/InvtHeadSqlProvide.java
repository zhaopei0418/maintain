package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.InvtHead;

public class InvtHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4299195909041965837L;

	public String getInvtHeadListSql(final InvtHead invtHead) {
		return new SQL() {{
			StringBuffer columns = new StringBuffer("head_guid");
			columns.append(",app_status");
			columns.append(",app_sender_id");
			columns.append(",order_no");
			columns.append(",ebc_code");
			columns.append(",ebc_name");
			columns.append(",logistics_no");
			columns.append(",logistics_code");
			columns.append(",logistics_name");
			columns.append(",cop_no");
			columns.append(",invt_no");
			columns.append(",agent_code");
			columns.append(",agent_name");
			columns.append(",area_code");
			columns.append(",area_name");
			this.SELECT(columns.toString());
			this.FROM("ceb2_invt_head");
			if (!StringUtils.isEmpty(invtHead.getHeadGuid())) {
				this.WHERE("head_guid = '" + invtHead.getHeadGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAppStatus())) {
				this.WHERE("app_status = '" + invtHead.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAppSenderId())) {
				this.WHERE("app_sender_id = '" + invtHead.getAppSenderId() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getOrderNo())) {
				this.WHERE("order_no = '" + invtHead.getOrderNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getEbcCode())) {
				this.WHERE("ebc_code = '" + invtHead.getEbcCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getEbcName())) {
				this.WHERE("ebc_name = '" + invtHead.getEbcName() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getLogisticsNo())) {
				this.WHERE("logistics_no = '" + invtHead.getLogisticsNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getLogisticsCode())) {
				this.WHERE("logistics_code = '" + invtHead.getLogisticsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getLogisticsName())) {
				this.WHERE("logistics_name = '" + invtHead.getLogisticsName() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getCopNo())) {
				this.WHERE("cop_no = '" + invtHead.getCopNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getInvtNo())) {
				this.WHERE("invt_no = '" + invtHead.getInvtNo() + "'");
			}
			
		}}.toString();
	}
}

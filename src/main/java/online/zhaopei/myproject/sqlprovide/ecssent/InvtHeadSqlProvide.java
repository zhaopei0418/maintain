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
			this.SELECT("head_guid");
			this.SELECT("app_status");
			this.SELECT("app_time");
			this.SELECT("app_sender_id");
			this.SELECT("order_no");
			this.SELECT("ebc_code");
			this.SELECT("ebc_name");
			this.SELECT("logistics_no");
			this.SELECT("logistics_code");
			this.SELECT("logistics_name");
			this.SELECT("cop_no");
			this.SELECT("pre_no");
			this.SELECT("invt_no");
			this.SELECT("agent_code");
			this.SELECT("agent_name");
			this.SELECT("area_code");
			this.SELECT("area_name");
			this.SELECT("dist_status");
			this.FROM("ceb2_invt_head");
			if (!StringUtils.isEmpty(invtHead.getHeadGuid())) {
				this.WHERE("head_guid = '" + invtHead.getHeadGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAppStatus())) {
				this.WHERE("app_status = '" + invtHead.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getBeginAppTime())) {
				this.WHERE("to_char(app_time, 'yyyy-mm-dd') >= '" + invtHead.getBeginAppTime() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getEndAppTime())) {
				this.WHERE("to_char(app_time, 'yyyy-mm-dd') <= '" + invtHead.getEndAppTime() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAppSenderId())) {
				this.WHERE("app_sender_id = '" + invtHead.getAppSenderId() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getOrderNo())) {
				this.WHERE("order_no like '%" + invtHead.getOrderNo() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getEbcCode())) {
				this.WHERE("ebc_code = '" + invtHead.getEbcCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getEbcName())) {
				this.WHERE("ebc_name like '%" + invtHead.getEbcName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getLogisticsNo())) {
				this.WHERE("logistics_no like '%" + invtHead.getLogisticsNo() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getLogisticsCode())) {
				this.WHERE("logistics_code = '" + invtHead.getLogisticsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getLogisticsName())) {
				this.WHERE("logistics_name like '%" + invtHead.getLogisticsName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getCopNo())) {
				this.WHERE("cop_no = '" + invtHead.getCopNo() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getInvtNo())) {
				this.WHERE("invt_no like '%" + invtHead.getInvtNo() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAgentCode())) {
				this.WHERE("agent_code = '" + invtHead.getAgentCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAgentName())) {
				this.WHERE("agent_name like '%" + invtHead.getAgentName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAreaCode())) {
				this.WHERE("area_code = '" + invtHead.getAreaCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAreaName())) {
				this.WHERE("area_name like '%" + invtHead.getAreaName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getDistStatus())) {
				this.WHERE("dist_status = '" + invtHead.getDistStatus() + "'");
			}
			
		}}.toString();
	}
}

package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.InvtHead;

public class InvtHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4299195909041965837L;

	private List<String> selectField() {
		return new ArrayList<String>(){{
			this.add("head_guid");
			this.add("app_status");
			this.add("app_time");
			this.add("sys_date");
			this.add("app_sender_id");
			this.add("order_no");
			this.add("ebc_code");
			this.add("ebc_name");
			this.add("logistics_no");
			this.add("logistics_code");
			this.add("logistics_name");
			this.add("cop_no");
			this.add("pre_no");
			this.add("invt_no");
			this.add("agent_code");
			this.add("agent_name");
			this.add("area_code");
			this.add("area_name");
			this.add("customs_code");
			this.add("dist_status");
			this.add("trade_mode");
		}};
	}
	
	public String getInvtHeadByHeadGuidSql(final String headGuid) {
		final InvtHeadSqlProvide self = this;
		return new SQL() {{
			for(String field : self.selectField()) {
				this.SELECT(field);
			}
			this.SELECT("app_type");
			this.SELECT("port_code");
			this.SELECT("ebp_code");
			this.SELECT("ebp_name");
			this.SELECT("ie_date");
			this.SELECT("loct_no");
			this.SELECT("ems_no");
			this.SELECT("buyer_name");
			this.SELECT("country");
			this.SELECT("traf_no");
			this.SELECT("wrap_type");
			this.SELECT("pack_no");
			this.SELECT("buyer_id_type");
			this.SELECT("consignee_address");
			this.SELECT("voyage_no");
			this.SELECT("assure_code");
			this.SELECT("gross_weight");
			this.SELECT("buyer_id_number");
			this.SELECT("license_no");
			this.SELECT("bill_no");
			this.SELECT("insured_fee");
			this.SELECT("net_weight");
			this.SELECT("buyer_telephone");
			this.SELECT("traf_mode");
			this.SELECT("freight");
			this.SELECT("currency");
			this.SELECT("note");
			this.FROM("ceb2_invt_head");
			this.WHERE("head_guid = '" + headGuid + "'");
			
		}}.toString();
	}
	
	public String getInvtHeadListSql(final InvtHead invtHead) {
		final InvtHeadSqlProvide self = this;
		return new SQL() {{
			for(String field : self.selectField()) {
				this.SELECT(field);
			}
			this.FROM("ceb2_invt_head cih");
			
			if (!StringUtils.isEmpty(invtHead.getDistinct())) {
				this.INNER_JOIN("(select min(head_guid) as inner_head_guid from ceb2_invt_head group by ebc_code, order_no) cih1 on cih.head_guid = cih1.inner_head_guid");
			}
			
			if (!StringUtils.isEmpty(invtHead.getSearchText())) {
				this.WHERE("invt_no like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("cop_no like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("ebc_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("ebc_name like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("order_no like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("agent_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("agent_name like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("logistics_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("logistics_name like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("logistics_no like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("area_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("area_name like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("customs_code like '%" + invtHead.getSearchText() + "%'");
				this.OR().WHERE("trade_mode like '%" + invtHead.getSearchText() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getHeadGuid())) {
				this.WHERE("head_guid = '" + invtHead.getHeadGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getAppStatus())) {
				this.WHERE("app_status = '" + invtHead.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getBeginAppTime())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') >= '" + invtHead.getBeginAppTime() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getEndAppTime())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') <= '" + invtHead.getEndAppTime() + "'");
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
			
			if (!StringUtils.isEmpty(invtHead.getCustomsCode())) {
				this.WHERE("customs_code = '" + invtHead.getCustomsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getTradeMode())) {
				this.WHERE("trade_mode = '" + invtHead.getTradeMode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHead.getDeclareStatus())) {
				if ("1".equals(invtHead.getDeclareStatus())) {
					this.WHERE("app_status in ('1', '01', '100')");
				} else {
					this.WHERE("app_status not in ('1', '01', '100')");
				}
			}
			
		}}.toString();
	}
}

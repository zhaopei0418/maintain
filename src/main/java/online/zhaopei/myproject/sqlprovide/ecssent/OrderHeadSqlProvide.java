package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.OrderHead;

public class OrderHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4190863223284944833L;

	public String getOrderHeadByHeadGuidSql(final String headGuid) {
		return new SQL() {{
			this.SELECT("head_guid");
			this.SELECT("app_type");
			this.SELECT("app_time");
			this.SELECT("app_status");
			this.SELECT("app_uid");
			this.SELECT("app_uname");
			this.SELECT("app_sender_id");
			this.SELECT("decl_time");
			this.SELECT("order_type");
			this.SELECT("order_no");
			this.SELECT("ebp_code");
			this.SELECT("ebp_name");
			this.SELECT("ebc_code");
			this.SELECT("ebc_name");
			this.SELECT("goods_value");
			this.SELECT("freight");
			this.SELECT("discount");
			this.SELECT("tax_total");
			this.SELECT("actural_paid");
			this.SELECT("currency");
			this.SELECT("buyer_reg_no");
			this.SELECT("buyer_name");
			this.SELECT("buyer_id_type");
			this.SELECT("buyer_id_number");
			this.SELECT("pay_code");
			this.SELECT("pay_name");
			this.SELECT("pay_transaction_id");
			this.SELECT("batch_numbers");
			this.SELECT("consignee");
			this.SELECT("consignee_telephone");
			this.SELECT("consignee_address");
			this.SELECT("consignee_district");
			this.SELECT("note");
			this.SELECT("msg_guid");
			this.SELECT("del_flag");
			this.SELECT("sys_days");
			this.SELECT("sys_date");
			this.FROM("ceb2_ord_head");
			
			if (!StringUtils.isEmpty(headGuid)) {
				OracleTool.where(this, "head_guid", headGuid);
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
	
	public String getOrderHeadListSql(final OrderHead orderHead) {
		return new SQL() {{
			this.SELECT("head_guid");
			this.SELECT("order_no");
			this.SELECT("ebc_code");
			this.SELECT("ebc_name");
			this.SELECT("ebp_code");
			this.SELECT("ebp_name");
			this.SELECT("goods_value");
			this.SELECT("actural_paid");
			this.SELECT("buyer_name");
			this.SELECT("buyer_id_number");
			this.SELECT("app_status");
			this.SELECT("sys_date");
			this.SELECT("app_type");
			this.FROM("ceb2_ord_head");
			
			if (!StringUtils.isEmpty(orderHead.getHeadGuid())) {
				this.WHERE("head_guid = '" + orderHead.getHeadGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getOrderNo())) {
				this.WHERE("order_no = '" + orderHead.getOrderNo() + "'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getEbcCode())) {
				this.WHERE("ebc_code = '" + orderHead.getEbcCode() + "'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getEbcName())) {
				this.WHERE("ebc_name like '" + orderHead.getEbcName() + "%'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getEbpCode())) {
				this.WHERE("ebp_code = '" + orderHead.getEbpCode() + "'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getEbpName())) {
				this.WHERE("ebp_name like '" + orderHead.getEbcName() + "'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getBuyerName())) {
				this.WHERE("buyer_name like '" + orderHead.getBuyerName() + "%'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getBuyerIdNumber())) {
				this.WHERE("buyer_id_number like '" + orderHead.getBuyerIdNumber() + "%'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getAppStatus())) {
				this.WHERE("app_status = '" + orderHead.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getAppType())) {
				this.WHERE("app_type = '" + orderHead.getAppType() + "'");
			}
			
			if (!StringUtils.isEmpty(orderHead.getBeginSysDate())) {
				this.WHERE("sys_date >= to_date('" + orderHead.getBeginSysDate() + "', 'yyyy-MM-dd')");
			}
			
			if (!StringUtils.isEmpty(orderHead.getEndSysDate())) {
				this.WHERE("sys_date <= to_date('" + orderHead.getEndSysDate() + " 23:59:59', 'yyyy-MM-dd hh24:mi:ss')");
			}
		}}.toString();
	}
}

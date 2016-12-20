package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.common.tool.OracleTool;


public class OrderListSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1112311194082242440L;

	public String countOrderListSql(final String headGuid) {
		return new SQL() {{
			this.SELECT("count(1)");
			this.FROM("ceb2_ord_head");
			
			if (!StringUtils.isEmpty(headGuid)) {
				OracleTool.where(this, "head_guid", headGuid);
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
	
	public String getOrderListByHeadGuidSql(final String headGuid) {
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
			this.SELECT("current");
			this.SELECT("buyer_reg_no");
			this.SELECT("buyer_name");
			this.SELECT("buyper_id_type");
			this.SELECT("buyper_id_number");
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
	
	public String getOrderListBySearchTextSql(final String headGuid, final String searchText) {
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
			this.SELECT("current");
			this.SELECT("buyer_reg_no");
			this.SELECT("buyer_name");
			this.SELECT("buyper_id_type");
			this.SELECT("buyper_id_number");
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
			
			if (!StringUtils.isEmpty(searchText)) {
				String orSql = "(unit like '%" + searchText + "%'";
				orSql += " OR g_name like '%" + searchText + "%'";
				orSql += " OR g_code like '%" + searchText + "%'";
				orSql += " OR item_no like '%" + searchText + "%'";
				orSql += " OR qty like '%" + searchText + "%'";
				orSql += " OR price = '" + searchText + "'";
				orSql += " OR total_price = '" + searchText + "'";
				orSql += " OR country like '%" + searchText + "%'";
				orSql += " OR currency like '%" + searchText + "%')";
				this.WHERE(orSql);
			}
			
		}}.toString();
	}
}

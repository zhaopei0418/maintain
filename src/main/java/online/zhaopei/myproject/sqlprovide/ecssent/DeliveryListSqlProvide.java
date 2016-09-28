package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.DeliveryList;

public class DeliveryListSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2300335289279734273L;

	public String getDeliveryListByGuidSql(final String headGuid) {
		return new SQL(){{
			this.SELECT("head_guid");
			this.SELECT("g_num");
			this.SELECT("logistics_no");
			this.SELECT("note");
			this.SELECT("sys_date");
			this.FROM("ceb2_delivery_list");
			if (!StringUtils.isEmpty(headGuid)) {
				this.WHERE("head_guid = '" + headGuid + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
	
	public String getDeliveryListSql(final DeliveryList deliveryList) {
		return new SQL() {{
			this.SELECT("head_guid");
			this.SELECT("g_num");
			this.SELECT("logistics_no");
			this.SELECT("note");
			this.SELECT("sys_date");
			this.FROM("delivery_list");
			if (!StringUtils.isEmpty(deliveryList.getHeadGuid())) {
				this.WHERE("head_guid = '" + deliveryList.getHeadGuid() + "'");
			}
			
			if (!StringUtils.isNumber(deliveryList.getgNum().toString())) {
				this.WHERE("g_num = '" + deliveryList.getgNum() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryList.getLogisticsNo())) {
				this.WHERE("logistics_no = '" + deliveryList.getLogisticsNo() + "'");
			}
		}}.toString();
	}
}

package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

public class InvtDeliverySqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7562474739325718245L;

	public String comparisonDeliveryByLogisticsNoSql(final String logisticsCode, final String logisticsNo, final String headGuid) {
		return new SQL() {{
			this.SELECT("cih.head_guid as invt_head_guid");
			this.SELECT("cdh.head_guid as delivery_head_guid");
			this.SELECT("cdh.voyage_no as delivery_voyage_no");
			this.SELECT("cih.voyage_no as invt_voyage_no");
			this.SELECT("cdh.bill_no as delivery_bill_no");
			this.SELECT("cih.bill_no as invt_bill_no");
			this.SELECT("cdh.traf_mode as delivery_traf_mode");
			this.SELECT("cih.traf_mode as invt_traf_mode");
			this.SELECT("cdh.traf_no as delivery_traf_no");
			this.SELECT("cih.traf_no as invt_traf_no");
			this.SELECT("cih.logistics_code");
			this.SELECT("cih.logistics_no");
			this.FROM("ceb2_invt_head cih");
			this.INNER_JOIN("ceb2_delivery_head cdh on cih.logistics_code = cih.logistics_code");
			this.INNER_JOIN("ceb2_delivery_list cdl on cih.logistics_no = cdl.logistics_no and cdh.head_guid = cdl.head_guid");
			this.WHERE("cih.head_guid = '" + headGuid + "'");
			this.WHERE("cih.logistics_code = '" + logisticsCode + "'");
			this.WHERE("cih.logistics_no = '" + logisticsNo + "'");
			this.ORDER_BY("cdh.head_guid");
		}}.toString();
	}
}

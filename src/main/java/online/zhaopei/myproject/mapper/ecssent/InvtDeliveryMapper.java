package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.InvtDeliveryComparison;
import online.zhaopei.myproject.sqlprovide.ecssent.InvtDeliverySqlProvide;

public interface InvtDeliveryMapper extends Serializable {

	@Results({
		@Result(property = "deliveryHeadGuid", column = "delivery_head_guid"),
		@Result(property = "invtHeadGuid", column = "invt_head_guid"),
		@Result(property = "deliveryVoyageNo", column = "delivery_voyage_no"),
		@Result(property = "invtVoyageNo", column = "invt_voyage_no"),
		@Result(property = "deliveryBillNo", column = "delivery_bill_no"),
		@Result(property = "invtBillNo", column = "invt_bill_no"),
		@Result(property = "deliveryTrafMode", column = "delivery_traf_mode"),
		@Result(property = "invtTrafMode", column = "invt_traf_mode"),
		@Result(property = "deliveryTrafNo", column = "delivery_traf_no"),
		@Result(property = "invtTrafNo", column = "invt_traf_no"),
		@Result(property = "logisticsCode", column = "logistics_code"),
		@Result(property = "logisticsNo", column = "logistics_no"),
	})
	@SelectProvider(type = InvtDeliverySqlProvide.class, method = "comparisonDeliveryByLogisticsNoSql")
	List<InvtDeliveryComparison> comparisonDeliveryByLogisticsNo(String logisticsCode, String logisticsNo, String headGuid);
}

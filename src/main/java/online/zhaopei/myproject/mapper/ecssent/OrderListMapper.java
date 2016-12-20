package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.OrderList;
import online.zhaopei.myproject.sqlprovide.ecssent.OrderListSqlProvide;

public interface OrderListMapper extends Serializable {

	@Results(id = "orderListResult", value = {
		@Result(property = "headGuid", column = "head_guid"),
		@Result(property = "appType", column = "app_type"),
		@Result(property = "appTime", column = "app_time"),
		@Result(property = "appStatus", column = "app_status"),
		@Result(property = "appUid", column = "app_uid"),
		@Result(property = "appUname", column = "app_uname"),
		@Result(property = "appSenderId", column = "app_sender_id"),
		@Result(property = "declTime", column = "decl_time"),
		@Result(property = "orderType", column = "order_type"),
		@Result(property = "orderNo", column = "order_no"),
		@Result(property = "ebpCode", column = "ebp_code"),
		@Result(property = "ebpName", column = "ebp_name"),
		@Result(property = "ebcCode", column = "ebc_code"),
		@Result(property = "ebcName", column = "ebc_name"),
		@Result(property = "goodsValue", column = "goods_value"),
		@Result(property = "freight", column = "freight"),
		@Result(property = "discount", column = "discount"),
		@Result(property = "taxTotal", column = "tax_total"),
		@Result(property = "acturalPaid", column = "actural_paid"),
		@Result(property = "currency", column = "currency"),
		@Result(property = "buyerRegNo", column = "buyer_reg_no"),
		@Result(property = "buyerName", column = "buyer_name"),
		@Result(property = "buyerIdType", column = "buyer_id_type"),
		@Result(property = "buyerIdNumber", column = "buyer_id_number"),
		@Result(property = "payCode", column = "pay_code"),
		@Result(property = "payName", column = "pay_name"),
		@Result(property = "payTransactionId", column = "pay_transaction_id"),
		@Result(property = "batchNumbers", column = "batch_numbers"),
		@Result(property = "consignee", column = "consignee"),
		@Result(property = "consigneeTelephone", column = "consignee_telephone"),
		@Result(property = "consigneeAddress", column = "consignee_address"),
		@Result(property = "consigneeDistrict", column = "consignee_district"),
		@Result(property = "note", column = "note"),
		@Result(property = "msgGuid", column = "msg_guid"),
		@Result(property = "delFlag", column = "del_flag"),
		@Result(property = "sysDays", column = "sys_days"),
		@Result(property = "sysDate", column = "sys_date"),
	})
	@SelectProvider(type = OrderListSqlProvide.class, method = "getOrderListByHeadGuidSql")
	List<OrderList> getOrderListByHeadGuid(String headGuid);
	
	@ResultType(Long.class)
	@SelectProvider(type = OrderListSqlProvide.class, method = "countOrderListSql")
	Long countOrderList(String headGuid);
	
	@ResultMap("orderListResult")
	@SelectProvider(type = OrderListSqlProvide.class, method = "getOrderListBySearchTextSql")
	List<OrderList> getOrderListBySearchText(String headGuid, String searchText);
}

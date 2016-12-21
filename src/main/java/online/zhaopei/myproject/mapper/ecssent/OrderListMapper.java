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
		@Result(property = "gNum", column = "g_num"),
		@Result(property = "itemNo", column = "item_no"),
		@Result(property = "itemName", column = "item_name"),
		@Result(property = "itemDescribe", column = "item_describe"),
		@Result(property = "barCode", column = "bar_code"),
		@Result(property = "unit", column = "unit"),
		@Result(property = "qty", column = "qty"),
		@Result(property = "price", column = "price"),
		@Result(property = "totalPrice", column = "total_price"),
		@Result(property = "currency", column = "currency"),
		@Result(property = "country", column = "country"),
		@Result(property = "note", column = "note"),
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

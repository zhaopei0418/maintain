package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.ecssent.DeliveryList;
import online.zhaopei.myproject.sqlprovide.ecssent.DeliveryListSqlProvide;

public interface DeliveryListMapper extends Serializable {

	@Results(id = "deliveryListResult", value = {
		@Result(property = "headGuid", column = "head_guid", id = true),
		@Result(property = "gNum", column = "g_num", id = true, jdbcType = JdbcType.INTEGER),
		@Result(property = "logisticsNo", column = "logistics_no"),
		@Result(property = "note", column = "note"),
		@Result(property = "sysDate", column = "sys_date", jdbcType = JdbcType.TIMESTAMP)
	})
	@SelectProvider(type = DeliveryListSqlProvide.class, method = "getDeliveryListByGuidSql")
	List<DeliveryList> getDeliveryListByGuid(String headGuid);
	
	@ResultMap("deliveryListResult")
	@SelectProvider(type = DeliveryListSqlProvide.class, method = "getDeliveryListSql")
	List<DeliveryList> getDeliveryList(DeliveryList deliveryList);
}

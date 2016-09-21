package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.ecssent.InvtList;
import online.zhaopei.myproject.sqlprovide.ecssent.InvtListSqlProvide;

public interface InvtListMapper extends Serializable {

	@Results(id = "invtListResult", value = {
		@Result(property = "headGuid", column = "head_guid", id = true),
		@Result(property = "gNum", column = "g_num", jdbcType = JdbcType.INTEGER),
		@Result(property = "itemRecordNo", column = "item_record_no"),
		@Result(property = "itemNo", column = "item_no"),
		@Result(property = "itemName", column = "item_name"),
		@Result(property = "gCode", column = "g_code"),
		@Result(property = "gName", column = "g_name"),
		@Result(property = "gModel", column = "g_model"),
		@Result(property = "barCode", column = "bar_code"),
		@Result(property = "country", column = "country"),
		@Result(property = "currency", column = "currency"),
		@Result(property = "qty", column = "qty", jdbcType = JdbcType.INTEGER),
		@Result(property = "qty1", column = "qty1", jdbcType = JdbcType.INTEGER),
		@Result(property = "qty2", column = "qty2", jdbcType = JdbcType.INTEGER),
		@Result(property = "unit", column = "unit"),
		@Result(property = "unit1", column = "unit_1"),
		@Result(property = "unit2", column = "unit_2"),
		@Result(property = "price", column = "price", jdbcType = JdbcType.DOUBLE),
		@Result(property = "totalPrice", column = "total_price", jdbcType = JdbcType.DOUBLE),
		@Result(property = "note", column = "note"),
		@Result(property = "sysDate", column = "sys_date", jdbcType = JdbcType.TIMESTAMP),
	})
	@SelectProvider(type = InvtListSqlProvide.class, method = "getInvtListListByHeadGuidSql")
	List<InvtList> getInvtListListByHeadGuid(String headGuid);

}

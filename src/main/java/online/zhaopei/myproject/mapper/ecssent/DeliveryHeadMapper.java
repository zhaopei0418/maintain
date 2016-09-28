package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.ecssent.DeliveryHead;
import online.zhaopei.myproject.sqlprovide.ecssent.DeliveryHeadSqlProvide;

public interface DeliveryHeadMapper extends Serializable {

	@Results(id = "deliveryHeadResult", value = {
		@Result(property = "headGuid", column = "head_guid", id = true),
		@Result(property = "appType", column = "app_type"),
		@Result(property = "appTime", column = "app_time", jdbcType = JdbcType.TIMESTAMP),
		@Result(property = "appStatus", column = "app_status"),
		@Result(property = "appUid", column = "app_uid"),
		@Result(property = "appUname", column = "app_uname"),
		@Result(property = "appSenderId", column = "app_sender_id"),
		@Result(property = "declTime", column = "decl_time", jdbcType = JdbcType.TIMESTAMP),
		@Result(property = "customsCode", column = "customs_code"),
		@Result(property = "copNo", column = "cop_no"),
		@Result(property = "preNo", column = "pre_no"),
		@Result(property = "rkdNo", column = "rkd_no"),
		@Result(property = "operatorCode", column = "operator_code"),
		@Result(property = "operatorName", column = "operator_name"),
		@Result(property = "ieFlag", column = "ie_flag"),
		@Result(property = "trafMode", column = "traf_mode"),
		@Result(property = "trafNo", column = "traf_no"),
		@Result(property = "voyageNo", column = "voyage_no"),
		@Result(property = "billNo", column = "bill_no"),
		@Result(property = "logisticsCode", column = "logistics_code"),
		@Result(property = "logisticsName", column = "logistics_name"),
		@Result(property = "unloadLocation", column = "unload_location"),
		@Result(property = "note", column = "note"),
		@Result(property = "delFlag", column = "del_flag", jdbcType = JdbcType.INTEGER),
		@Result(property = "msgGuid", column = "msg_guid"),
		@Result(property = "sysDays", column = "sys_days", jdbcType = JdbcType.INTEGER),
		@Result(property = "sysDate", column = "sys_date", jdbcType = JdbcType.TIMESTAMP),
	})
	@SelectProvider(type = DeliveryHeadSqlProvide.class, method = "getDeliveryHeadListSql")
	List<DeliveryHead> getDeliveryHeadList(DeliveryHead deliveryHead);
}

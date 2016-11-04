package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.LgsHead;
import online.zhaopei.myproject.sqlprovide.ecssent.LgsHeadSqlProvide;

public interface LgsHeadMapper extends Serializable {

	@Results(id = "lgsHeadResult", value = {
		@Result(property = "guid", column = "guid"),
		@Result(property = "appType", column = "app_type"),
		@Result(property = "appTime", column = "app_time"),
		@Result(property = "appStatus", column = "app_status"),
		@Result(property = "appUid", column = "app_uid"),
		@Result(property = "appUname", column = "app_uname"),
		@Result(property = "appSenderId", column = "app_sender_id"),
		@Result(property = "declTime", column = "decl_time"),
		@Result(property = "logisticsCode", column = "logistics_code"),
		@Result(property = "logisticsName", column = "logistics_name"),
		@Result(property = "logisticsNo", column = "logistics_no"),
		@Result(property = "billNo", column = "bill_no"),
		@Result(property = "freight", column = "freight"),
		@Result(property = "insuredFee", column = "insured_fee"),
		@Result(property = "currency", column = "currency"),
		@Result(property = "weight", column = "weight"),
		@Result(property = "packNo", column = "pack_no"),
		@Result(property = "goodsInfo", column = "goods_info"),
		@Result(property = "consignee", column = "consignee"),
		@Result(property = "consigneeAddress", column = "consignee_address"),
		@Result(property = "consigneeTelephone", column = "consignee_telephone"),
		@Result(property = "note", column = "note"),
		@Result(property = "msgGuid", column = "msg_guid"),
		@Result(property = "delFlag", column = "del_flag"),
		@Result(property = "sysDays", column = "sys_days"),
		@Result(property = "sysDate", column = "sys_date"),
	})
	@SelectProvider(type = LgsHeadSqlProvide.class, method = "getLgsHeadListSql")
	List<LgsHead> getLgsHeadList(LgsHead lgsHead);
}

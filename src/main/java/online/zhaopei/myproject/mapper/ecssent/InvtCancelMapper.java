package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.ecssent.InvtCancel;
import online.zhaopei.myproject.sqlprovide.ecssent.InvtCancelSqlProvide;

public interface InvtCancelMapper extends Serializable {

	@Results(id = "invtCancelResult", value = {
		@Result(property = "headGuid", column = "head_guid", id = true),
		@Result(property = "appType", column = "app_type"),
		@Result(property = "appTime", column = "app_time", jdbcType = JdbcType.TIMESTAMP),
		@Result(property = "appStatus", column = "app_status"),
		@Result(property = "appUid", column = "app_uid"),
		@Result(property = "appUname", column = "app_uname"),
		@Result(property = "appSenderId", column = "app_sender_id"),
		@Result(property = "declTime", column = "decl_time"),
		@Result(property = "customsCode", column = "customs_code"),
		@Result(property = "orderNo", column = "order_no"),
		@Result(property = "ebpCode", column = "ebp_code"),
		@Result(property = "ebpName", column = "ebp_name"),
		@Result(property = "ebcCode", column = "ebc_code"),
		@Result(property = "ebcName", column = "ebc_name"),
		@Result(property = "logisticsNo", column = "logistics_no"),
		@Result(property = "logisticsCode", column = "logistics_code"),
		@Result(property = "logisticsName", column = "logistics_name"),
		@Result(property = "copNo", column = "cop_no"),
		@Result(property = "preNo", column = "pre_no"),
		@Result(property = "invtNo", column = "invt_no"),
		@Result(property = "buyerIdType", column = "buyer_id_type"),
		@Result(property = "buyerIdNumber", column = "buyer_id_number"),
		@Result(property = "buyerName", column = "buyer_name"),
		@Result(property = "buyerTelephone", column = "buyer_telephone"),
		@Result(property = "agentCode", column = "agent_code"),
		@Result(property = "agentCode", column = "agent_name"),
		@Result(property = "reason", column = "reason"),
		@Result(property = "note", column = "note"),
		@Result(property = "delFlag", column = "del_flag"),
		@Result(property = "msgGuid", column = "msg_guid"),
		@Result(property = "sysDays", column = "sys_days"),
		@Result(property = "sysDate", column = "sys_date"),
	})
	@SelectProvider(type = InvtCancelSqlProvide.class, method = "getInvtCancelListSql")
	List<InvtCancel> getInvtCancelList(InvtCancel invtCancel);
}

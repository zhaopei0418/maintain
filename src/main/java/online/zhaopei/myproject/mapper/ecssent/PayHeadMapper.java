package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.PayHead;
import online.zhaopei.myproject.sqlprovide.ecssent.PayHeadSqlProvide;

public interface PayHeadMapper extends Serializable {

	@Results(id = "payHeadResult", value = {
		@Result(property = "guid", column = "guid"),
		@Result(property = "appType", column = "app_type"),
		@Result(property = "appTime", column = "app_time"),
		@Result(property = "appStatus", column = "app_status"),
		@Result(property = "appUid", column = "app_uid"),
		@Result(property = "appUname", column = "app_uname"),
		@Result(property = "appSenderId", column = "app_sender_id"),
		@Result(property = "declTime", column = "decl_time"),
		@Result(property = "payCode", column = "pay_code"),
		@Result(property = "payName", column = "pay_name"),
		@Result(property = "payTransactionId", column = "pay_transaction_id"),
		@Result(property = "ordNo", column = "ord_no"),
		@Result(property = "ebpCode", column = "ebp_code"),
		@Result(property = "ebpName", column = "ebpName"),
		@Result(property = "payerIdType", column = "payer_id_type"),
		@Result(property = "payerIdNumber", column = "payer_id_number"),
		@Result(property = "payerName", column = "payer_name"),
		@Result(property = "telephone", column = "telephone"),
		@Result(property = "amountPaid", column = "amount_paid"),
		@Result(property = "currency", column = "currency"),
		@Result(property = "payTime", column = "pay_time"),
		@Result(property = "note", column = "note"),
		@Result(property = "msg_guid", column = "msg_guid"),
		@Result(property = "delFlag", column = "del_flag"),
		@Result(property = "sysDays", column = "sys_days"),
		@Result(property = "sysDate", column = "sys_date"),
	})
	@SelectProvider(type = PayHeadSqlProvide.class, method = "getPayHeadListSql")
	List<PayHead> getPayHeadList(PayHead payHead);
}

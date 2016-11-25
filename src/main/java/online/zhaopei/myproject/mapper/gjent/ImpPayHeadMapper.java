package online.zhaopei.myproject.mapper.gjent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import online.zhaopei.myproject.domain.gjent.ImpPayHead;
import online.zhaopei.myproject.sqlprovide.gjent.ImpPayHeadSqlProvide;

public interface ImpPayHeadMapper extends Serializable {

	@InsertProvider(type = ImpPayHeadSqlProvide.class, method = "insertPayHeadSql")
	int insertPayHead(ImpPayHead impPayHead);
	
	@Results(id = "impPayHeadResult", value = {
		@Result(property = "guid", column = "guid"),
		@Result(property = "appType", column = "app_type"),
		@Result(property = "appTime", column = "app_time"),
		@Result(property = "appStatus", column = "app_status"),
		@Result(property = "appUId", column = "app_uid"),
		@Result(property = "appUName", column = "app_uname"),
		@Result(property = "payCode", column = "pay_code"),
		@Result(property = "payName", column = "pay_name"),
		@Result(property = "payTransactionId", column = "pay_transaction_id"),
		@Result(property = "orderNo", column = "order_no"),
		@Result(property = "ebpCode", column = "ebp_code"),
		@Result(property = "ebpName", column = "ebp_name"),
		@Result(property = "payerIdType", column = "payer_id_type"),
		@Result(property = "payerIdNumber", column = "payer_id_number"),
		@Result(property = "payerName", column = "payer_name"),
		@Result(property = "telephone", column = "telephone"),
		@Result(property = "amountPaid", column = "amount_paid"),
		@Result(property = "currency", column = "currency"),
		@Result(property = "payTime", column = "pay_time"),
		@Result(property = "note", column = "note"),
		@Result(property = "sysDays", column = "sys_days"),
		@Result(property = "sysDate", column = "sys_date"),
		@Result(property = "returnStatus", column = "return_status"),
		@Result(property = "returnTime", column = "return_time"),
		@Result(property = "returnInfo", column = "return_info"),
		@Result(property = "seqno", column = "seqno"),
		@Result(property = "managercustomscode", column = "managercustomscode"),
		@Result(property = "paymenttype", column = "paymenttype"),
		@Result(property = "customerflag", column = "customerflag"),
		@Result(property = "ietype", column = "ietype"),
		@Result(property = "payecode", column = "payecode"),
		@Result(property = "cbecodeinsp", column = "cbecodeinsp"),
		@Result(property = "coininsp", column = "coininsp"),
		@Result(property = "cbecode", column = "cbecode"),
		@Result(property = "cbename", column = "cbename"),
		@Result(property = "billmode", column = "billmode"),
		@Result(property = "basicid", column = "basicid"),
		@Result(property = "approvaldate", column = "approvaldate"),
		@Result(property = "auditstate", column = "auditstate"),
		@Result(property = "applydate", column = "applydate"),
		@Result(property = "uuid", column = "uuid"),
	})
	@SelectProvider(type = ImpPayHeadSqlProvide.class, method = "getImpPayHeadListSql")
	List<ImpPayHead> getImpPayHeadList(ImpPayHead impPayHead);
	
	@ResultType(Long.class)
	@SelectProvider(type = ImpPayHeadSqlProvide.class, method = "countImpPayHeadSql")
	Long countImpPayHead(ImpPayHead impPayHead);
	
	@UpdateProvider(type = ImpPayHeadSqlProvide.class, method = "updateImpPayHeadSql")
	Integer updateImpPayHead(ImpPayHead impPayHead);
}

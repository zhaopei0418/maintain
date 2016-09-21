package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.domain.ecssent.PubRtn;
import online.zhaopei.myproject.domain.gjent.ImpInvtHead;
import online.zhaopei.myproject.sqlprovide.ecssent.InvtHeadSqlProvide;

public interface InvtHeadMapper extends Serializable {

	@Results(id = "invtHeadResult", value = {
		@Result(property = "headGuid", column = "head_guid", id = true),
//		@Result(property = "pubRtnList", javaType = List.class, column = "head_guid",
//			many = @Many(fetchType = FetchType.LAZY,
//				select = "online.zhaopei.myproject.mapper.ecssent.PubRtnMapper.getPubRtnListByBizGuid")),
		@Result(property = "appType", column = "app_type"),
		@Result(property = "appStatus", column = "app_status"),
		@Result(property = "appTime", column = "app_time", jdbcType = JdbcType.TIMESTAMP),
		@Result(property = "sysDate", column = "sys_date", jdbcType = JdbcType.TIMESTAMP),
		@Result(property = "appSenderId", column = "app_sender_id"),
		@Result(property = "orderNo", column = "order_no"),
		@Result(property = "ebcCode", column = "ebc_code"),
		@Result(property = "ebcName", column = "ebc_name"),
		@Result(property = "logisticsNo", column = "logistics_no"),
		@Result(property = "logisticsCode", column = "logistics_code"),
		@Result(property = "logisticsName", column = "logistics_name"),
		@Result(property = "copNo", column = "cop_no"),
		@Result(property = "preNo", column = "pre_no"),
		@Result(property = "invtNo", column = "invt_no"),
		@Result(property = "agentCode", column = "agent_code"),
		@Result(property = "agentName", column = "agent_name"),
		@Result(property = "areaCode", column = "area_code"),
		@Result(property = "areaName", column = "area_name"),
		@Result(property = "distStatus", column = "dist_status"),
		@Result(property = "portCode", column = "port_code"),
		@Result(property = "ebpCode", column = "ebp_code"),
		@Result(property = "ebpName", column = "ebp_name"),
		@Result(property = "ieDate", column = "ie_date"),
		@Result(property = "tradeMode", column = "trade_mode"),
		@Result(property = "emsNo", column = "ems_no"),
		@Result(property = "loctNo", column = "loct_no"),
		@Result(property = "buyerName", column = "buyer_name"),
		@Result(property = "country", column = "country"),
		@Result(property = "trafNo", column = "traf_no"),
		@Result(property = "wrapType", column = "wrap_type"),
		@Result(property = "packNo", column = "pack_no"),
		@Result(property = "buyerIdType", column = "buyer_id_type"),
		@Result(property = "consigneeAddress", column = "consignee_address"),
		@Result(property = "voyageNo", column = "voyage_no"),
		@Result(property = "assureCode", column = "assure_code"),
		@Result(property = "grossWeight", column = "gross_weight"),
		@Result(property = "buyerIdNumber", column = "buyer_id_number"),
		@Result(property = "licenseNo", column = "license_no"),
		@Result(property = "billNo", column = "bill_no"),
		@Result(property = "insuredFee", column = "insured_fee"),
		@Result(property = "netWeight", column = "net_weight"),
		@Result(property = "buyerTelephone", column = "buyer_telephone"),
		@Result(property = "trafMode", column = "traf_mode"),
		@Result(property = "freight", column = "freight"),
		@Result(property = "currency", column = "currency"),
		@Result(property = "note", column = "note"),
		@Result(property = "customsCode", column = "customs_code")
	})
	@SelectProvider(type = InvtHeadSqlProvide.class, method = "getInvtHeadListSql")
	List<InvtHead> getInvtHeadList(InvtHead invtHead);
	
	@ResultMap(value = "invtHeadResult")
	@SelectProvider(type = InvtHeadSqlProvide.class, method = "getInvtHeadByHeadGuidSql")
	InvtHead getInvtHeadByHeadGuid(String headGuid);
}

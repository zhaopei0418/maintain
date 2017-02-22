package online.zhaopei.myproject.mapper.ecssent;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.CheckMailGoodHead;
import online.zhaopei.myproject.sqlprovide.ecssent.CheckMailGoodHeadSqlProvide;

public interface CheckMailGoodHeadMapper {

	@Results(id = "checkMailGoodHeadResult", value = {
		@Result(property = "seqNo", column = "seq_no"),
		@Result(property = "entryId", column = "entry_id"),
		@Result(property = "ieFlage", column = "ie_flage"),
		@Result(property = "orderNo", column = "order_no"),
		@Result(property = "logisticsNo", column = "logistics_no"),
		@Result(property = "logisticsName", column = "logistics_name"),
		@Result(property = "logisticsCode", column = "logistics_code"),
		@Result(property = "ecpCode", column = "ecp_code"),
		@Result(property = "ecpName", column = "ecp_name"),
		@Result(property = "wrapType", column = "wrap_type"),
		@Result(property = "packNum", column = "pack_num"),
		@Result(property = "grossWt", column = "gross_wt"),
		@Result(property = "netWt", column = "net_wt"),
		@Result(property = "goodsValue", column = "goods_value"),
		@Result(property = "freight", column = "freight"),
		@Result(property = "controlledStatus", column = "controlled_status"),
		@Result(property = "controlledDate", column = "controlled_date"),
		@Result(property = "operator", column = "operator"),
		@Result(property = "messageTime", column = "message_time"),
		@Result(property = "note", column = "note"),
		@Result(property = "indbTime", column = "indb_time"),
		@Result(property = "updateTime", column = "update_time"),
		@Result(property = "checkDate", column = "check_date"),
		@Result(property = "checkType", column = "check_type"),
		@Result(property = "checkMan", column = "check_man"),
		@Result(property = "checkOpinion", column = "check_opinion"),
		@Result(property = "customsCode", column = "customs_code"),
		@Result(property = "checkResult", column = "check_result"),
		@Result(property = "conductResult", column = "conduct_result"),
		@Result(property = "checkMan2", column = "check_man2"),
		@Result(property = "consignee", column = "consignee"),
		@Result(property = "shipper", column = "shipper"),
		@Result(property = "status", column = "status"),
		@Result(property = "ifCheckInsp", column = "if_check_insp"),
		@Result(property = "ifMachine", column = "if_machine"),
		@Result(property = "currCode", column = "curr_code"),
		@Result(property = "statusInsp", column = "status_insp"),
		@Result(property = "opType", column = "op_type"),
		@Result(property = "opTypeInsp", column = "op_type_insp"),
		@Result(property = "zydCode", column = "zyd_code"),
	})
	@SelectProvider(type = CheckMailGoodHeadSqlProvide.class, method = "getCheckMailGoodHeadListSql")
	List<CheckMailGoodHead> getCheckMailGoodHeadList(CheckMailGoodHead checkMailGoodHead);
}

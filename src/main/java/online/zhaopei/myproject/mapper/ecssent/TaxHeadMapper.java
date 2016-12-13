package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.TaxHead;
import online.zhaopei.myproject.sqlprovide.ecssent.TaxHeadSqlProvide;

public interface TaxHeadMapper extends Serializable {

	@Results(id = "taxHeadResult", value = {
		@Result(property = "headGuid", column = "head_guid"),
		@Result(property = "returnTime", column = "return_time"),
		@Result(property = "customsCode", column = "customs_code"),
		@Result(property = "invtNo", column = "invt_no"),
		@Result(property = "taxNo", column = "tax_no"),
		@Result(property = "taxTotal", column = "tax_total"),
		@Result(property = "customsTax", column = "customs_tax"),
		@Result(property = "valueAddedTax", column = "value_added_tax"),
		@Result(property = "consumptionTax", column = "consumption_tax"),
		@Result(property = "status", column = "status"),
		@Result(property = "entDutyNo", column = "ent_duty_no"),
		@Result(property = "note", column = "note"),
		@Result(property = "idNumber", column = "id_number"),
		@Result(property = "assureCode", column = "assure_code"),
		@Result(property = "ebcCode", column = "ebc_code"),
		@Result(property = "logisticsCode", column = "logistics_code"),
		@Result(property = "delFlag", column = "del_flag"),
		@Result(property = "msgGuid", column = "msg_guid"),
		@Result(property = "sysDays", column = "sys_days"),
		@Result(property = "sysDate", column = "sys_date"),
		@Result(property = "agentCode", column = "agent_code"),
	})
	@SelectProvider(type = TaxHeadSqlProvide.class, method = "getTaxHeadListSql")
	List<TaxHead> getTaxHeadList(TaxHead taxHead);
}

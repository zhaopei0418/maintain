package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import online.zhaopei.myproject.domain.ecssent.DistBillList;
import online.zhaopei.myproject.sqlprovide.ecssent.DistBillListSqlProvide;

public interface DistBillListMapper extends Serializable {

	@Results(id = "distBillListResult", value = {
		@Result(property = "seqNo", column = "seq_no"),
		@Result(property = "distNo", column = "dist_no"),
		@Result(property = "billNo", column = "bill_no"),
		@Result(property = "billType", column = "bill_type"),
		@Result(property = "entryId", column = "entry_id"),
		@Result(property = "lmsSeqNo", column = "lms_seq_no"),
		@Result(property = "lmsNo", column = "lms_no"),
		@Result(property = "packNum", column = "pack_num"),
		@Result(property = "grossWt", column = "gross_wt"),
		@Result(property = "netWt", column = "net_wt"),
		@Result(property = "gName", column = "g_name"),
		@Result(property = "tradeCode", column = "trade_code"),
		@Result(property = "tradeName", column = "trade_name"),
		@Result(property = "declCode", column = "decl_code"),
		@Result(property = "declName", column = "decl_name"),
		@Result(property = "ownerCode", column = "owner_code"),
		@Result(property = "ownerName", column = "owner_name"),
		@Result(property = "iePort", column = "i_e_port"),
		@Result(property = "turnNo", column = "turn_no"),
		@Result(property = "trafMode", column = "traf_mode"),
		@Result(property = "tradeMode", column = "trade_mode"),
		@Result(property = "billId", column = "bill_id"),
		@Result(property = "customsCode", column = "customs_code"),
		@Result(property = "note", column = "note"),
		@Result(property = "decStatus", column = "dec_status"),
		@Result(property = "decLogStat", column = "dec_log_stat"),
		@Result(property = "arrivalFlag", column = "arrival_flag"),
		@Result(property = "gValue", column = "g_value"),
		@Result(property = "modifyMark", column = "modify_mark"),
		@Result(property = "inputDate", column = "input_date"),
		@Result(property = "invtHead", column = "bill_no", 
				one = @One(fetchType = FetchType.LAZY,
				select = "online.zhaopei.myproject.mapper.ecssent.InvtHeadMapper.getInvtHeadByInvtNo")),
	})
	@SelectProvider(type = DistBillListSqlProvide.class, method = "getDistBillListListSql")
	List<DistBillList> getDistBillListList(String seqNo);
	
	@ResultType(Long.class)
	@SelectProvider(type = DistBillListSqlProvide.class, method = "countDistBillListSql")
	Long countDistBillList(String seqNo);
	
	@ResultMap("distBillListResult")
	@SelectProvider(type = DistBillListSqlProvide.class, method = "getDistBillListListBySearchTextSql")
	List<DistBillList> getDistBillListListBySearchText(String seqNo, String searchText);
}

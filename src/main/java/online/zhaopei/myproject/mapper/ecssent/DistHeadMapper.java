package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.service.ecssent.DistHeadService;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import online.zhaopei.myproject.domain.ecssent.DistHead;
import online.zhaopei.myproject.sqlprovide.ecssent.DistHeadSqlProvide;

public interface DistHeadMapper extends Serializable {

	@Results(id = "distHeadResult", value = {
		@Result(property = "seqNo", column = "seq_no", id = true),
		@Result(property = "distNo", column = "dist_no"),
		@Result(property = "copDistNo", column = "cop_dist_no"),
		@Result(property = "customsCode", column = "customs_code"),
		@Result(property = "distType", column = "dist_type"),
		@Result(property = "cfsCode", column = "cfs_code"),
		@Result(property = "ieFlag", column = "i_e_flag"),
		@Result(property = "ieType", column = "i_e_type"),
		@Result(property = "billType", column = "bill_type"),
		@Result(property = "totalPackNum", column = "total_pack_num"),
		@Result(property = "totalGrossWt", column = "total_gross_wt"),
		@Result(property = "totalNetWt", column = "total_net_wt"),
		@Result(property = "totalGValue", column = "total_g_value"),
		@Result(property = "declCode", column = "decl_code"),
		@Result(property = "declName", column = "decl_name"),
		@Result(property = "districtCode", column = "district_code"),
		@Result(property = "ieFlag1", column = "i_e_flag_1"),
		@Result(property = "dischargeCode", column = "discharge_code"),
		@Result(property = "ieFlag2", column = "i_e_flag_2"),
		@Result(property = "inputPerson", column = "input_person"),
		@Result(property = "distStat", column = "dist_stat"),
		@Result(property = "inputDate", column = "input_date"),
		@Result(property = "declDate", column = "decl_date"),
		@Result(property = "billSum", column = "bill_sum"),
		@Result(property = "veSum", column = "ve_sum"),
		@Result(property = "modifyMark", column = "modify_mark"),
		@Result(property = "apprDate", column = "appr_date"),
		@Result(property = "apprStat", column = "appr_stat"),
		@Result(property = "note", column = "note"),
		@Result(property = "returnReason", column = "return_reason"),
		@Result(property = "iePort", column = "i_e_port"),
		@Result(property = "veNo", column = "ve_no"),
//		@Result(property = "veHead", column = "ve_no",
//				one = @One(fetchType = FetchType.LAZY,
//					select = "online.zhaopei.myproject.mapper.ecssent.VeHeadMapper.getVeHeadByVeNo")),
//		@Result(property = "distBillListList", column = "seq_no",
//				many = @Many(fetchType = FetchType.LAZY,
//					select = "online.zhaopei.myproject.mapper.ecssent.DistBillListMapper.getDistBillListList"))
	})
	@SelectProvider(type = DistHeadSqlProvide.class, method = "getDistHeadByInvtNoSql")
	DistHead getDistHeadByInvtNo(String invtNo);
	
	@ResultMap("distHeadResult")
	@SelectProvider(type = DistHeadSqlProvide.class, method = "getDistHeadListSql")
	List<DistHead> getDistHeadList(DistHead distHead);
	
	@ResultMap("distHeadResult")
	@SelectProvider(type = DistHeadSqlProvide.class, method = "getDistHeadBySeqNoSql")
	DistHead getDistHeadBySeqNo(String seqNo);

	@UpdateProvider(type = DistHeadSqlProvide.class, method = "calculationPackWtSql")
	Integer calculationPackWt(String distNo);
}

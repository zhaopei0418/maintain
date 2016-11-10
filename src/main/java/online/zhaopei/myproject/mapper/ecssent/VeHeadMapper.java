package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.VeHead;
import online.zhaopei.myproject.sqlprovide.ecssent.VeHeadSqlProvide;

public interface VeHeadMapper extends Serializable {

	@Results(id = "veHeadResult", value = {
		@Result(property = "veId", column = "ve_id"),
		@Result(property = "veNo", column = "ve_no"),
		@Result(property = "customsCode", column = "customs_code"),
		@Result(property = "veIdAd", column = "ve_id_ad"),
		@Result(property = "veType", column = "ve_type"),
		@Result(property = "bizType", column = "biz_type"),
		@Result(property = "surveilType", column = "surveil_type"),
		@Result(property = "veWt", column = "ve_wt"),
		@Result(property = "veLoadWt", column = "ve_load_wt"),
		@Result(property = "veOwner", column = "ve_owner"),
		@Result(property = "veRunNum", column = "ve_run_num"),
		@Result(property = "linkTel", column = "link_tel"),
		@Result(property = "veCopId", column = "ve_cop_id"),
		@Result(property = "veCopName", column = "ve_cop_name"),
		@Result(property = "icCardId", column = "ic_card_id"),
		@Result(property = "veName", column = "ve_name"),
		@Result(property = "veCode", column = "ve_code"),
		@Result(property = "veEno", column = "ve_e_no"),
		@Result(property = "markExtend1", column = "mark_extend1"),
		@Result(property = "markExtend1", column = "mark_extend2"),
		@Result(property = "markExtend1", column = "mark_extend3"),
		@Result(property = "distNo", column = "dist_no"),
		@Result(property = "declCode", column = "decl_code"),
		@Result(property = "declName", column = "decl_name"),
		@Result(property = "inputPerson", column = "input_person"),
		@Result(property = "inputDate", column = "input_date"),
		@Result(property = "declDate", column = "decl_date"),
		@Result(property = "apprDate", column = "appr_date"),
		@Result(property = "apprPerson", column = "appr_person"),
		@Result(property = "apprStat", column = "appr_stat"),
		@Result(property = "veStat", column = "ve_stat"),
		@Result(property = "apprNote", column = "appr_note"),
		@Result(property = "freeFlag", column = "free_flag"),
		@Result(property = "regMode", column = "reg_mode"),
		@Result(property = "operFlag", column = "oper_flag"),
		@Result(property = "hostId", column = "host_id"),
		@Result(property = "modifyMark", column = "modify_mark"),
		@Result(property = "appr2Note", column = "appr2_note"),
		@Result(property = "note", column = "note"),
		@Result(property = "appr2Person", column = "appr2_person"),
	})
	@SelectProvider(type = VeHeadSqlProvide.class, method = "getVeHeadListSql")
	List<VeHead> getVeHeadList(VeHead veHead);
	
	@ResultMap("veHeadResult")
	@SelectProvider(type = VeHeadSqlProvide.class, method = "getVeHeadByVeNoSql")
	VeHead getVeHeadByVeNo(String veNo);
}

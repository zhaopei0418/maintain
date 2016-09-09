package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.ecssent.DistHead;
import online.zhaopei.myproject.sqlprovide.ecssent.DistHeadSqlProvide;

public interface DistHeadMapper extends Serializable {

	@Results(id = "distHeadResult", value = {
		@Result(property = "seqNo", column = "seq_no", id = true),
		@Result(property = "distNo", column = "dist_no"),
		@Result(property = "customsCode", column = "customs_code"),
		@Result(property = "declCode", column = "decl_code"),
		@Result(property = "declName", column = "decl_name"),
		@Result(property = "distStat", column = "dist_stat"),
		@Result(property = "inputDate", column = "input_date", jdbcType = JdbcType.DATE),
		@Result(property = "declDate", column = "decl_date", jdbcType = JdbcType.DATE),
		@Result(property = "returnReason", column = "return_reason"),
		@Result(property = "note", column = "note")
	})
	@SelectProvider(type = DistHeadSqlProvide.class, method = "getDistHeadByInvtNoSql")
	DistHead getDistHeadByInvtNo(String invtNo);
}

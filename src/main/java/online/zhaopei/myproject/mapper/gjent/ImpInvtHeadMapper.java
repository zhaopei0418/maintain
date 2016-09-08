package online.zhaopei.myproject.mapper.gjent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.gjent.ImpInvtHead;
import online.zhaopei.myproject.sqlprovide.gjent.ImpInvtHeadSqlProvide;

public interface ImpInvtHeadMapper extends Serializable {

	@Results(id = "impInvtHeadResult", value = {
		@Result(property = "guid", column = "guid", id = true),
		@Result(property = "preNo", column = "pre_no"),
		@Result(property = "invtNo", column = "invt_no"),
		@Result(property = "detailsCode", column = "detailscode"),
		@Result(property = "applyCode", column = "applycode"),
		@Result(property = "auditState", column = "audit_state"),
		@Result(property = "bwName", column = "bw_name"),
		@Result(property = "applyDate", column = "apply_date", jdbcType = JdbcType.TIMESTAMP),
		@Result(property = "payCode", column = "payecode"),
		@Result(property = "payName", column = "payename")
	})
	@SelectProvider(type = ImpInvtHeadSqlProvide.class, method = "getInvtHeadListByInvtNoSql")
	List<ImpInvtHead> getInvtHeadListByInvtNo(String invtNo);
}

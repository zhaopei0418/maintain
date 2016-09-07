package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.ecssent.PubRtn;
import online.zhaopei.myproject.sqlprovide.ecssent.PubRtnSqlProvide;

public interface PubRtnMapper extends Serializable {

	@Results(id = "pubRtnResult", value = {
		@Result(property = "msgGuid", column = "msg_guid", id = true),
		@Result(property = "bizType", column = "biz_type"),
		@Result(property = "bizGuid", column = "biz_guid"),
		@Result(property = "preNo", column = "pre_no"),
		@Result(property = "h2kNo", column = "h2k_no"),
		@Result(property = "appStatus", column = "app_status"),
		@Result(property = "rtnStatus", column = "rtn_status"),
		@Result(property = "rtnTime", column = "rtn_time", jdbcType = JdbcType.TIMESTAMP),
		@Result(property = "rtnInfo", column = "rtn_info"),
		@Result(property = "note", column = "note"),
		@Result(property = "sysDays", column = "sys_days", jdbcType = JdbcType.INTEGER),
		@Result(property = "sysDate", column = "sys_date", jdbcType = JdbcType.TIMESTAMP)
	})
	@SelectProvider(type = PubRtnSqlProvide.class, method = "getPubRtnListByBizGuidSql")
	List<PubRtn> getPubRtnListByBizGuid(String bizGuid);
}

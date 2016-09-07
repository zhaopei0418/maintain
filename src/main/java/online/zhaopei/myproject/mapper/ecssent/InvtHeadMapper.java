package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.domain.ecssent.PubRtn;
import online.zhaopei.myproject.sqlprovide.ecssent.InvtHeadSqlProvide;

public interface InvtHeadMapper extends Serializable {

	@Results(id = "invtHeadResult", value = {
		@Result(property = "headGuid", column = "head_guid", id = true),
		@Result(property = "pubRtnList", javaType = List.class, column = "head_guid",
			many = @Many(fetchType = FetchType.LAZY,
				select = "online.zhaopei.myproject.mapper.ecssent.PubRtnMapper.getPubRtnListByBizGuid")),
		@Result(property = "appStatus", column = "app_status"),
		@Result(property = "appTime", column = "app_time", jdbcType = JdbcType.TIMESTAMP),
		@Result(property = "appSenderId", column = "app_sender_id"),
		@Result(property = "orderNo", column = "order_no"),
		@Result(property = "ebcCode", column = "ebc_code"),
		@Result(property = "ebcName", column = "ebc_name"),
		@Result(property = "logisticsNo", column = "logistics_no"),
		@Result(property = "logisticsCode", column = "logistics_code"),
		@Result(property = "logisticsName", column = "logistics_name"),
		@Result(property = "copNo", column = "cop_no"),
		@Result(property = "invtNo", column = "invt_no"),
		@Result(property = "agentCode", column = "agent_code"),
		@Result(property = "agentName", column = "agent_name"),
		@Result(property = "areaCode", column = "area_code"),
		@Result(property = "areaName", column = "area_name"),
		@Result(property = "distStatus", column = "dist_status"),
	})
	@SelectProvider(type = InvtHeadSqlProvide.class, method = "getInvtHeadListSql")
	List<InvtHead> getInvtHeadList(InvtHead invtHead);
}

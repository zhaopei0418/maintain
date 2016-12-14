package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.DxpReceEnd;
import online.zhaopei.myproject.sqlprovide.ecssent.DxpReceEndSqlProvide;

public interface DxpReceEndMapper extends Serializable {

	@Results(id = "dxpReceEndResult", value = {
		@Result(property = "msgGuid", column = "msg_guid"),
		@Result(property = "dxpMode", column = "dxp_mode"),
		@Result(property = "dxpStatus", column = "dxp_status"),
		@Result(property = "dxpHost", column = "dxp_host"),
		@Result(property = "msgType", column = "msg_type"),
		@Result(property = "msgName", column = "msg_name"),
		@Result(property = "msgId", column = "msg_Id"),
		@Result(property = "msgKey", column = "msg_key"),
		@Result(property = "msgTime", column = "msg_time"),
		@Result(property = "sendAd", column = "send_ad"),
		@Result(property = "receAd", column = "rece_ad"),
		@Result(property = "note", column = "note"),
		@Result(property = "sysDays", column = "sys_days"),
		@Result(property = "sysDate", column = "sys_date"),
	})
	@SelectProvider(type = DxpReceEndSqlProvide.class, method = "getDxpReceEndListSql")
	List<DxpReceEnd> getDxpReceEndList(DxpReceEnd dxpReceEnd);
}

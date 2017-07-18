package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.sql.Blob;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import online.zhaopei.myproject.domain.ecssent.DxpReceMsg;
import online.zhaopei.myproject.sqlprovide.ecssent.DxpReceMsgSqlProvide;

public interface DxpReceMsgMapper extends Serializable {

	@Results(id = "dxpReceMsgResult", value = {
		@Result(property = "msgGuid", column = "msg_guid"),
		@Result(property = "encoding", column = "encoding"),
		@Result(property = "msgSize", column = "msg_size"),
		@Result(property = "msgBlob", column = "msg_blob"),
		@Result(property = "bizBlob", column = "biz_blob"),
		@Result(property = "note", column = "note"),
		@Result(property = "sysDays", column = "sys_days"),
		@Result(property = "sysDate", column = "sys_date"),
	})
	@SelectProvider(type = DxpReceMsgSqlProvide.class, method = "getDxpReceMsgByMsgGuidSql")
	DxpReceMsg getDxpReceMsgByMsgGuid(String msgGuid);
}

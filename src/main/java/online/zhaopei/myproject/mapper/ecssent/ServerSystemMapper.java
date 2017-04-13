package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import online.zhaopei.myproject.domain.ecssent.ServerSystem;
import online.zhaopei.myproject.sqlprovide.ecssent.ServerSystemSqlProvide;

public interface ServerSystemMapper extends Serializable {

	@SelectProvider(type = ServerSystemSqlProvide.class, method = "getServerSystemListSql")
	List<ServerSystem> getServerSystemList(ServerSystem serverSystem);
	
	@SelectProvider(type = ServerSystemSqlProvide.class, method = "getServerSystemByIpSql")
	ServerSystem getServerSystemByIp(String ip);
	
	@InsertProvider(type = ServerSystemSqlProvide.class, method = "insertServerSystemSql")
	int insertServerSystem(ServerSystem serverSystem);
	
	@UpdateProvider(type = ServerSystemSqlProvide.class, method = "updateServerSystemSql")
	int updateServerSystem(ServerSystem serverSystem);
	
	@DeleteProvider(type = ServerSystemSqlProvide.class, method = "deleteServerSystemSql")
	int deleteServerSystem(String ip);
}
